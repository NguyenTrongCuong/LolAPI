package main.equipment;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends CrudRepository<Equipment, Long> {
	@EntityGraph(attributePaths={"champion"})
	public Optional<List<Equipment>> findByEquipmentIdIn(List<Long> equipmentId);
	
	@EntityGraph(attributePaths={"champion", "champion.equipment"})
	public Optional<Equipment> findByEquipmentId(long equipmentId);
	
	@Query("FROM Equipment e WHERE e.equipmentId = :equipmentId")
	public Optional<Equipment> getByEquipmentId(@Param("equipmentId") long equipmentId);
	

}
