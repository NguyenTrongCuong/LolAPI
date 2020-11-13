package main.passive;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class PassiveFake {
	private long passiveId;
	private String passiveName = "empty";
	private String passiveDescription = "empty";
	private String passiveCoolDown = "empty";
	
	public PassiveFake(Passive passive) {
		this.passiveCoolDown = passive.getPassiveCoolDown();
		this.passiveDescription = passive.getPassiveDescription();
		this.passiveId = passive.getPassiveId();
		this.passiveName = passive.getPassiveName();
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
