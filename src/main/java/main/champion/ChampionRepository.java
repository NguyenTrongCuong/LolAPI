package main.champion;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionRepository extends CrudRepository<Champion, Long>, CustomChampionRepository {
	@EntityGraph(attributePaths={"equipment", "equipment.champion"})
	public Optional<Champion> findByChampionId(long championId);
	
	@EntityGraph(attributePaths={"equipment"})
	public Optional<List<Champion>> findByChampionIdIn(List<Long> championId);
	

}
