package group13.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import group13.model.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	List<User> findAll();
		
}


