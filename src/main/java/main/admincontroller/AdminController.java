package main.admincontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import main.champion.Champion;
import main.champion.ChampionDTO;
import main.champion.ChampionService;
import main.equipment.Equipment;
import main.equipment.EquipmentService;

@RestController
public class AdminController {
	@Autowired
	private ChampionService championService;
	@Autowired
	private EquipmentService equipmentService;
	
	
	
	@PostMapping("/api/v1/admin/addChampion")
	public void addChampion(@RequestBody @Valid Champion champion, BindingResult result) {
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid champion info");
		}
		this.championService.saveChampion(champion);
	}
	
	@PostMapping("/api/v1/admin/addEquipment")
	public void addEquipment(@RequestBody @Valid Equipment equipment, BindingResult result) {
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid equipment info");
		}
		this.equipmentService.saveEquipment(equipment);
	}
	
	public void updateEquipmentsOfChampion(@Valid ChampionDTO championDTO, BindingResult result) {
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid info");
		}
		
	}
	
	
	
	

}




















