package main.passive;

public class PassiveResponseBuilder {
	
	public static PassiveFake buildResponse(Passive passive) {
		return new PassiveFake(passive, 4);
	}

}
