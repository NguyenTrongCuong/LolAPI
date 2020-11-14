package main.skill;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CustomSkillRepositoryImpl implements CustomSkillRepository {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Skill getSkillByIdEagerly(long skillId) {
		EntityGraph entityGraph = this.em.createEntityGraph("skill-entity-graph");
		Skill skill = this.em.createQuery("SELECT s FROM Skill s WHERE s.skillId = :skillId", Skill.class)
							 .setParameter("skillId", skillId)
							 .setHint("javax.persistence.fetchgraph", entityGraph)
							 .getSingleResult();
		return skill;
	}

}


























































