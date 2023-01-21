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
		System.out.println("in controller doctor amka: " + d.getDamka());
		System.out.println("in controller doctor name: " + d.getDoctorname());
		hs.addDoctor(d);
	}
	//doctor views all vaccination centers
	@GetMapping("/getVaccinationCenters")
	public List<VaccinationCenter> getVaccinationCenters() throws Exception {
		return hs.getVaccinationCenters();
	}
	//doctor sets timeslot for vaccination
	@PostMapping("/addAvailableTimeslot")
	public void addAvailableTimeslot(@RequestBody AvailableTimeslot at) throws Exception {
		hs.addAvailableTimeslot(at);
	}
	//adds a timeslot to the database
	@PostMapping("/addTimeslot")
	public void addTimeslot(@RequestBody Timeslot t) throws Exception {
		hs.addTimeslot(t);
	}

	//common endpoints
	@GetMapping(path="/getTimeslots")
	public List<Timeslot> getTimeslots()  throws Exception{
		return hs.getTimeslots();
	}
	//removes a timeslot from the database
	@DeleteMapping(path="/removeTimeslot")
	public void removeTimeslot(@RequestBody Timeslot t) throws Exception {
		hs.removeTimeslot(t);
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
	//patient books a timeslot with his data
	@PostMapping("/bookTimeslot")
	public void bookTimeslot(@RequestBody BookedTimeslot a) throws Exception {
		hs.bookTimeslot(a);
	}


	@PostMapping("/addVaccinationCenter")
	public void addVaccinationCenter(@RequestBody VaccinationCenter vc) throws Exception {
		hs.addVaccinationCenter(vc);
	}


	

	




	@GetMapping(path="/getPatients")
	public List<Patient> getPatients()  throws Exception{
		return hs.getPatients();
	}

	@GetMapping(path="/getDoctors")
	public List<Doctor> getDoctors()  throws Exception{
		return hs.getDoctors();
	}













}
