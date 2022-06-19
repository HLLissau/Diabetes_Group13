package group13
.repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import group13.model.Doctor;
import group13.model.Treats;



@Repository
public interface TreatsRepository extends CrudRepository<Treats,Long> {
	List<Treats> findAll();
	
	@Query(value = " SELECT * FROM treats WHERE user_id = 1",
			nativeQuery=true)
	Optional<Treats> findId(Long id);
	
	
}



