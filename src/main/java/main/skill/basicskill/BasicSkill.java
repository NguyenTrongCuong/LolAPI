package main.skill.basicskill;

import javax.persistence.Entity;

import main.skill.Skill;

@Entity
public class BasicSkill extends Skill {
	private String skillActiveButton;
	private String skillResourceCost;
	private String skillPassive;
	private String skillCategory;
	
	public String getSkillActiveButton() {
		return skillActiveButton;
	}
	
	public void setSkillActiveButton(String skillActiveButton) {
		this.skillActiveButton = skillActiveButton;
	}
	
	public String getSkillResourceCost() {
		return skillResourceCost;
	}
	
	public void setSkillResourceCost(String skillResourceCost) {
		this.skillResourceCost = skillResourceCost;
	}
	
	public String getSkillPassive() {
		return skillPassive;
	}
	
	public void setSkillPassive(String skillPassive) {
		this.skillPassive = skillPassive;
	}
	
	public String getSkillCategory() {
		return skillCategory;
	}
	
	public void setSkillCategory(String skillCategory) {
		this.skillCategory = skillCategory;
	}
	
	
	

}










