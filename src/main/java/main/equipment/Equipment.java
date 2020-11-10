package main.equipment;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import org.springframework.data.domain.Persistable;

import main.champion.Champion;

@Entity
public class Equipment implements Persistable<Long> {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long equipmentId;
	private long equipmentPrice;
	private String equipmentName;
	private String equipmentDescription;
	private String equipmentPassive;
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="equipmentsofchampion",
			   joinColumns=@JoinColumn(name="equipmentId"),
			   inverseJoinColumns=@JoinColumn(name="championId"))
	private Set<Champion> champion;
	@Transient
	private boolean isNew = true;
	
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
	
	public long getEquipmentPrice() {
		return equipmentPrice;
	}
	
	public void setEquipmentPrice(long equipmentPrice) {
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
