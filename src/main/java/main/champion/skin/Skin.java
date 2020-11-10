package main.champion.skin;

import javax.persistence.Embeddable;

@Embeddable
public class Skin {
	private long skinRPPrice;
	private long skinLPPrice;
	private String skinName;
	private String skinType;
	
	public long getSkinRPPrice() {
		return skinRPPrice;
	}
	
	public void setSkinRPPrice(long skinRPPrice) {
		this.skinRPPrice = skinRPPrice;
	}
	
	public long getSkinLPPrice() {
		return skinLPPrice;
	}
	
	public void setSkinLPPrice(long skinLPPrice) {
		this.skinLPPrice = skinLPPrice;
	}
	
	public String getSkinName() {
		return skinName;
	}
	
	public void setSkinName(String skinName) {
		this.skinName = skinName;
	}
	
	public String getSkinType() {
		return skinType;
	}
	
	public void setSkinType(String skinType) {
		this.skinType = skinType;
	}
	
	

}
