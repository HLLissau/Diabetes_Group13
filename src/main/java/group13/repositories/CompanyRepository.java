package group13.repositories;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import group13.model.Company;



@Repository
public interface CompanyRepository extends CrudRepository<Company,Long> {
	List<Company> findAll();
	
}









