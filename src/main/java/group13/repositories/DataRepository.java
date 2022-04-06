package group13.repositories;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import group13.model.Data;



@Repository
public interface DataRepository extends CrudRepository<Data,Long> {
	List<Data> findAll();
	
}









