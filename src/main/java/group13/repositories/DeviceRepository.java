package group13.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import group13.model.Device;

@Repository
public interface DeviceRepository extends CrudRepository<Device,Long> {
	List<Device> findAll();
	
}
