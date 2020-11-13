package main.skill;


import main.passive.Passive;
import main.passive.PassiveFake;

public class SkillFake {
	private long skillId;
	private String skillName = "empty";
	private String skillDescription = "empty";
	private String skillCoolDown = "empty";
	private String skillActiveButton = "empty";
	private PassiveFake passive;
	
	public SkillFake(Skill skill) {
		this.skillId = skill.getSkillId();
		this.skillName = skill.getSkillName();
		this.skillDescription = skill.getSkillDescription();
		this.skillCoolDown = skill.getSkillCoolDown();
		this.skillActiveButton = skill.getSkillActiveButton();
		if(skill.getPassive() != null) {
			this.passive = new PassiveFake(skill.getPassive());
		}
	}
	
	public long getSkillId() {
		return skillId;
	}
	
	public void setSkillId(long skillId) {
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
	
	public PassiveFake getPassive() {
		return passive;
	}
	
	public void setPassive(PassiveFake passiveFake) {
		this.passive = passiveFake;
	}
	
	

}
