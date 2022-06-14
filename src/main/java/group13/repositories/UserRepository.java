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
		     + "WHERE id= ?1 "  
		     + "And password = ?2",
		nativeQuery=true)
	Optional<Users> loginUser(Long user,String password);
	
	
		
}


