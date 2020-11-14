package main.champion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import main.champion.skin.Skin;
import main.equipment.Equipment;
import main.equipment.EquipmentFake;
import main.passive.PassiveFake;
import main.skill.Skill;
import main.skill.SkillFake;

public class ChampionFake {
	private long championId;
	private String championRPPrice = "empty";
	private String championLPPrice = "empty";
	private String championStartArmor = "empty";
	private String championStartMagicResist = "empty";
	private String championStartHealth = "empty";
	private String championStartResource = "empty";
	private String championStartPhysicalDamage = "empty";
	private String championStartMagicalDamage = "empty";
	private String championStartHitRange = "empty";
	private String championName = "empty";
	private String championType = "empty";
	private String championCategory = "empty";
	private String championHitType = "empty";
	private Set<Skin> skin;
	private Set<EquipmentFake> equipment = new HashSet<EquipmentFake>();
	private Set<SkillFake> skill = new HashSet<SkillFake>();
	private PassiveFake passive;
	
	public ChampionFake(Champion champion) {
		this.championId = champion.getChampionId();
		this.championLPPrice = champion.getChampionLPPrice();
		this.championRPPrice = champion.getChampionRPPrice();
		this.championStartArmor = champion.getChampionStartArmor();
		this.championStartMagicResist = champion.getChampionStartMagicResist();
		this.championStartHealth = champion.getChampionStartHealth();
		this.championStartResource = champion.getChampionStartResource();
		this.championStartPhysicalDamage = champion.getChampionStartPhysicalDamage();
		this.championStartMagicalDamage = champion.getChampionStartMagicalDamage();
		this.championStartHitRange = champion.getChampionStartHitRange();
		this.championHitType = champion.getChampionHitType();
		this.championType = champion.getChampionType();
		this.championName = champion.getChampionName();
		this.championCategory = champion.getChampionCategory();
		this.skin = champion.getSkin();
		this.passive = new PassiveFake(champion.getPassive());
		List<Equipment> equipment = new ArrayList<Equipment>(champion.getEquipment());
		if(equipment != null) {
			for(Equipment ele : equipment) {
				this.equipment.add(new EquipmentFake(ele));
			}
		}
		List<Skill> skill = new ArrayList<Skill>(champion.getSkill());
		if(skill != null) {
			for(Skill ele : skill) {
				this.skill.add(new SkillFake(ele));
			}
		}
	}
	
	public ChampionFake(Champion champion, int order) {
		this.championId = champion.getChampionId();
		this.championLPPrice = champion.getChampionLPPrice();
		this.championRPPrice = champion.getChampionRPPrice();
		this.championStartArmor = champion.getChampionStartArmor();
		this.championStartMagicResist = champion.getChampionStartMagicResist();
		this.championStartHealth = champion.getChampionStartHealth();
		this.championStartResource = champion.getChampionStartResource();
		this.championStartPhysicalDamage = champion.getChampionStartPhysicalDamage();
		this.championStartMagicalDamage = champion.getChampionStartMagicalDamage();
		this.championStartHitRange = champion.getChampionStartHitRange();
		this.championHitType = champion.getChampionHitType();
		this.championType = champion.getChampionType();
		this.championName = champion.getChampionName();
		this.championCategory = champion.getChampionCategory();
		this.skin = champion.getSkin();
		this.passive = new PassiveFake(champion.getPassive());
		List<Equipment> equipment = new ArrayList<Equipment>(champion.getEquipment());
		if(equipment != null) {
			for(Equipment ele : equipment) {
				this.equipment.add(new EquipmentFake(ele, 2));
			}
		}
		List<Skill> skill = new ArrayList<Skill>(champion.getSkill());
		if(skill != null) {
			for(Skill ele : skill) {
				this.skill.add(new SkillFake(ele, 3));
			}
		}
	}
	
	public long getChampionId() {
		return championId;
	}
	
	public void setChampionId(long championId) {
		this.championId = championId;
	}
	
	public String getChampionRPPrice() {
		return championRPPrice;
	}
	
	public void setChampionRPPrice(String championRPPrice) {
		this.championRPPrice = championRPPrice;
	}
	
	public String getChampionLPPrice() {
		return championLPPrice;
	}
	
	public void setChampionLPPrice(String championLPPrice) {
		this.championLPPrice = championLPPrice;
	}
	
	public String getChampionStartArmor() {
		return championStartArmor;
	}
	
	public void setChampionStartArmor(String championStartArmor) {
		this.championStartArmor = championStartArmor;
	}
	
	public String getChampionStartMagicResist() {
		return championStartMagicResist;
	}
	
	public void setChampionStartMagicResist(String championStartMagicResist) {
		this.championStartMagicResist = championStartMagicResist;
	}
	
	public String getChampionStartHealth() {
		return championStartHealth;
	}
	
	public void setChampionStartHealth(String championStartHealth) {
		this.championStartHealth = championStartHealth;
	}
	
	public String getChampionStartResource() {
		return championStartResource;
	}
	
	public void setChampionStartResource(String championStartResource) {
		this.championStartResource = championStartResource;
	}
	
	public String getChampionStartPhysicalDamage() {
		return championStartPhysicalDamage;
	}
	
	public void setChampionStartPhysicalDamage(String championStartPhysicalDamage) {
		this.championStartPhysicalDamage = championStartPhysicalDamage;
	}
	
	public String getChampionStartMagicalDamage() {
		return championStartMagicalDamage;
	}
	
	public void setChampionStartMagicalDamage(String championStartMagicalDamage) {
		this.championStartMagicalDamage = championStartMagicalDamage;
	}
	
	public String getChampionStartHitRange() {
		return championStartHitRange;
	}
	
	public void setChampionStartHitRange(String championStartHitRange) {
		this.championStartHitRange = championStartHitRange;
	}
	
	public String getChampionName() {
		return championName;
	}
	
	public void setChampionName(String championName) {
		this.championName = championName;
	}
	
	public String getChampionType() {
		return championType;
	}
	
	public void setChampionType(String championType) {
		this.championType = championType;
	}
	
	public String getChampionCategory() {
		return championCategory;
	}
	
	public void setChampionCategory(String championCategory) {
		this.championCategory = championCategory;
	}
	
	public String getChampionHitType() {
		return championHitType;
	}
	
	public void setChampionHitType(String championHitType) {
		this.championHitType = championHitType;
	}
	
	public Set<Skin> getSkin() {
		return skin;
	}
	
	public void setSkin(Set<Skin> skin) {
		this.skin = skin;
	}
	
	public Set<EquipmentFake> getEquipment() {
		return equipment;
	}
	
	public void setEquipmentFake(Set<EquipmentFake> equipmentFake) {
		this.equipment = equipmentFake;
	}
	
	public Set<SkillFake> getSkill() {
		return skill;
	}
	
	public void setSkillFake(Set<SkillFake> skillFake) {
		this.skill = skillFake;
	}
	
	public PassiveFake getPassive() {
		return passive;
	}
	
	public void setPassiveFake(PassiveFake passiveFake) {
		this.passive = passiveFake;
	}
	
	
	

}
