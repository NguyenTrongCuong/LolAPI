package main.skill;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import org.springframework.data.domain.Persistable;

import main.champion.Champion;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Skill implements Persistable<Long> {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long skillId;
	private long skillCoolDown;
	private String skillName;
	private String skillDescription;
	private String skillType;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="championId")
	private Champion champion;
	@Transient
	private boolean isNew = true;
	
	public Champion getChampion() {
		return champion;
	}

	public void setChampion(Champion champion) {
		this.champion = champion;
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
	
	public long getSkillCoolDown() {
		return skillCoolDown;
	}
	
	public void setSkillCoolDown(long skillCoolDown) {
		this.skillCoolDown = skillCoolDown;
	}
	
	public String getSkillDescription() {
		return skillDescription;
	}
	
	public void setSkillDescription(String skillDescription) {
		this.skillDescription = skillDescription;
	}
	
	public String getSkillType() {
		return skillType;
	}
	
	public void setSkillType(String skillType) {
		this.skillType = skillType;
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
