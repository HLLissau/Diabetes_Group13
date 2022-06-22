package group13.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import group13.model.Users;

@Repository
public interface UserRepository extends CrudRepository<Users,Long> {
	List<Users> findAll();

	@Query(value = "SELECT *  FROM users "
		     + "WHERE email= ?1 "  
		     + "And password = ?2",
		nativeQuery=true)
	Optional<Users> loginUser(String email,String password);
	
	@Query(value = "call updateUser(?1, ?2, ?3, ?4,?5)",
		nativeQuery=true)
	Optional<Users> updateUser(Long id, String name, String email, String oldpassword,String password);
	
	@Query(value = "select * from users where id in (SELECT user_id FROM treats WHERE doctor_id = ?1)" // " SELECT user_id FROM treats WHERE doctor_id = ?1"
			,nativeQuery=true)
	List<Users> getPatients(Long doctorId);

	Optional<Users> findByIdAndPassword(Long userId, String password);
	
	
	void deleteByIdAndPassword(Long userid,String password);
	
	
	
		
}


