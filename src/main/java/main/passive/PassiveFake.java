package main.passive;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import main.champion.ChampionFake;
import main.equipment.EquipmentFake;
import main.skill.SkillFake;

public class PassiveFake {
	private long passiveId;
	private String passiveName = "empty";
	private String passiveDescription = "empty";
	private String passiveCoolDown = "empty";
	private ChampionFake champion;
	private SkillFake skill;
	private EquipmentFake equipment;
	
	public PassiveFake(Passive passive) {
		this.passiveCoolDown = passive.getPassiveCoolDown();
		this.passiveDescription = passive.getPassiveDescription();
		this.passiveId = passive.getPassiveId();
		this.passiveName = passive.getPassiveName();
	}
	
	public PassiveFake(Passive passive, int order) {
		this.passiveCoolDown = passive.getPassiveCoolDown();
		this.passiveDescription = passive.getPassiveDescription();
		this.passiveId = passive.getPassiveId();
		this.passiveName = passive.getPassiveName();
		if(passive.getChampion() != null) {
			this.champion = new ChampionFake(passive.getChampion(), 5);
		}
		if(passive.getSkill() != null) {
			this.skill = new SkillFake(passive.getSkill(), 2);
		}
		if(passive.getEquipment() != null) {
			this.equipment = new EquipmentFake(passive.getEquipment(), 3);
		}
	}
	
	public ChampionFake getChampion() {
		return champion;
	}

	public void setChampion(ChampionFake champion) {
		this.champion = champion;
	}

	public SkillFake getSkill() {
		return skill;
	}

	public void setSkill(SkillFake skill) {
		this.skill = skill;
	}

	public EquipmentFake getEquipment() {
		return equipment;
	}

	public void setEquipment(EquipmentFake equipment) {
		this.equipment = equipment;
	}

	public long getPassiveId() {
		return passiveId;
	}
	
	public void setPassiveId(long passiveId) {
		this.passiveId = passiveId;
	}
	
	public String getPassiveName() {
		return passiveName;
	}
	
	public void setPassiveName(String passiveName) {
		this.passiveName = passiveName;
	}
	
	public String getPassiveDescription() {
		return passiveDescription;
	}
	
	public void setPassiveDescription(String passiveDescription) {
		this.passiveDescription = passiveDescription;
	}
	
	public String getPassiveCoolDown() {
		return passiveCoolDown;
	}
	
	public void setPassiveCoolDown(String passiveCoolDown) {
		this.passiveCoolDown = passiveCoolDown;
	}
	
	

}
