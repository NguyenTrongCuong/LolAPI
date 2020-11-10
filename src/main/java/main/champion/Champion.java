package main.champion;

import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Transient;
import javax.persistence.JoinColumn;

import org.springframework.data.domain.Persistable;

import main.champion.skin.Skin;
import main.equipment.Equipment;
import main.skill.Skill;

@Entity
public class Champion implements Persistable<Long> {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long championId;
	private long championRPPrice;
	private long championLPPrice;
	private long championStartArmor;
	private long championStartMagicResist;
	private long championStartHealth;
	private long championStartResource;
	private long championStartPhysicalDamage;
	private long championStartMagicalDamage;
	private long championStartHitRange;
	private String championName;
	private String championType;
	private String championCategory;
	private String championHitType;
	@ElementCollection(fetch=FetchType.LAZY)
	@JoinTable(name="skinsofchampion",
			   joinColumns=@JoinColumn(name="championId"))
	private Set<Skin> skin;
	@OneToMany(mappedBy="champion", fetch=FetchType.LAZY)
	private Set<Skill> skill;
	@ManyToMany(mappedBy="champion", fetch=FetchType.LAZY)
	private Set<Equipment> equipment;
	@Transient
	private boolean isNew = true;
	
	public Set<Skin> getSkin() {
		return skin;
	}

	public void setSkin(Set<Skin> skin) {
		this.skin = skin;
	}

	public Set<Skill> getSkill() {
		return skill;
	}

	public void setSkill(Set<Skill> skill) {
		this.skill = skill;
	}

	public Set<Equipment> getEquipment() {
		return equipment;
	}

	public void setEquipment(Set<Equipment> equipment) {
		this.equipment = equipment;
	}

	public long getChampionId() {
		return championId;
	}
	
	public void setChampionId(long championId) {
		this.championId = championId;
	}
	
	public long getChampionRPPrice() {
		return championRPPrice;
	}
	
	public void setChampionRPPrice(long championRPPrice) {
		this.championRPPrice = championRPPrice;
	}
	
	public long getChampionLPPrice() {
		return championLPPrice;
	}
	
	public void setChampionLPPrice(long championLPPrice) {
		this.championLPPrice = championLPPrice;
	}
	
	public long getChampionStartArmor() {
		return championStartArmor;
	}
	
	public void setChampionStartArmor(long championStartArmor) {
		this.championStartArmor = championStartArmor;
	}
	
	public long getChampionStartMagicResist() {
		return championStartMagicResist;
	}
	
	public void setChampionStartMagicResist(long championStartMagicResist) {
		this.championStartMagicResist = championStartMagicResist;
	}
	
	public long getChampionStartHealth() {
		return championStartHealth;
	}
	
	public void setChampionStartHealth(long championStartHealth) {
		this.championStartHealth = championStartHealth;
	}
	
	public long getChampionStartResource() {
		return championStartResource;
	}
	
	public void setChampionStartResource(long championStartResource) {
		this.championStartResource = championStartResource;
	}
	
	public long getChampionStartPhysicalDamage() {
		return championStartPhysicalDamage;
	}
	
	public void setChampionStartPhysicalDamage(long championStartPhysicalDamage) {
		this.championStartPhysicalDamage = championStartPhysicalDamage;
	}
	
	public long getChampionStartMagicalDamage() {
		return championStartMagicalDamage;
	}
	
	public void setChampionStartMagicalDamage(long championStartMagicalDamage) {
		this.championStartMagicalDamage = championStartMagicalDamage;
	}
	
	public long getChampionStartHitRange() {
		return championStartHitRange;
	}
	
	public void setChampionStartHitRange(long championStartHitRange) {
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

	@Override
	public Long getId() {
		return this.championId;
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
