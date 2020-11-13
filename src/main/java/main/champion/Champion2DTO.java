package main.champion;

import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import main.champion.skin.Skin;

public class Champion2DTO {
	@Pattern(regexp="^[0-9]*$")
	private String championId;
	@Pattern(regexp="^[0-9]*$|^$")
	private String championRPPrice;
	@Pattern(regexp="^[0-9]*$|^$")
	private String championLPPrice;
	@Pattern(regexp="^[0-9]*$|^$")
	private String championStartArmor;
	@Pattern(regexp="^[0-9]*$|^$")
	private String championStartMagicResist;
	@Pattern(regexp="^[0-9]*$|^$")
	private String championStartHealth;
	@Pattern(regexp="^[0-9]*$|^$")
	private String championStartResource;
	@Pattern(regexp="^[0-9]*$|^$")
	private String championStartPhysicalDamage;
	@Pattern(regexp="^[0-9]*$|^$")
	private String championStartMagicalDamage;
	@Pattern(regexp="^[0-9]*$|^$")
	private String championStartHitRange;
	private String championName;
	private String championType;
	private String championCategory;
	private String championHitType;
	@Valid
	private Set<Skin> skin;
	
	public String getChampionId() {
		return championId;
	}
	
	public void setChampionId(String championId) {
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
	
	public Set<Skin> getSkin() {
		return skin;
	}
	
	public void setSkin(Set<Skin> skin) {
		this.skin = skin;
	}
	
	

}
