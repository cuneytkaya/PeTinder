package bau.petinder.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import bau.petinder.domain.Pet;
import bau.petinder.model.LoginModel;
import bau.petinder.service.CustomerService;
import bau.petinder.service.PetService;
import bau.petinder.service.WorkContextService;

import java.time.LocalDate;
import java.util.List;

@Controller
public class PetController {

	@Autowired
	private PetService petService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private WorkContextService workContext;
	
	@GetMapping({ "/pet/mypets", "my-pets.html" })
	public ModelAndView myPets() {
		
		var activeCustomer = workContext.GetCurrentCustomer();
		
		if (activeCustomer == null) {
	        return new ModelAndView("redirect:/login");
	    }
		
		ModelAndView mv = new ModelAndView("my-pets.html");
		
		var pets = petService.GetAll(activeCustomer.Id);
		
		mv.addObject("pets", pets);
		
		return mv;
	}
	
	@GetMapping("/pet/delete/{petId}")
	public ModelAndView delete(@PathVariable Integer petId) {
		
		var activeCustomer = workContext.GetCurrentCustomer();
		
		if (activeCustomer == null) {
	        return new ModelAndView("redirect:/login");
	    }
		
		var pet = petService.GetById(petId);
		
		if(pet != null || pet.getCustomerId() == activeCustomer.Id) {
			petService.Delete(petId);
		}
		
		return new ModelAndView("redirect:/pet/mypets");
		
	}
	
	@GetMapping("/pet/edit/{petId}")
	public ModelAndView edit(@PathVariable Integer petId) {
		
		var activeCustomer = workContext.GetCurrentCustomer();
		
		if (activeCustomer == null) {
	        return new ModelAndView("redirect:/login");
	    }
		
		var pet = petService.GetById(petId);
		
		if(pet == null || pet.getCustomerId() != activeCustomer.Id) {
			return new ModelAndView("redirect:/pet/mypets");
		}
		
		ModelAndView mv = new ModelAndView("pet-details.html");
		
		mv.addObject("pet", pet);
		
		return mv;
		
	}
	
	@PostMapping("/save-pet-data")
	public ModelAndView edit(@Valid @ModelAttribute Pet model, BindingResult result) {
		
		var activeCustomer = workContext.GetCurrentCustomer();
		
		if (activeCustomer == null) {
	        return new ModelAndView("redirect:/login");
	    }
		
		var pet = petService.GetById(model.Id);
		
		if(pet == null || pet.getCustomerId() != activeCustomer.Id) {
			return new ModelAndView("redirect:/pet/mypets");
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("pet", model);

		if (result.hasErrors())
			mv.setViewName("pet-details.html");
		else {
			petService.Update(model);
			return new ModelAndView("redirect:/pet/mypets");
		}

		return mv;
	}
	
	@GetMapping("/pet/create")
	public ModelAndView create() {
	    var activeCustomer = workContext.GetCurrentCustomer();

	    if (activeCustomer == null) {
	        return new ModelAndView("redirect:/login");
	    }

	    ModelAndView mv = new ModelAndView("create-pet.html");
	    var model = new Pet();
	    model.setDateOfBirth(LocalDate.now());
	    mv.addObject("pet", model);

	    return mv;
	}

	@PostMapping("/create-pet")
	public ModelAndView save(@Valid @ModelAttribute Pet model, BindingResult result) {
	    
		var activeCustomer = workContext.GetCurrentCustomer();

	    if (activeCustomer == null) {
	        return new ModelAndView("redirect:/login");
	    }

	    ModelAndView mv = new ModelAndView();
	    mv.addObject("pet", model);
	    
	    if (result.hasErrors()) {
	        mv.setViewName("create-pet.html");
	    } else {
	        model.setCustomerId(activeCustomer.getId());
	        petService.Create(model);
	        return new ModelAndView("redirect:/pet/mypets");
	    }

	    return mv;
	}
}
