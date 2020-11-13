package main.equipment;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CustomEquipmentRepositoryImpl implements CustomEquipmentRepository {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Equipment searchEquipmentById(long equipmentId) {
		EntityGraph entityGraph = this.em.createEntityGraph("equipment-entity-graph");
		Equipment equipment = this.em.createQuery("SELECT DISTINCT e FROM Equipment e WHERE e.equipmentId = :equipmentId", Equipment.class)
									 .setParameter("equipmentId", equipmentId)
									 .setHint("javax.persistence.fetchgraph", entityGraph)
									 .getSingleResult();
		return equipment;
	}

}
