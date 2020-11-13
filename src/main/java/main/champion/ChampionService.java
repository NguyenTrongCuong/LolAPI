package main.champion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.equipment.Equipment;
import main.equipment.EquipmentService;
import main.passive.Passive;
import main.skill.Skill;

@Service
public class ChampionService {
	@Autowired
	private ChampionRepository championRepo;
	@Autowired
	private EquipmentService equipmentService;
	
	public void saveChampion(Champion champion) {
		Iterator<Skill> iterSkill = champion.getSkill().iterator();
		while(iterSkill.hasNext()) {
			Skill skill = iterSkill.next();
			skill.setChampion(champion);
			Passive passive = skill.getPassive();
			if(passive != null) {
				passive.setSkill(skill);
			}
		}
		Passive passive = champion.getPassive();
		passive.setChampion(champion);
		this.championRepo.save(champion);
	}
	
	public void updateChampion(Champion champion) {
		this.championRepo.save(champion);
	}
	
	public void updateChampions(List<Champion> champion) {
		this.championRepo.saveAll(champion);
	}
	
	public Champion getChampionById(long championId) throws Exception {
		Champion champion = this.championRepo.getChampionByIdEagerly(championId);
		if(champion != null) {
			return champion;
		}
		else throw new Exception("Champion not found");
	}
	
	public Champion getChampionWithEquipments(long championId) {
		Optional<Champion> rs = this.championRepo.findByChampionId(championId);
		return rs.isEmpty() ? null : rs.get();
	}
	
	public List<Champion> getChampionsWithEquipments(List<Long> championId) {
		Optional<List<Champion>> rs = this.championRepo.findByChampionIdIn(championId);
		return rs.isEmpty() ? null : rs.get();
	}
	
	public void updateEquipmentsOfChamion(ChampionDTO championDTO) throws Exception  {
		Champion champion = this.getChampionWithEquipments(Long.parseLong(championDTO.getChampionId()));
		List<Equipment> equipment = this.equipmentService.findEquipmentsWithChampion(championDTO.getSecondEquipmentId());
		if(champion != null && equipment != null) {
			List<Equipment> newEquipment = new ArrayList<Equipment>();
			List<Equipment> oldEquipment = new ArrayList<Equipment>();
			for(int i = 0; i < equipment.size(); ++i) {
				if(!champion.getEquipment().contains(equipment.get(i))) {
					champion.getEquipment().add(equipment.get(i));
					equipment.get(i).getChampion().add(champion);
					newEquipment.add(equipment.get(i));
				}
			}
			List<Equipment> iterEquip = new ArrayList<Equipment>(champion.getEquipment());
			for(int i = 0; i < iterEquip.size(); ++i) {
				if(!equipment.contains(iterEquip.get(i))) {
					champion.getEquipment().remove(iterEquip.get(i));
					iterEquip.get(i).getChampion().remove(champion);
					oldEquipment.add(iterEquip.get(i));
				}
			}
			this.updateChampion(champion);
			this.equipmentService.updateEquipments(oldEquipment);
			this.equipmentService.updateEquipments(newEquipment);
		}
		else throw new Exception("Champion or equipment not found");
	}
	
	public void updateInfoOfChampion(Champion2DTO champion2DTO) throws Exception {
		Optional<Champion> rs = this.championRepo.findById(Long.parseLong(champion2DTO.getChampionId()));
		if(!rs.isEmpty()) {
			Champion champion = rs.get();
			if(champion2DTO.getChampionLPPrice() != null && !champion2DTO.getChampionLPPrice().equals("")) {
				champion.setChampionLPPrice(champion2DTO.getChampionLPPrice());
			}
			if(champion2DTO.getChampionRPPrice() != null && !champion2DTO.getChampionRPPrice().equals("")) {
				champion.setChampionRPPrice(champion2DTO.getChampionRPPrice());
			}
			if(champion2DTO.getChampionStartArmor() != null && !champion2DTO.getChampionStartArmor().equals("")) {
				champion.setChampionStartArmor(champion2DTO.getChampionStartArmor());
			}
			if(champion2DTO.getChampionStartMagicResist() != null && !champion2DTO.getChampionStartMagicResist().equals("")) {
				champion.setChampionStartMagicResist(champion2DTO.getChampionStartMagicResist());
			}
			if(champion2DTO.getChampionStartHealth() != null && !champion2DTO.getChampionStartHealth().equals("")) {
				champion.setChampionStartHealth(champion2DTO.getChampionStartHealth());
			}
			if(champion2DTO.getChampionStartResource() != null && !champion2DTO.getChampionStartResource().equals("")) {
				champion.setChampionStartResource(champion2DTO.getChampionStartResource());
			}
			if(champion2DTO.getChampionStartPhysicalDamage() != null && !champion2DTO.getChampionStartPhysicalDamage().equals("")) {
				champion.setChampionStartPhysicalDamage(champion2DTO.getChampionStartPhysicalDamage());
			}
			if(champion2DTO.getChampionStartMagicalDamage() != null && !champion2DTO.getChampionStartMagicalDamage().equals("")) {
				champion.setChampionStartMagicalDamage(champion2DTO.getChampionStartMagicalDamage());
			}
			if(champion2DTO.getChampionStartHitRange() != null && !champion2DTO.getChampionStartHitRange().equals("")) {
				champion.setChampionStartHitRange(champion2DTO.getChampionStartHitRange());
			}
			if(champion2DTO.getChampionName() != null && !champion2DTO.getChampionName().equals("")) {
				champion.setChampionName(champion2DTO.getChampionName());
			}
			if(champion2DTO.getChampionType() != null && !champion2DTO.getChampionType().equals("")) {
				champion.setChampionType(champion2DTO.getChampionType());
			}
			if(champion2DTO.getChampionCategory() != null && !champion2DTO.getChampionCategory().equals("")) {
				champion.setChampionCategory(champion2DTO.getChampionCategory());
			}
			if(champion2DTO.getChampionHitType() != null && !champion2DTO.getChampionHitType().equals("")) {
				champion.setChampionHitType(champion2DTO.getChampionHitType());
			}
			if(champion2DTO.getSkin() != null) {
				champion.setSkin(champion2DTO.getSkin());
			}
			this.updateChampion(champion);
		}
		else throw new Exception("Champion not found");
	}
	
	public void deleteChampion(long championId) throws Exception {
		Optional<Champion> champion = this.championRepo.findByChampionId(championId);
		if(!champion.isEmpty()) {
			List<Equipment> equipment = new ArrayList<Equipment>(champion.get().getEquipment());
			for(Equipment ele : equipment) {
				ele.getChampion().remove(champion.get());
			}
			this.equipmentService.updateEquipments(equipment);
			this.championRepo.delete(champion.get());
		}
		else throw new Exception("Champion not found");
	}
	
	
	
	
	

}
