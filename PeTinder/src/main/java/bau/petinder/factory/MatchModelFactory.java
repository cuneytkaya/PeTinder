package bau.petinder.factory;

import bau.petinder.domain.MatchHistory;
import bau.petinder.model.MatchHistoryModel;
import bau.petinder.service.CustomerService;
import bau.petinder.service.PetService;

public class MatchModelFactory {
	
	public MatchHistoryModel PrepareMatchHistoryModel(MatchHistory match, PetService petService, CustomerService customerService) {
		
		var model = new MatchHistoryModel();
		model.setMatchSelected(match.isMatchSelected());
		
		var sourcePet = petService.GetById(match.getSourcePetId());
		var targetPet = petService.GetById(match.getTargetPetId());
		var targetCustomer = customerService.GetById(targetPet.getCustomerId());
		
		model.setId(match.getId());
		model.setSourcePetName(sourcePet.getName());
		model.setTargetPetName(targetPet.getName());
		model.setTargetDateOfBirth(targetPet.getDateOfBirth());
		model.setTargetVaccinated(targetPet.isVaccinated());
		model.setTargetAdditionalInformation(targetPet.getAdditionalInformation());
		model.setTargetTypeId(targetPet.getPetTypeId());
		model.setTargetCustomerName(targetCustomer.getFirstName() + " " + targetCustomer.getLastName());
		model.setTargetCustomerEmail(targetCustomer.getEmail());
		model.setTargetCustomerPhone(targetCustomer.getPhone());
		model.setTargetCustomerAdditionalInformation(targetCustomer.getAdditionalInformation());
		
		return model;
	}
	
}
