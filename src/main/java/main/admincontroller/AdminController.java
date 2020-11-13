package main.admincontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import main.champion.Champion;
import main.champion.Champion2DTO;
import main.champion.ChampionDTO;
import main.champion.ChampionService;
import main.equipment.Equipment;
import main.equipment.Equipment2DTO;
import main.equipment.EquipmentDTO;
import main.equipment.EquipmentService;
import main.passive.PassiveDTO;
import main.passive.PassiveService;
import main.skill.SkillDTO;
import main.skill.SkillService;

@RestController
public class AdminController {
	@Autowired
	private ChampionService championService;
	@Autowired
	private EquipmentService equipmentService;
	@Autowired
	private SkillService skillService;
	@Autowired
	private PassiveService passiveService;
	
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
	
	@PutMapping("/api/v1/admin/updateEquipmentsOfChampion")
	public void updateEquipmentsOfChampion(@RequestBody @Valid ChampionDTO championDTO, BindingResult result) {
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid info");
		}
		try {
			this.championService.updateEquipmentsOfChamion(championDTO);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@PutMapping("/api/v1/admin/updateChampionsOfEquipment")
	public void updateChampionsOfEquipment(@RequestBody @Valid EquipmentDTO equipmentDTO, BindingResult result) {
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid info");
		}
		try {
			this.equipmentService.updateChampionsOfEquipment(equipmentDTO);
		} 
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@PutMapping("/api/v1/admin/updateInfoOfEquipment")
	public void updateInfoOfEquipment(@RequestBody @Valid Equipment2DTO equipment2DTO, BindingResult result) {
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid info");
		}
		try {
			this.equipmentService.updateInfoOfEquipment(equipment2DTO);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@PutMapping("/api/v1/admin/updateInfoOfSkill")
	public void updateInfoOfSkill(@RequestBody @Valid SkillDTO skillDTO, BindingResult result) {
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid info");
		}
		try {
			this.skillService.updateInfoOfSkill(skillDTO);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@PutMapping("/api/v1/admin/updateInfoOfChampion")
	public void updateInfoOfChampion(@RequestBody @Valid Champion2DTO champion2DTO, BindingResult result) {
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid info");
		}
		try {
			this.championService.updateInfoOfChampion(champion2DTO);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@PutMapping("/api/v1/admin/updateInfoOfPassive")
	public void updateInfoOfPassive(@RequestBody @Valid PassiveDTO passiveDTO, BindingResult result) {
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid info");
		}
		try {
			this.passiveService.updateInfoOfPassive(passiveDTO);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@DeleteMapping("/api/v1/admin/deleteChampion/{championId}")
	public void deleteChampion(@PathVariable("championId") long championId) {
		try {
			this.championService.deleteChampion(championId);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@DeleteMapping("/api/v1/admin/deleteEquipment/{equipmentId}")
	public void deleteEquipment(@PathVariable("equipmentId") long equipmentId) {
		try {
			this.equipmentService.deleteEquipment(equipmentId);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@DeleteMapping("/api/v1/admin/deletePassiveOfSkill/{skillId}")
	public void deletePassiveOfSkill(@PathVariable("skillId") long skillId) {
		try {
			this.skillService.deletePassiveOfSkill(skillId);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@DeleteMapping("/api/v1/admin/deletePassiveOfEquipment/{equipmentId}")
	public void deletePassiveOfEquipment(@PathVariable("equipmentId") long equipmentId) {
		try {
			this.equipmentService.deletePassiveOfEquipment(equipmentId);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	

}




















