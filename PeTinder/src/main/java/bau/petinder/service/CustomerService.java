package bau.petinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bau.petinder.dao.CustomerRepository;
import bau.petinder.domain.Customer;


@Service
public class CustomerService implements IService<Customer> {

	@Autowired
	private CustomerRepository repository;

	@Override
	public Customer GetById(int id) {
		return repository.GetById(id);
	}
	
	public Customer GetByEmail(String mail) {
		return repository.GetByEmail(mail);
	}

	@Override
	public List<Customer> GetAll() {
		return repository.GetAll();
	}

	@Override
	public void Create(Customer entity) {
		repository.Create(entity); 
	}

	@Override
	public void Update(Customer entity) {
		repository.Update(entity);
		
	}

	@Override
	public void Delete(int id) {
		repository.Delete(id);
	}	
	
	public Customer TryLogin(String email, String password) {
		
		return repository.Login(email, password);
	
	}
	
}
