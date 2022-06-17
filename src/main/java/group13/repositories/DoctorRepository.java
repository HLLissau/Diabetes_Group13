package group13.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import group13.model.Doctor;
import group13.model.Users;


@Repository
public interface DoctorRepository extends CrudRepository<Doctor,Long> {
	List<Doctor> findAll();
	@Query(value = "SELECT *  FROM doctor"
		     + "WHERE id= ?1 "  
		     + "And password = ?2",
		nativeQuery=true)
	Optional<Doctor> loginDoctor(Long doctor,String password);
	
	
}

