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

import java.util.List;

import bau.petinder.factory.CustomerModelFactory;
import bau.petinder.model.CustomerModel;
import bau.petinder.model.CustomerOverviewModel;
import bau.petinder.service.CustomerService;
import bau.petinder.service.PetService;
import bau.petinder.service.WorkContextService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@Autowired
	private PetService petService;
	
	@Autowired
	private WorkContextService workContext;
	
	private CustomerModelFactory customerModelFactory = new CustomerModelFactory();
	
	@GetMapping({ "/admin/customer/list", "customer-list.html" })
	public ModelAndView customerList() {
		
		var activeCustomer = workContext.GetCurrentCustomer();
		
		if (activeCustomer == null || activeCustomer.isAdmin() == false) {
	        return new ModelAndView("redirect:/login");
	    }
		
		ModelAndView mv = new ModelAndView("customer-list");
		
		var customers = service.GetAll();
		
		var model = customerModelFactory.prepareCustomerListModel(customers, petService);
		
		mv.addObject("customerOverviewList", model);
		
		return mv;
	}
	
	@GetMapping({ "/my-information", "customer-information.html" })
	public ModelAndView myInformation() {
		
		var activeCustomer = workContext.GetCurrentCustomer();
		
		if (activeCustomer == null) {
	        return new ModelAndView("redirect:/login");
	    }
		
		ModelAndView mv = new ModelAndView("my-information");
		
		var model = new CustomerModel();
		
		customerModelFactory.PrepareCustomerModel(model, activeCustomer);
		
		mv.addObject("customerModel", model);
		
		return mv;
	}
	
	@GetMapping("/setLanguage/{langCode}")
	public ModelAndView edit(@PathVariable String langCode) {
		
		workContext.setActiveLanguage(langCode);
		
		return new ModelAndView("redirect:/dashboard?language=" + langCode);		
	}
	
}
