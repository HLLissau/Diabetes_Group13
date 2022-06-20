package group13.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import group13.model.Doctor;
import group13.model.Treats;


@Repository
public interface DoctorRepository extends CrudRepository<Doctor,Long> {
	List<Doctor> findAll();
	
	
	Optional<Doctor> findById(Long id);
	

	
	@Query(value = "SELECT *  FROM doctor "
		     + "WHERE email= ?1 "  
		     + "And password = ?2",
		nativeQuery=true)
	Optional<Doctor> loginDoctor(String email, String password);
	
	@Query(value = " select * from doctor where id in (SELECT doctor_id FROM treats WHERE user_id = ?1)",
			nativeQuery=true)
	List<Doctor> getDoctor(Long id);
	
}
	

