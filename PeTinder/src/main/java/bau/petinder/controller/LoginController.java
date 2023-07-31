package bau.petinder.controller;

import jakarta.validation.Valid;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import bau.petinder.domain.Customer;
import bau.petinder.model.LoginModel;
import bau.petinder.model.RegisterModel;
import bau.petinder.service.CustomerService;
import bau.petinder.service.WorkContextService;

@Controller
public class LoginController {

	@Autowired
	private WorkContextService workContext;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping({ "/login", "login.html" })
	public ModelAndView displayForm() {
		
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("loginModel", new LoginModel());

		return mv;
	}
	
	@PostMapping("/login")
	public ModelAndView processForm(@Valid @ModelAttribute LoginModel loginModel, BindingResult result) {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("loginModel", loginModel);

		if (result.hasErrors())
			mv.setViewName("login");
		else {
			var customer = customerService.TryLogin(loginModel.getMail(), loginModel.getPassword());
			
			if(customer == null) {
				loginModel.setHasError(true);
				
				return mv;
				
			}
			else {
				
				customer.setLastLoginDateUtc(LocalDate.now());
				customerService.Update(customer);
				
				workContext.SetCurrentCustomer(customer);
				return new ModelAndView("redirect:/dashboard");
			}
		}

		return mv;
	}
	
	@GetMapping({ "/logout" })
	public ModelAndView logout() {
		
		workContext.Logout();
		
		return new ModelAndView("redirect:/login");
	}
	
	@GetMapping({ "/register", "register.html" })
	public ModelAndView register() {
			
		ModelAndView mv = new ModelAndView("register");
		mv.addObject("registerModel", new RegisterModel());

		return mv;
	}
	
	@PostMapping("/register")
	public ModelAndView processForm(@Valid @ModelAttribute RegisterModel model, BindingResult result) {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("registerModel", model);

		if (result.hasErrors())
			mv.setViewName("register");
		else {
			
			var customer = customerService.GetByEmail(model.getEmail());
			
			if(customer == null) {
				
				customer = new Customer();
				customer.setFirstName(model.getFirstName());
				customer.setLastName(model.getLastName());
				customer.setEmail(model.getEmail());
				customer.setPhone(model.getPhone());
				customer.setActive(true);
				customer.setCreatedOnUtc(LocalDate.now());
				customer.setLastLoginDateUtc(LocalDate.now());
				customer.setIsAdmin(false);
				customer.setPassword(model.getPassword());
				customer.setAdditionalInformation(model.getAdditionalInformation());
				
				customerService.Create(customer);
				
				customer = customerService.GetByEmail(model.getEmail());
			}
			
			workContext.SetCurrentCustomer(customer);
			return new ModelAndView("redirect:/dashboard");
			
			
		}

		return mv;
	}
	
}
