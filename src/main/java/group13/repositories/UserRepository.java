package group13.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import group13.model.Users;

@Repository
public interface UserRepository extends CrudRepository<Users,Long> {
	List<Users> findAll();
		
}


