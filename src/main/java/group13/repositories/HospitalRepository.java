package group13.repositories;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import group13.model.Hospital;

@Repository
public interface HospitalRepository extends CrudRepository<Hospital,Long> {
	List<Hospital> findAll();
	
}









