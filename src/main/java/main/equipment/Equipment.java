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
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
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

@NamedEntityGraph(
	name="equipment-entity-graph",
	attributeNodes={
		@NamedAttributeNode(value="champion", subgraph="sub-graph1")
	},
	subgraphs= {
		@NamedSubgraph(
			name="sub-graph1",
			attributeNodes={
				@NamedAttributeNode("equipment"),
				@NamedAttributeNode("skill")
			}
		)
	}
)
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
	@OneToOne(mappedBy="equipment", fetch=FetchType.EAGER, cascade=CascadeType.PERSIST, orphanRemoval=true)
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (equipmentId ^ (equipmentId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipment other = (Equipment) obj;
		if (equipmentId != other.equipmentId)
			return false;
		return true;
	}
	
	

}
