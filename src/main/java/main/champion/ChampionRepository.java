package main.champion;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionRepository extends CrudRepository<Champion, Long> {

}
