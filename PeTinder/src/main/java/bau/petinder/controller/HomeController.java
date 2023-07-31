package bau.petinder.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import bau.petinder.model.CustomerOverviewModel;

public class HomeController {

	@GetMapping({ "/"})
	public ModelAndView Index() {
		return new ModelAndView("redirect:/dashboard");
	}
	
}
