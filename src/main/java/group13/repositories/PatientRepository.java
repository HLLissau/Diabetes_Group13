package group13.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import group13.model.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient,Long> {
	List<Patient> findAll();
		
	
}


