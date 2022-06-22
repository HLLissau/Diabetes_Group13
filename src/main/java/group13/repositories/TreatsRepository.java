package group13
.repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import group13.model.Doctor;
import group13.model.Treats;
import group13.model.Users;



@Repository
public interface TreatsRepository extends CrudRepository<Treats,Long> {
	List<Treats> findAll();
	
	@Query(value = "SELECT *  FROM treats "
		     + "WHERE doctor_id= ?1 "  
		     + "And user_id = ?2",
		nativeQuery=true)
	Optional<Treats> findById(Long userId,Long doctorId);

	@Query(value = " select * from doctor where id in (SELECT doctor_id FROM treats WHERE user_id = ?1)",
			nativeQuery=true)
	List<Doctor> getDoctor(Long id);
	
	
}




