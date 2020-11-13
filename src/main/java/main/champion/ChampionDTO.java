package main.champion;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class ChampionDTO {
	@Pattern(regexp="^[0-9]*$")
	private String championId;
	@NotEmpty
	private List<String> equipmentId;
	private List<Long> secondEquipmentId = new ArrayList<Long>();
	
	public List<Long> getSecondEquipmentId() {
		for(String ele : this.equipmentId) {
			this.secondEquipmentId.add(Long.parseLong(ele));
		}
		return this.secondEquipmentId;
	}
	
	public String getChampionId() {
		return championId;
	}
	
	public void setChampionId(String championId) {
		this.championId = championId;
	}
	
	public List<String> getEquipmentId() {
		return equipmentId;
	}
	
	public void setEquipmentId(List<String> equipmentId) {
		this.equipmentId = equipmentId;
	}
	
	

}
