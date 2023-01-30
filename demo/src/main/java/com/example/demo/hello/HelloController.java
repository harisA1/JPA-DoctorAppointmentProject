package com.example.demo.hello;

import java.util.*;

import com.example.demo.objectclasses.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

// Since this is the controller, it is the place where we add our end-points
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class HelloController {

	@Autowired
	private HelloService hs;

	//endpoints

	//doctor's endpoints

	//doctor login
	@PostMapping("/addDoctor")
	public void addDoctor(@RequestBody Doctor d) throws Exception {
		hs.addDoctor(d);
	}
	//doctor views all vaccination centers
	@GetMapping("/getVaccinationCenters")
	public List<VaccinationCenter> getVaccinationCenters() throws Exception {
		return hs.getVaccinationCenters();
	}
	//doctor sets timeslot in a vaccination center
	@PostMapping("/addAvailableTimeslot")
	public void addAvailableTimeslot(@RequestBody AvailableTimeslotInVc at) throws Exception {
		hs.addAvailableTimeslot(at);
	}

	//doctor removes a timeslot from the database
	@DeleteMapping(path="/removeTimeslot")
	public void removeTimeslot(@RequestBody Timeslot t) throws Exception {
		hs.removeTimeslot(t);
	}
	//doctor views all appointments he is assigned to
	@PostMapping("/findAppointmentsByDoctor")
	public List<Appointment> findAppointmentsByDoctor(@RequestBody Doctor d) throws Exception {
		return hs.findAppointmentsByDoctor(d);
	}
	//common endpoints
	@GetMapping(path="/getTimeslots")
	public List<Timeslot> getTimeslots()  throws Exception{
		return hs.getTimeslots();
	}
	//patient's endpoints
	//patient login
	@PostMapping("/addPatient")
	public void addPatient(@RequestBody Patient p) throws Exception {
		hs.addPatient(p);
	}
	//patient views timeslots by date
	@GetMapping("/getTimeslotsByDate")
	public List<Timeslot> getTimeslotsByDate(@RequestParam(value="date") String date) throws Exception {
		System.out.println("date passed in controller: " + date);
		return hs.getTimeslotsByDate(date);
	}
	//patient views timeslots for the whole month
	//call by localhost:8080/getByMonth?month=/xx/,xx:the month
	@GetMapping(path="/getByMonth")
	public List<Timeslot> getByMonth(@RequestParam(value="month") String month)  throws Exception{
		return hs.getByMonth(month);
	}
	//patient books a timeslot with his data -> adds appointment to database
	@PostMapping("/addAppointment")
	public void addAppointment(@RequestBody Appointment a) throws Exception {
		hs.addAppointment(a);
	}
	//patient deletes an appointment - cant be called more than 2 times
	private int numCalls = 0;
	@DeleteMapping(path="/removeAppointment")
	public Boolean removeAppointment(@RequestBody Appointment a)  {
		if(numCalls < 2) {
			hs.removeAppointment(a);
			numCalls++;
		}else{
			System.out.println("Appointment can't be deleted more than 2 times");
			return false;
		}
		return true;
	}
	//patient views his appointment
	@PostMapping("/findAppointmentByPatient")
	public <List>Appointment findAppointmentsByPatient(@RequestBody Patient p) throws Exception {
		return hs.findAppointmentsByPatient(p);
	}
	@PostMapping("/findVaccinationByPatient")
	public <List>Vaccination findVaccinationByPatient(@RequestBody Patient p) throws Exception{
		return hs.findVaccinationByPatient(p);
	}

	// admin endpoints
	//patients list
	@GetMapping(path="/getPatients")
	public List<Patient> getPatients()  throws Exception{
		return hs.getPatients();
	}
	//doctors list
	@GetMapping(path="/getDoctors")
	public List<Doctor> getDoctors()  throws Exception{
		return hs.getDoctors();
	}
	//adds a vaccination center to the database - admin
	@PostMapping("/addVaccinationCenter")
	public void addVaccinationCenter(@RequestBody VaccinationCenter vc) throws Exception {
		hs.addVaccinationCenter(vc);
	}
	//adds a timeslot to the database - never necessary
	@PostMapping("/addTimeslot")
	public void addTimeslot(@RequestBody Timeslot t) throws Exception {
		hs.addTimeslot(t);
	}
	//not necessary - doctor uses findAppointmentByDoctor
	@GetMapping(path="/getAppointments")
	public List<Appointment> getAppointments()  throws Exception{
		return hs.getAppointments();
	}

	@GetMapping(path="/getVaccinations")
	public List<Vaccination> getVaccinations() throws Exception{
		return hs.getVaccinations();
	}

	@PostMapping(path="/addVaccination")
	public void addVaccination(@RequestBody Vaccination v) throws Exception{
		System.out.println("CONTROLLER DATE"+v.getDate());
		System.out.println("CONTROLLER DOCTOR: "+ v.getDoctor().getDoctorname());
		System.out.println("CONTROLLER PATIENT: "+ v.getPatient().getName());
		hs.addVaccination(v);
	}














}
