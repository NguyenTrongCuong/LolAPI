package main.skill;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.data.domain.Persistable;

import main.champion.Champion;
import main.passive.Passive;

@Entity
public class Skill implements Persistable<Long> {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long skillId;
	@NotBlank
	private String skillName;
	@NotBlank
	private String skillDescription;
	@Pattern(regexp="^[0-9]*$")
	private String skillCoolDown;
	@NotBlank
	private String skillActiveButton;
	@ManyToOne
	@JoinColumn(name="championId")
	@Valid
	private Champion champion;
	@OneToOne(mappedBy="skill", cascade=CascadeType.PERSIST, orphanRemoval=true)
	@Valid
	private Passive passive;
	@Transient
	private boolean isNew = true;
	
	public Champion getChampion() {
		return champion;
	}

	public void setChampion(Champion champion) {
		this.champion = champion;
	}

	public Passive getPassive() {
		return passive;
	}

	public void setPassive(Passive passive) {
		this.passive = passive;
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

	@Override
	public Long getId() {
		return this.skillId;
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
