package main.equipment;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.champion.Champion;
import main.champion.ChampionService;
import main.passive.Passive;
import main.passive.PassiveService;

@Service
public class EquipmentService {
	@Autowired
	private EquipmentRepository equipmentRepo;
	@Autowired
	private ChampionService championService;
	@Autowired
	private PassiveService passiveService;
	
	public void saveEquipment(Equipment equipment) {
		Passive passive = equipment.getPassive();
		if(passive != null) {
			passive.setEquipment(equipment);
		}
		this.equipmentRepo.save(equipment);
	}
	
	public void updateEquipments(List<Equipment> equipment) {
		this.equipmentRepo.saveAll(equipment);
	}
	
	public void updateEquipment(Equipment equipment) {
		this.equipmentRepo.save(equipment);
	}
	
	public List<Equipment> findEquipmentsWithChampion(List<Long> equipmentId) {
		Optional<List<Equipment>> rs = this.equipmentRepo.findByEquipmentIdIn(equipmentId);
		return rs.isEmpty() ? null : rs.get();
	}
	
	public Equipment getEquipmentWithChampion(long equipmentId) {
		Optional<Equipment> rs = this.equipmentRepo.findByEquipmentId(equipmentId);
		return rs.isEmpty() ? null : rs.get();
	}
	
	public void updateChampionsOfEquipment(EquipmentDTO equipmentDTO) throws Exception {
		Equipment equipment = this.getEquipmentWithChampion(Long.parseLong(equipmentDTO.getEquipmentId()));
		List<Champion> champion = this.championService.getChampionsWithEquipments(equipmentDTO.getSecondChampionId());
		if(equipment != null && champion != null) {
			List<Champion> newChampion = new ArrayList<Champion>();
			List<Champion> oldChampion = new ArrayList<Champion>();
			for(int i = 0; i < champion.size(); ++i) {
				if(!equipment.getChampion().contains(champion.get(i))) {
					equipment.getChampion().add(champion.get(i));
					champion.get(i).getEquipment().add(equipment);
					newChampion.add(champion.get(i));
				}
			}
			List<Champion> iterChampion = new ArrayList<Champion>(equipment.getChampion());
			for(int i = 0; i < iterChampion.size(); ++i) {
				if(!champion.contains(iterChampion.get(i))) {
					equipment.getChampion().remove(iterChampion.get(i));
					iterChampion.get(i).getEquipment().remove(equipment);
					oldChampion.add(iterChampion.get(i));
				}
			}
			this.updateEquipment(equipment);
			this.championService.updateChampions(oldChampion);
			this.championService.updateChampions(newChampion);
		}
		else throw new Exception("Equipment or champion not found");
	}
	
	public void updateInfoOfEquipment(Equipment2DTO equipment2DTO) throws Exception {
		Optional<Equipment> equipment = this.equipmentRepo.getByEquipmentId(Long.parseLong(equipment2DTO.getEquipmentId()));
		if(!equipment.isEmpty()) {
			Equipment rs = equipment.get();
			if(equipment2DTO.getPassive() != null) {
				Passive passive = new Passive();
				passive.setPassiveCoolDown(equipment2DTO.getPassive().getPassiveCoolDown());
				passive.setPassiveDescription(equipment2DTO.getPassive().getPassiveDescription());
				passive.setPassiveName(equipment2DTO.getPassive().getPassiveName());
				passive.setEquipment(rs);
				this.passiveService.savePassive(passive);
				rs.setPassive(passive);
			}
			if(equipment2DTO.getEquipmentName() != null && !equipment2DTO.getEquipmentName().equals("")) {
				rs.setEquipmentName(equipment2DTO.getEquipmentName());
			}
			if(equipment2DTO.getEquipmentDescription() != null && !equipment2DTO.getEquipmentDescription().equals("")) {
				rs.setEquipmentDescription(equipment2DTO.getEquipmentDescription());
			}
			if(equipment2DTO.getEquipmentPassive() != null && !equipment2DTO.getEquipmentPassive().equals("")) {
				rs.setEquipmentPassive(equipment2DTO.getEquipmentPassive());
			}
			if(equipment2DTO.getEquipmentPrice() != null && !equipment2DTO.getEquipmentPrice().equals("")) {
				rs.setEquipmentPrice(equipment2DTO.getEquipmentPrice());
			}
			this.updateEquipment(rs);
		}
		else throw new Exception("Equipment not found");
	}

}

















