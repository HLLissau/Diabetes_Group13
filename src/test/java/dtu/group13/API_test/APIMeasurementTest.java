package dtu.group13.API_test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Array;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import group13.Application;
import group13.controller.DoctorController;
import group13.controller.MeasurementController;
import group13.model.Measurement;
import group13.model.Users;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class APIMeasurementTest {
	@Mock
	@Autowired
	private MeasurementController mController;

	private Users user = new Users(1L, "user1", "password 1", "email1@group13.rocks");

	// is the controller loaded?
	@Test
	public void contextLoads() throws Exception {
		assertThat(mController).isNotNull();
	}

	// getting all measurements from a user
	@Test
	public void getallUserMeasurements() throws Exception {
		ResponseEntity<List<Measurement>> response = mController.getall(user.getId());
		assertEquals(response.getStatusCode().value(), 200);
		assertThat(response.getBody().equals(Array.newInstance(getClass(), 0)));
	}

	// getting all measurements from a user not exists
	@Test
	public void getallUserMeasurementsNotExists() throws Exception {
		ResponseEntity<List<Measurement>> response = mController.getall(98989L);
		assertEquals(response.getStatusCode().value(), 404);
		assertNull(response.getBody());
	}

	// getting all measurements from a user
	@Test
	public void getallUserMeasurementsInInterval() throws Exception {
		ResponseEntity<List<Measurement>> response = mController.getData(user.getId(), "2022-01-17 00:00:00 ",
				"2022-01-18 00:00:00");
		assertEquals(response.getStatusCode().value(), 200);
		assertThat(response.getBody().equals(Array.newInstance(getClass(), 0)));

	}

	// getting all measurements from a user Nothing found
	@Test
	public void getallUserMeasurementsInIntervalError() throws Exception {
		ResponseEntity<List<Measurement>> response = mController.getData(user.getId(), "2010-01-18 00:00:00 ",
				"2011-01-18 00:00:00");
		assertEquals(response.getStatusCode().value(), 404);
		assertNull(response.getBody());

	}

	// getting avg measurements from a user hour
	@Test
	public void getavgUserMeasurementsInInterval() throws Exception {
		ResponseEntity<List<Measurement>> response = mController.averageByHour(user.getId(), "2022-01-17 00:00:00 ",
				"2022-01-18 00:00:00");
		assertEquals(response.getStatusCode().value(), 200);
		assertThat(response.getBody().equals(Array.newInstance(getClass(), 0)));

	}

	// getting avg measurements from a user hour Nothing found
	@Test
	public void getavgUserMeasurementsInIntervalError() throws Exception {
		ResponseEntity<List<Measurement>> response = mController.averageByHour(user.getId(), "2010-01-18 00:00:00 ",
				"2011-01-18 00:00:00");
		assertEquals(response.getStatusCode().value(), 404);
		assertNull(response.getBody());

	}

	// getting avg measurements from a user day
	@Test
	public void getavgUserMeasurementsInIntervalDay() throws Exception {
		ResponseEntity<List<Measurement>> response = mController.averageByDay(user.getId(), "2022-01-17 00:00:00 ",
				"2022-01-18 00:00:00");
		assertEquals(response.getStatusCode().value(), 200);
		assertThat(response.getBody().equals(Array.newInstance(getClass(), 0)));

	}

	// getting avg measurements from a user day Nothing found
	@Test
	public void getavgUserMeasurementsInIntervalDayError() throws Exception {
		ResponseEntity<List<Measurement>> response = mController.averageByDay(user.getId(), "2010-01-18 00:00:00 ",
				"2011-01-18 00:00:00");
		assertEquals(response.getStatusCode().value(), 404);
		assertNull(response.getBody());

	}

	// getting avg measurements from a user week
	@Test
	public void getavgUserMeasurementsInIntervalWeek() throws Exception {
		ResponseEntity<List<Measurement>> response = mController.averageByWeek(user.getId(), "2022-01-17 00:00:00 ",
				"2022-01-18 00:00:00");
		assertEquals(response.getStatusCode().value(), 200);
		assertThat(response.getBody().equals(Array.newInstance(getClass(), 0)));

	}

	// getting avg measurements from a user week Nothing found
	@Test
	public void getavgUserMeasurementsInIntervalWeekError() throws Exception {
		ResponseEntity<List<Measurement>> response = mController.averageByWeek(user.getId(), "2010-01-18 00:00:00 ",
				"2011-01-18 00:00:00");
		assertEquals(response.getStatusCode().value(), 404);
		assertNull(response.getBody());

	}

	// getting avg measurements from a user Month
	@Test
	public void getavgUserMeasurementsInIntervalMonth() throws Exception {
		ResponseEntity<List<Measurement>> response = mController.averageByMonth(user.getId(), "2022-01-17 00:00:00 ",
				"2022-01-18 00:00:00");
		assertEquals(response.getStatusCode().value(), 200);
		assertThat(response.getBody().equals(Array.newInstance(getClass(), 0)));

	}

	// getting avg measurements from a user Month Nothing found
	@Test
	public void getavgUserMeasurementsInIntervalMonthError() throws Exception {
		ResponseEntity<List<Measurement>> response = mController.averageByMonth(user.getId(), "2010-01-18 00:00:00 ",
				"2011-01-18 00:00:00");
		assertEquals(response.getStatusCode().value(), 404);
		assertNull(response.getBody());

	}

	// getting avg measurements from a user Year
	@Test
	public void getavgUserMeasurementsInIntervalYear() throws Exception {
		ResponseEntity<List<Measurement>> response = mController.averageByYear(user.getId(), "2022-01-17 00:00:00 ",
				"2022-01-18 00:00:00");
		assertEquals(response.getStatusCode().value(), 200);
		assertThat(response.getBody().equals(Array.newInstance(getClass(), 0)));

	}

	// getting avg measurements from a user Year Nothing found
	@Test
	public void getavgUserMeasurementsInIntervalYearError() throws Exception {
		ResponseEntity<List<Measurement>> response = mController.averageByYear(user.getId(), "2010-01-18 00:00:00 ",
				"2011-01-18 00:00:00");
		assertEquals(response.getStatusCode().value(), 404);
		assertNull(response.getBody());

	}

	// getting avg measurements from a user AllTime
	@Test
	public void getavgUserMeasurementsInIntervalAllTime() throws Exception {
		ResponseEntity<List<Measurement>> response = mController.averageByAllTime(user.getId(), "2022-01-17 00:00:00 ",
				"2022-01-18 00:00:00");
		assertEquals(response.getStatusCode().value(), 200);
		assertThat(response.getBody().equals(Array.newInstance(getClass(), 0)));

	}

	// getting avg measurements from a user AllTime Nothing found
	@Test
	public void getavgUserMeasurementsInIntervalAllTimeError() throws Exception {
		ResponseEntity<List<Measurement>> response = mController.averageByAllTime(user.getId(), "2010-01-18 00:00:00 ",
				"2011-01-18 00:00:00");
		assertEquals(response.getStatusCode().value(), 404);
		assertNull(response.getBody());

	}

	// getting most resent bolus
	@Test
	public void getResentBolus() throws Exception {
		ResponseEntity<Object> response = mController.recentBolus(user.getId());
		assertEquals(response.getStatusCode().value(), 200);
		assertThat(response.getBody().equals(Array.newInstance(getClass(), 0)));

	}
	// getting most resent basal
	@Test
	public void getResentBasal() throws Exception {
		ResponseEntity<Object> response = mController.recentBasal(user.getId());
		assertEquals(response.getStatusCode().value(), 200);
		assertThat(response.getBody().equals(Array.newInstance(getClass(), 0)));

	}	
	// getting most resent measurement
	@Test
	public void getResentMeasurement() throws Exception {
		ResponseEntity<Object> response = mController.recentMeasurement(user.getId());
		assertEquals(response.getStatusCode().value(), 200);
		assertThat(response.getBody().equals(Array.newInstance(getClass(), 0)));

	}	
	// getting most resent exercise
	@Test
	public void getResentExercise() throws Exception {
		ResponseEntity<Object> response = mController.recentExercise(user.getId());
		assertEquals(response.getStatusCode().value(), 200);
		assertThat(response.getBody().equals(Array.newInstance(getClass(), 0)));

	}		
	// getting most resent meal
	@Test
	public void getResentMeal() throws Exception {
		ResponseEntity<Object> response = mController.recentMeals(user.getId());
		assertEquals(response.getStatusCode().value(), 200);
		assertThat(response.getBody().equals(Array.newInstance(getClass(), 0)));

	}	

	// getting avg measurements from a user 24hour grouped
	@Test
	public void getavgUserMeasurements24HourGrouped() throws Exception {
		ResponseEntity<List<Measurement>> response = mController.findAvgByUserIdForDay(user.getId(),
				"2022-01-17 00:00:00 ");
		assertEquals(response.getStatusCode().value(), 200);
		assertThat(response.getBody().equals(Array.newInstance(getClass(), 0)));

	}

	// getting avg measurements from a user 24hour Nothing found
	@Test
	public void getavgUserMeasurements24HourGroupedError() throws Exception {
		ResponseEntity<List<Measurement>> response = mController.findAvgByUserIdForDay(9999L,
				"2000-01-10 00:00:00 ");
		assertEquals(response.getStatusCode().value(), 404);
		assertNull(response.getBody());

	}
		

	// getting avg measurements from a user 7Days grouped
	@Test
	public void getavgUserMeasurements7DaysGrouped() throws Exception {
		ResponseEntity<List<Measurement>> response = mController.findAvgByUserIdForWeek(user.getId(),
				"2022-01-17 00:00:00 ");
		assertEquals(response.getStatusCode().value(), 200);
		assertThat(response.getBody().equals(Array.newInstance(getClass(), 0)));

	}

	// getting avg measurements from a user 7Days Nothing found
	@Test
	public void getavgUserMeasurements7DaysGroupedError() throws Exception {
		ResponseEntity<List<Measurement>> response = mController.findAvgByUserIdForWeek(9999L,
				"2000-01-10 00:00:00 ");
		assertEquals(response.getStatusCode().value(), 404);
		assertNull(response.getBody());

	}	
	
	// getting avg measurements from a user Month grouped
	@Test
	public void getavgUserMeasurementsMonthGrouped() throws Exception {
		ResponseEntity<List<Measurement>> response = mController.findAvgByUserIdForMonth(user.getId(),
				"2022-01-17 00:00:00 ");
		assertEquals(response.getStatusCode().value(), 200);
		assertThat(response.getBody().equals(Array.newInstance(getClass(), 0)));

	}

	// getting avg measurements from a user Month Nothing found
	@Test
	public void getavgUserMeasurementsMonthGroupedError() throws Exception {
		ResponseEntity<List<Measurement>> response = mController.findAvgByUserIdForMonth(9999L,
				"2000-01-10 00:00:00 ");
		assertEquals(response.getStatusCode().value(), 404);
		assertNull(response.getBody());

	}	
	// getting avg measurements from a user Year grouped
	@Test
	public void getavgUserMeasurementsYearGrouped() throws Exception {
		ResponseEntity<List<Measurement>> response = mController.findAvgByUserIdForYear(user.getId(),
				"2022-01-17 00:00:00 ");
		assertEquals(response.getStatusCode().value(), 200);
		assertThat(response.getBody().equals(Array.newInstance(getClass(), 0)));

	}

	// getting avg measurements from a user Year Nothing found
	@Test
	public void getavgUserMeasurementsYearGroupedError() throws Exception {
		ResponseEntity<List<Measurement>> response = mController.findAvgByUserIdForYear(9999L,
				"2000-01-10 00:00:00 ");
		assertEquals(response.getStatusCode().value(), 404);
		assertNull(response.getBody());

	}	
	// getting avg measurements from a user AllTime grouped
	@Test
	public void getavgUserMeasurementsallTimeGrouped() throws Exception {
		ResponseEntity<List<Measurement>> response = mController.findAvgByUserIdForAllTime(user.getId(),
				"2022-01-17 00:00:00 ");
		assertEquals(response.getStatusCode().value(), 200);
		assertThat(response.getBody().equals(Array.newInstance(getClass(), 0)));

	}

	// getting avg measurements from a user AllTime Nothing found
	@Test
	public void getavgUserMeasurementsAllTimeGroupedError() throws Exception {
		ResponseEntity<List<Measurement>> response = mController.findAvgByUserIdForAllTime(9999L,
				"2000-01-10 00:00:00 ");
		assertEquals(response.getStatusCode().value(), 404);
		assertNull(response.getBody());

	}	
	// getting user critical values
	@Test
	public void getCriticals() throws Exception {
		ResponseEntity<Object> response = mController.criticalLevels(user.getId(),
				"2000-01-10 00:00:00 ");
		assertEquals(response.getStatusCode().value(), 200);
		assertThat(response.getBody().equals(Array.newInstance(getClass(), 0)));

	}


		
	
}
