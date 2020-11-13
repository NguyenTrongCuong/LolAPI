package main.skill;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import main.passive.Passive;

public class SkillDTO {
	@Pattern(regexp="^[0-9]*$")
	private String skillId;
	private String skillName;
	private String skillDescription;
	@Pattern(regexp="^[0-9]*$|^$")
	private String skillCoolDown;
	private String skillActiveButton;
	@Valid
	private Passive passive;
	
	public String getSkillId() {
		return skillId;
	}
	
	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}
	
	public String getSkillName() {
		return skillName;
	}
	
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	
	public String getSkillDescription() {
		return skillDescription;
	}
	
	public void setSkillDescription(String skillDescription) {
		this.skillDescription = skillDescription;
	}
	
	public String getSkillCoolDown() {
		return skillCoolDown;
	}
	
	public void setSkillCoolDown(String skillCoolDown) {
		this.skillCoolDown = skillCoolDown;
	}
	
	public String getSkillActiveButton() {
		return skillActiveButton;
	}
	
	public void setSkillActiveButton(String skillActiveButton) {
		this.skillActiveButton = skillActiveButton;
	}
	
	public Passive getPassive() {
		return passive;
	}
	
	public void setPassive(Passive passive) {
		this.passive = passive;
	}
	
	

}
