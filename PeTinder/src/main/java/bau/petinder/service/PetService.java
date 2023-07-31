package bau.petinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bau.petinder.dao.PetRepository;
import bau.petinder.domain.Pet;


@Service
public class PetService implements IService<Pet> {

	@Autowired
	private PetRepository repository;

	@Override
	public Pet GetById(int id) {
	    return repository.GetById(id);
	}
	
	@Override
	public List<Pet> GetAll() {
	    return repository.GetAll();
	}
	
	public List<Pet> GetAll(int customerId) {
	    return repository.GetAll(customerId);
	}

	@Override
	public void Create(Pet entity) {
	    repository.Create(entity); 
	}

	@Override
	public void Update(Pet entity) {
	    repository.Update(entity);
	}

	@Override
	public void Delete(int id) {
	    repository.Delete(id);
	}	
}
