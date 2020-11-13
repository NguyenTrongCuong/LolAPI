package main.champion;

public class ChampionResponseBuilder {
	
	public static ChampionFake buildResponse(Champion champion) {
		return new ChampionFake(champion);
	}

}
