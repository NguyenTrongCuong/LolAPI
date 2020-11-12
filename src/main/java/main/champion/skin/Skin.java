package main.champion.skin;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Embeddable
public class Skin {
	@Pattern(regexp="^[0-9]*$")
	private String skinRPPrice;
	@Pattern(regexp="^[0-9]*$")
	private String skinLPPrice;
	@NotBlank
	private String skinName;
	@NotBlank
	private String skinType;
	
	public String getSkinRPPrice() {
		return skinRPPrice;
	}
	
	public void setSkinRPPrice(String skinRPPrice) {
		this.skinRPPrice = skinRPPrice;
	}
	
	public String getSkinLPPrice() {
		return skinLPPrice;
	}
	
	public void setSkinLPPrice(String skinLPPrice) {
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
