package main.equipment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class EquipmentDTO {
	@Pattern(regexp="^[0-9]*$")
	private String equipmentId;
	@NotEmpty
	private List<String> championId;
	private List<Long> secondChampionId = new ArrayList<Long>();
	
	public List<Long> getSecondChampionId() {
		for(String ele : this.championId) {
			this.secondChampionId.add(Long.parseLong(ele));
		}
		return this.secondChampionId;
	}
	
	public String getEquipmentId() {
		return equipmentId;
	}
	
	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}
	
	public List<String> getChampionId() {
		return championId;
	}
	
	public void setChampionId(List<String> championId) {
		this.championId = championId;
	}
	
	

}
