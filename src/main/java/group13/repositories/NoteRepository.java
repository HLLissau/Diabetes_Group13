package group13.repositories;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import group13.model.Note;



@Repository
public interface NoteRepository extends CrudRepository<Note,Long> {
	List<Note> findAll();
	
}









