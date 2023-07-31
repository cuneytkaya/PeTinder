package bau.petinder.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import bau.petinder.domain.MatchHistory;
import bau.petinder.domain.Pet;
import bau.petinder.factory.MatchModelFactory;
import bau.petinder.model.MatchHistoryModel;
import bau.petinder.service.CustomerService;
import bau.petinder.service.MatchService;
import bau.petinder.service.PetService;
import bau.petinder.service.WorkContextService;
import jakarta.validation.Valid;

@Controller
public class MatchController {

	@Autowired
	private PetService petService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private WorkContextService workContext;

	@Autowired
	private MatchService matchService;

	private MatchModelFactory matchModelFactory = new MatchModelFactory();

	@GetMapping({ "/match", "match.html" })
	public ModelAndView match() {

		var activeCustomer = workContext.GetCurrentCustomer();

		if (activeCustomer == null) {
			return new ModelAndView("redirect:/login");
		}

		ModelAndView mv = new ModelAndView("match.html");

		var pets = petService.GetAll(activeCustomer.Id);

		mv.addObject("pets", pets);

		return mv;
	}

	@GetMapping({ "/match/{petId}", "match.html" })
	public ModelAndView match(@PathVariable int petId) {

		var activeCustomer = workContext.GetCurrentCustomer();

		if (activeCustomer == null) {
			return new ModelAndView("redirect:/login");
		}

		var pet = petService.GetById(petId);

		if (pet == null || pet.getCustomerId() != activeCustomer.getId()) {
			return new ModelAndView("redirect:/match");
		}
		ModelAndView mv = new ModelAndView("matchprocess.html");

		var availablePets = matchService.GetAvailableMatchs(activeCustomer.Id, pet);

		if (!availablePets.isEmpty()) {

			Random random = new Random();
			int randomIndex = random.nextInt(availablePets.size());
			Pet targetPet = availablePets.get(randomIndex);

			mv.addObject("pet", targetPet);

			return mv;
		}
		mv = new ModelAndView("noAvailablePet.html");

		return mv;
	}

	@GetMapping("/declinematch/{sourcePetId}/{targetPetId}")
	public ModelAndView declineMatch(@PathVariable int sourcePetId, @PathVariable int targetPetId) {

		var activeCustomer = workContext.GetCurrentCustomer();

		if (activeCustomer == null) {
			return new ModelAndView("redirect:/login");
		}

		var sourcePet = petService.GetById(sourcePetId);

		if (sourcePet == null || sourcePet.getCustomerId() != activeCustomer.Id) {
			return new ModelAndView("redirect:/match");
		}

		var targetPet = petService.GetById(targetPetId);

		if (sourcePet == null || targetPet.getPetTypeId() != sourcePet.getPetTypeId()) {
			return new ModelAndView("redirect:/match");
		}

		var matchHistory = new MatchHistory();
		matchHistory.setMatchSelected(false);
		matchHistory.setSourceCustomerId(activeCustomer.Id);
		matchHistory.setSourcePetId(sourcePet.getId());
		matchHistory.setTargetPetId(targetPet.getId());

		matchService.InsertMatchHistory(matchHistory);

		return new ModelAndView("redirect:/match/" + sourcePet.getId());
	}

	@GetMapping("/approveMatch/{sourcePetId}/{targetPetId}")
	public ModelAndView approveMatch(@PathVariable int sourcePetId, @PathVariable int targetPetId) {

		var activeCustomer = workContext.GetCurrentCustomer();

		if (activeCustomer == null) {
			return new ModelAndView("redirect:/login");
		}

		var sourcePet = petService.GetById(sourcePetId);

		if (sourcePet == null || sourcePet.getCustomerId() != activeCustomer.Id) {
			return new ModelAndView("redirect:/match");
		}

		var targetPet = petService.GetById(targetPetId);

		if (sourcePet == null || targetPet.getPetTypeId() != sourcePet.getPetTypeId()) {
			return new ModelAndView("redirect:/match");
		}

		var matchHistory = new MatchHistory();
		matchHistory.setMatchSelected(true);
		matchHistory.setSourceCustomerId(activeCustomer.Id);
		matchHistory.setSourcePetId(sourcePet.getId());
		matchHistory.setTargetPetId(targetPet.getId());

		matchService.InsertMatchHistory(matchHistory);

		var newHistory = matchService.GetBySourceAndTargetIds(matchHistory.getSourcePetId(),
				matchHistory.getTargetPetId());

		return new ModelAndView("redirect:/history/" + newHistory.getId());

	}

	@GetMapping("/myhistory")
	public ModelAndView matchHistory() {

		var activeCustomer = workContext.GetCurrentCustomer();

		if (activeCustomer == null) {
			return new ModelAndView("redirect:/login");
		}

		var matchs = matchService.GetAll(activeCustomer.Id);

		Map<Long, List<MatchHistoryModel>> model = new HashMap<>();

		for (MatchHistory match : matchs) {
			var tempModel = matchModelFactory.PrepareMatchHistoryModel(match, petService, customerService);
			var sourcePetId = Long.valueOf(match.getSourcePetId());

			if (!model.containsKey(sourcePetId)) {
				model.put(sourcePetId, new ArrayList<>());
			}

			model.get(sourcePetId).add(tempModel);
		}

		ModelAndView mv = new ModelAndView("matchhistory.html");
		mv.addObject("history", model);

		return mv;
	}

	@GetMapping("/history/{historyId}")
	public ModelAndView matchHistoryDetails(@PathVariable int historyId) {

		var activeCustomer = workContext.GetCurrentCustomer();

		if (activeCustomer == null) {
			return new ModelAndView("redirect:/login");
		}

		var history = matchService.GetById(historyId);

		if (history == null || history.getSourceCustomerId() != activeCustomer.getId()) {
			return new ModelAndView("redirect:/myhistory");
		}
		var model = matchModelFactory.PrepareMatchHistoryModel(history, petService, customerService);

		ModelAndView mv = new ModelAndView("matchhistorydetails.html");
		mv.addObject("history", model);

		return mv;
	}
}
