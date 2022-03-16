//package dtu.group13.modelTest;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;
//import static org.junit.Assert.assertTrue;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import group13.Application;
//import group13.model.Hospital;
//import group13.model.Patient;
//
//public class ModelHospitalTests {
//	@Autowired
//	Hospital hospital;
//	Patient patient;
//	
//	@Test
//	public void createNewHospital() {
//		assertNull(hospital);
//		hospital=new Hospital("my Hospital");
//		hospital.setId(10L);
//		assertTrue(hospital.getId().equals(10L));
//		assertNotNull(hospital);
//	}
//	@Test
//	public void SetHospitalName() {
//		createNewHospital();
//		String nameBefore = hospital.getName();
//		hospital.setName("NewName");
//		assertFalse(nameBefore.equals(hospital.getName()));
//		assertTrue(hospital.getName().equals("NewName"));
//	}
//	@Test
//	public void SetPatientListToHospital() {
//		createNewHospital();
//		patient=new Patient("egon");
//		List<Patient> patientList = new ArrayList<Patient>();
//		patientList.add(patient);
//		hospital.setPatients(patientList);
//		assertTrue(hospital.getPatients().contains(patient));		
//		
//	}
//	@Test
//	public void AddPatientToHospital() {
//		SetPatientListToHospital();
//		patient=new Patient("Anna");
//		assertNotNull(hospital.getPatients());
//		hospital.addPatient(patient);
//		assertTrue(hospital.getPatients().contains(patient));		
//		
//	}
//	@Test
//	public void DeletePatientFromHospital() {
//		AddPatientToHospital();
//		assertTrue(hospital.getPatients().contains(patient));
//		hospital.removePatient(patient);
//		assertFalse(hospital.getPatients().contains(patient));		
//		
//	}
//		
//}
