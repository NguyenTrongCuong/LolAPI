package main.champion;

import java.util.Optional;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CustomChampionRepositoryImpl implements CustomChampionRepository {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Champion getChampionByIdEagerly(long championId) {
		EntityGraph entityGraph = this.em.getEntityGraph("champion-entity-graph");
		Champion rs = this.em.createQuery("SELECT DISTINCT c FROM Champion c WHERE c.championId = :championId", Champion.class)
										.setParameter("championId", championId)
										.setHint("javax.persistence.fetchgraph", entityGraph)
										.getSingleResult();
		return rs;
	}
	
	
	

}












































