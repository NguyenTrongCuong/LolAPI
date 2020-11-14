package main.passive;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassiveRepository extends CrudRepository<Passive, Long>, CustomPassiveRepository {

}
