package main.equipment;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
public class Equipment implements Persistable<Long> {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long equipmentId;
	@Pattern(regexp="^[0-9]*$")
	private String equipmentPrice;
	@NotBlank
	private String equipmentName;
	@NotBlank
	private String equipmentDescription;
	@NotBlank
	private String equipmentPassive;
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="equipmentsofchampion",
			   joinColumns=@JoinColumn(name="equipmentId"),
			   inverseJoinColumns=@JoinColumn(name="championId"))
	@Valid
	private Set<Champion> champion = new HashSet<>();
	@OneToOne(mappedBy="equipment", cascade=CascadeType.PERSIST)
	@Valid
	private Passive passive;
	@Transient
	private boolean isNew = true;
	
	public Passive getPassive() {
		return passive;
	}

	public void setPassive(Passive passive) {
		this.passive = passive;
	}

	public Set<Champion> getChampion() {
		return champion;
	}

	public void setChampion(Set<Champion> champion) {
		this.champion = champion;
	}

	public long getEquipmentId() {
		return equipmentId;
	}
	
	public void setEquipmentId(long equipmentId) {
		this.equipmentId = equipmentId;
	}
	
	public String getEquipmentName() {
		return equipmentName;
	}
	
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	
	public String getEquipmentPrice() {
		return equipmentPrice;
	}
	
	public void setEquipmentPrice(String equipmentPrice) {
		this.equipmentPrice = equipmentPrice;
	}
	
	public String getEquipmentDescription() {
		return equipmentDescription;
	}
	
	public void setEquipmentDescription(String equipmentDescription) {
		this.equipmentDescription = equipmentDescription;
	}
	
	public String getEquipmentPassive() {
		return equipmentPassive;
	}
	
	public void setEquipmentPassive(String equipmentPassive) {
		this.equipmentPassive = equipmentPassive;
	}

	@Override
	public Long getId() {
		return this.equipmentId;
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
