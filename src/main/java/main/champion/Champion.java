package main.champion;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.persistence.JoinColumn;

import org.springframework.data.domain.Persistable;

import main.champion.skin.Skin;
import main.equipment.Equipment;
import main.passive.Passive;
import main.skill.Skill;

@Entity
public class Champion implements Persistable<Long> {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long championId;
	@Pattern(regexp="^[0-9]*$")
	private String championRPPrice;
	@Pattern(regexp="^[0-9]*$")
	private String championLPPrice;
	@Pattern(regexp="^[0-9]*$")
	private String championStartArmor;
	@Pattern(regexp="^[0-9]*$")
	private String championStartMagicResist;
	@Pattern(regexp="^[0-9]*$")
	private String championStartHealth;
	@Pattern(regexp="^[0-9]*$")
	private String championStartResource;
	@Pattern(regexp="^[0-9]*$")
	private String championStartPhysicalDamage;
	@Pattern(regexp="^[0-9]*$")
	private String championStartMagicalDamage;
	@Pattern(regexp="^[0-9]*$")
	private String championStartHitRange;
	@NotBlank
	private String championName;
	@NotBlank
	private String championType;
	@NotBlank
	private String championCategory;
	@NotBlank
	private String championHitType;
	@ElementCollection(fetch=FetchType.LAZY)
	@JoinTable(name="skinsofchampion",
			   joinColumns=@JoinColumn(name="championId"))
	@Valid
	private Set<Skin> skin;
	@ManyToMany(mappedBy="champion", fetch=FetchType.LAZY)
	@Valid
	private Set<Equipment> equipment = new HashSet<Equipment>();
	@OneToOne(mappedBy="champion", cascade=CascadeType.PERSIST)
	@Valid
	@NotNull
	private Passive passive;
	@OneToMany(mappedBy="champion", cascade=CascadeType.PERSIST)
	@Valid
	@NotEmpty
	private Set<Skill> skill = new HashSet<>();
	@Transient
	private boolean isNew = true;
	
	public Passive getPassive() {
		return passive;
	}

	public void setPassive(Passive passive) {
		this.passive = passive;
	}

	public Set<Skill> getSkill() {
		return skill;
	}

	public void setSkill(Set<Skill> skill) {
		this.skill = skill;
	}

	public Set<Skin> getSkin() {
		return skin;
	}

	public void setSkin(Set<Skin> skin) {
		this.skin = skin;
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
