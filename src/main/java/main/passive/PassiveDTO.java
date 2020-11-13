package main.passive;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class PassiveDTO {
	@Pattern(regexp="^[0-9]*$")
	private String passiveId;
	private String passiveName;
	private String passiveDescription;
	@Pattern(regexp="^[0-9]*$|^$")
	private String passiveCoolDown;
	
	public String getPassiveId() {
		return passiveId;
	}
	
	public void setPassiveId(String passiveId) {
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
