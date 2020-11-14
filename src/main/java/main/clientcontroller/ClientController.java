package main.clientcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import main.champion.Champion;
import main.champion.ChampionFake;
import main.champion.ChampionResponseBuilder;
import main.champion.ChampionService;
import main.equipment.Equipment;
import main.equipment.EquipmentFake;
import main.equipment.EquipmentResponseBuilder;
import main.equipment.EquipmentService;
import main.passive.PassiveFake;
import main.passive.PassiveResponseBuilder;
import main.passive.PassiveService;
import main.skill.SkillFake;
import main.skill.SkillResponseBuilder;
import main.skill.SkillService;

@RestController
public class ClientController {
	@Autowired
	private ChampionService championService;
	@Autowired
	private EquipmentService equipmentService;
	@Autowired
	private SkillService skillService;
	@Autowired
	private PassiveService passiveService;
	
	@GetMapping("/api/v1/client/getChampionById/{championId}")
	public ChampionFake getChampionById(@PathVariable("championId") long championId) {
		try {
			return ChampionResponseBuilder.buildResponse(this.championService.getChampionById(championId));
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@GetMapping("/api/v1/client/getEquipmentById/{equipmentId}")
	public EquipmentFake getEquipmentById(@PathVariable("equipmentId") long equipmentId) {
		try {
			return EquipmentResponseBuilder.buildResponse(this.equipmentService.getEquipmentByIdEagerly(equipmentId));
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@GetMapping("/api/v1/client/getSkillById/{skillId}")
	public SkillFake getSkillById(@PathVariable("skillId") long skillId) {
		try {
			return SkillResponseBuilder.buildResponse(this.skillService.getSkillByIdEagerly(skillId));
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@GetMapping("/api/v1/client/getPassiveById/{passiveId}")
	public PassiveFake getPassiveById(@PathVariable("passiveId") long passiveId) {
		try {
			return PassiveResponseBuilder.buildResponse(this.passiveService.getPassiveByIdEagerly(passiveId));
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

}




















































