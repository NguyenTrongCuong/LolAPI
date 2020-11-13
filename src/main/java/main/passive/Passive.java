package main.passive;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.data.domain.Persistable;

import main.champion.Champion;
import main.equipment.Equipment;
import main.skill.Skill;

@Entity
public class Passive implements Persistable<Long> {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long passiveId;
	@NotBlank
	private String passiveName;
	@NotBlank
	private String passiveDescription;
	@Pattern(regexp="^[0-9]*$")
	private String passiveCoolDown;
	@OneToOne
	@JoinColumn(name="championId")
	@Valid
	private Champion champion;
	@OneToOne
	@JoinColumn(name="skillId")
	@Valid
	private Skill skill;
	@OneToOne
	@JoinColumn(name="equipmentId")
	@Valid
	private Equipment equipment;
	@Transient
	private boolean isNew = true;
	
	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public Champion getChampion() {
		return champion;
	}

	public void setChampion(Champion champion) {
		this.champion = champion;
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

	@Override
	public Long getId() {
		return this.passiveId;
	}

	@Override
	public boolean isNew() {
		return this.isNew;
	}
	
	@PrePersist
	@PostLoad
	public void markNotNew() {
		this.isNew = false;
	}

	

}
