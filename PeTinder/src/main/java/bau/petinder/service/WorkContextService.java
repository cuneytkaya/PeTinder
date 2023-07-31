package bau.petinder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.LocaleResolver;

import bau.petinder.dao.CustomerRepository;
import bau.petinder.dao.WorkContextRepository;
import bau.petinder.domain.Customer;
import bau.petinder.domain.WorkContext;

@Service
public class WorkContextService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private WorkContextRepository workContextRepository;
	
	
	private WorkContext GetWorkContext() {
		
		return workContextRepository.GetWorkContext();
		
	}
	
	public Customer GetCurrentCustomer() {
		
		var workContext = GetWorkContext();
		
		int customerId = workContext.getActiveCustomerId();
		
		if (customerId > 0) {
			
			var customer = customerRepository.GetById(customerId);
			
			return customer;
			
		}
		
		return null;
	}
	
	public void SetCurrentCustomer(Customer customer) {
		
		if(customer != null) {
			
			workContextRepository.SetCurrentCustomer(customer);
			
		}
	}
	
	public String getActiveLanguage() {
		
        var context = workContextRepository.GetWorkContext();
        
        return context.getActiveLanguageCode();
    }
	
	public void setActiveLanguage(String langCode) {
		
		workContextRepository.SetCurrentLanguageCode(langCode);
		
	}
	
	public void Logout() {
		
		workContextRepository.Logout();
		
	}
	
}
