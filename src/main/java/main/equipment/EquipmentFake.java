package main.equipment;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import main.champion.Champion;
import main.champion.ChampionFake;
import main.passive.Passive;
import main.passive.PassiveFake;

public class EquipmentFake {
	private long equipmentId;
	private String equipmentPrice = "empty";
	private String equipmentName = "empty";
	private String equipmentDescription = "empty";
	private String equipmentPassive = "empty";
	private PassiveFake passive;
	private Set<ChampionFake> champion;
	
	public EquipmentFake(Equipment equipment) {
		this.equipmentId = equipment.getEquipmentId();
		this.equipmentPrice = equipment.getEquipmentPrice();
		this.equipmentName = equipment.getEquipmentName();
		this.equipmentDescription = equipment.getEquipmentDescription();
		this.equipmentPassive = equipment.getEquipmentPassive();
		if(equipment.getPassive() != null) {
			this.passive = new PassiveFake(equipment.getPassive());
		}
	}
	
	public EquipmentFake(Equipment equipment, int order) {
		this.equipmentId = equipment.getEquipmentId();
		this.equipmentPrice = equipment.getEquipmentPrice();
		this.equipmentName = equipment.getEquipmentName();
		this.equipmentDescription = equipment.getEquipmentDescription();
		this.equipmentPassive = equipment.getEquipmentPassive();
		if(equipment.getPassive() != null) {
			this.passive = new PassiveFake(equipment.getPassive());
		}
		if(equipment.getChampion() != null) {
			this.champion = new HashSet<ChampionFake>();
			List<Champion> arr = new ArrayList<Champion>(equipment.getChampion());
			for(Champion ele : arr) {
				this.champion.add(new ChampionFake(ele));
			}
		}
	}
	
	public Set<ChampionFake> getChampion() {
		return champion;
	}
	
	public void setChampion(Set<ChampionFake> champion) {
		this.champion = champion;
	}

	public long getEquipmentId() {
		return equipmentId;
	}
	
	public void setEquipmentId(long equipmentId) {
		this.equipmentId = equipmentId;
	}
	
	public String getEquipmentPrice() {
		return equipmentPrice;
	}
	
	public void setEquipmentPrice(String equipmentPrice) {
		this.equipmentPrice = equipmentPrice;
	}
	
	public String getEquipmentName() {
		return equipmentName;
	}
	
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	
	public String getEquipmentDescription() {
		return equipmentDescription;
	}
	
	public void setEquipmentDescription(String equipmentDescription) {
		this.equipmentDescription = equipmentDescription;
	}
	
	public String getEquipmentPassive() {
		return equipmentPassive;
	}
	
	public void setEquipmentPassive(String equipmentPassive) {
		this.equipmentPassive = equipmentPassive;
	}
	
	public PassiveFake getPassive() {
		return passive;
	}
	
	public void setPassive(PassiveFake passiveFake) {
		this.passive = passiveFake;
	}
	
	

}
















