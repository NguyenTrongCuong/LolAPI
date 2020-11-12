package main.equipment;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.champion.Champion;
import main.passive.Passive;

@Service
public class EquipmentService {
	@Autowired
	private EquipmentRepository equipmentRepo;
	
	public void saveEquipment(Equipment equipment) {
		Passive passive = equipment.getPassive();
		if(passive != null) {
			passive.setEquipment(equipment);
		}
		this.equipmentRepo.save(equipment);
	}

}
