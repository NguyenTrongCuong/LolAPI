package main.champion;

import java.util.Optional;

public interface CustomChampionRepository {
	
	public Champion getChampionByIdEagerly(long championId);

}
