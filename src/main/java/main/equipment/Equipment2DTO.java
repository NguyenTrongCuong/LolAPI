package main.equipment;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import main.passive.Passive;

public class Equipment2DTO {
	@Pattern(regexp="^[0-9]*$")
	private String equipmentId;
	@Pattern(regexp="^[0-9]*$|^$")
	private String equipmentPrice;
	private String equipmentName;
	private String equipmentDescription;
	private String equipmentPassive;
	@Valid
	private Passive passive;
	
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

	public String getEquipmentId() {
		return equipmentId;
	}
	
	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}
	
	public Passive getPassive() {
		return passive;
	}
	
	public void setPassive(Passive passive) {
		this.passive = passive;
	}
	
	

}
