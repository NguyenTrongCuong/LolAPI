package main.passive;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CustomPassiveRepositoryImpl implements CustomPassiveRepository {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Passive getPassiveByIdEagerly(long passiveId) {
		EntityGraph entityGraph = this.em.createEntityGraph("passive-entity-graph");
		Passive passive = this.em.createQuery("SELECT p FROM Passive p WHERE p.passiveId = :passiveId", Passive.class)
								 .setParameter("passiveId", passiveId)
								 .setHint("javax.persistence.loadgraph", entityGraph)
								 .getSingleResult();
		return passive;
	}

}
