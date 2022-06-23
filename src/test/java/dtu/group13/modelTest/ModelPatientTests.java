//package dtu.group13.modelTest;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;
//import static org.junit.Assert.assertThat;
//import static org.junit.Assert.assertTrue;
//
//import org.junit.Test;
//
//import group13.model.Users;
//
//public class ModelPatientTests {
//	Users patient;
//	
//	@Test
//	public void createNewPatient() {
//		assertNull(patient);
//		patient=new Users("Hans");
//		patient.setId(10);
//		assertTrue(patient.getId().equals(10L));
//		assertNotNull(patient);
//	}
//	@Test
//	public void SetPatientName() {
//		createNewPatient();
//		String nameBefore = patient.getName();
//		patient.setName("Anne");
//		assertFalse(nameBefore.equals(patient.getName()));
//		assertTrue(patient.getName().equals("Anne"));
//	}
//		
//}
