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

import bau.petinder.factory.CustomerModelFactory;
import bau.petinder.model.CustomerOverviewModel;
import bau.petinder.model.LoginModel;
import bau.petinder.service.CustomerService;
import bau.petinder.service.PetService;
import bau.petinder.service.WorkContextService;

@Controller
public class DashboardController {
	
	@Autowired
	private WorkContextService workContext;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private PetService petService;
	
	private CustomerModelFactory customerModelFactory = new CustomerModelFactory();
	
	@GetMapping({ "/dashboard", "dashboard.html" })
	public ModelAndView displayForm() {
		
		var activeCustomer = workContext.GetCurrentCustomer();
		
		if (activeCustomer == null) {
	        return new ModelAndView("redirect:/login");
	    }
		
		ModelAndView mv = new ModelAndView("dashboard");
		
		var model = new CustomerOverviewModel();
		customerModelFactory.prepareCustomerOverviewModel(model, activeCustomer);
		
		model.setPetCount(petService.GetAll(activeCustomer.getId()).size());
		model.setActiveLanguageCode(workContext.getActiveLanguage());
		
		mv.addObject("customerOverviewModel", model);

		return mv;
	}
	
}
