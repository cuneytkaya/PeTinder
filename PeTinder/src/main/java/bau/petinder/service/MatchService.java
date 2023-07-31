package bau.petinder.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import bau.petinder.dao.MatchRepository;
import bau.petinder.dao.PetRepository;
import bau.petinder.domain.MatchHistory;
import bau.petinder.domain.Pet;

@Service
public class MatchService {

	@Autowired
	private MatchRepository matchRepository;
	
	@Autowired
	private PetRepository petRepository;
	
public List<Pet> GetAvailableMatchs(int customerId, Pet sourcePet){
		
		var cancelledMatchs = matchRepository.GetCancelledMatchs(customerId);
		
		var allPets = petRepository.GetAll();
		
		var availablePets = new ArrayList<Pet>();
		
		for (Pet targetPet : allPets) {
		    if (targetPet.getCustomerId() == customerId) {
		        continue;
		    }
		    if (hasCancelledMatch(cancelledMatchs, targetPet.getId())) {
		        continue;
		    }
		    if(targetPet.getPetTypeId() != sourcePet.getPetTypeId()) {
		    	continue;
		    }
		    
		    targetPet.setSourcePetId(sourcePet.getId());
		    availablePets.add(targetPet);
		}
		
		return availablePets;
	}

private boolean hasCancelledMatch(List<MatchHistory> cancelledMatches, int petId) {
    for (MatchHistory cancelledMatch : cancelledMatches) {
        if (cancelledMatch.getTargetPetId() == petId) {
            return true;
        }
    }
    return false;
}

public List<MatchHistory> GetAll(int customerId){
	
	return matchRepository.GetAllMatchs(customerId);
	
}

public List<MatchHistory> GetAll(){
	
	return matchRepository.GetAllMatchs();
	
}

public void InsertMatchHistory(MatchHistory history) {
	matchRepository.insertMatchHistory(history);
}

public void DeleteMatch(MatchHistory history) {
	matchRepository.deleteMatchHistory(history);
}

public MatchHistory GetById(int id) {
	return matchRepository.GetById(id);
	}

public MatchHistory GetBySourceAndTargetIds(int sourceId, int targetId) {
	
	return matchRepository.GetBySourceAndTargetIds(sourceId, targetId);
	
}
}
