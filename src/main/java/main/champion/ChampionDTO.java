package main.champion;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class ChampionDTO {
	@Pattern(regexp="^[0-9]*$")
	private long championId;
	@NotEmpty
	private List<Long> equipmentId;
	
	public long getChampionId() {
		return championId;
	}
	
	public void setChampionId(long championId) {
		this.championId = championId;
	}
	
	public List<Long> getEquipmentId() {
		return equipmentId;
	}
	
	public void setEquipmentId(List<Long> equipmentId) {
		this.equipmentId = equipmentId;
	}
	
	

}
