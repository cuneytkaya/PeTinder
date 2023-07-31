package bau.petinder.factory;


import java.util.ArrayList;
import java.util.List;

import bau.petinder.domain.Customer;
import bau.petinder.model.CustomerModel;
import bau.petinder.model.CustomerOverviewModel;
import bau.petinder.service.PetService;

public class CustomerModelFactory {

	public CustomerModel PrepareCustomerModel(CustomerModel model, Customer customer) {
		
		model.setFirstName(customer.getFirstName());
		model.setLastName(customer.getLastName());
		model.setEmail(customer.getEmail());
		model.setPhone(customer.getPhone());
		model.setActive(customer.isActive());
		model.setCreatedOnUtc(customer.getCreatedOnUtc());
		model.setLastLoginDateUtc(customer.getLastLoginDateUtc());
		model.setAdmin(customer.isAdmin());
		model.setAdditionalInformation(customer.getAdditionalInformation());
        
		return model;
	}
	
	public CustomerOverviewModel prepareCustomerOverviewModel(CustomerOverviewModel model, Customer customer) {
	    model.setFullName(customer.getFirstName() + " " + customer.getLastName());
	    model.setEmail(customer.getEmail());
	    model.setPhone(customer.getPhone());
	    model.setAdditionalInformation(customer.getAdditionalInformation());
	    model.setAdmin(customer.isAdmin());

	    return model;
	}

	public List<CustomerOverviewModel> prepareCustomerListModel(List<Customer> customers, PetService petservice) {
	    List<CustomerOverviewModel> model = new ArrayList<>();

	    for (Customer customer : customers) {
	    	
	    	var pets = petservice.GetAll(customer.getId());
	    	
	        CustomerOverviewModel tempModel = new CustomerOverviewModel();
	        prepareCustomerOverviewModel(tempModel, customer);
	        tempModel.setPetCount(pets.size());
	        model.add(tempModel);
	    }

	    return model;
	}

	
}
