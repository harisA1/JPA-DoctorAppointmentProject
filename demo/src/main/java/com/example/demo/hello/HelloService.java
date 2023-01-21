package com.example.demo.hello;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import com.example.demo.objectclasses.*;
import com.example.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

@Service
public class HelloService {

	//object repositories
	@Autowired
	private DoctorRepository doctorRepository;
	@Autowired
	private VaccinationCenterRepository vaccinationCenterRepository;
	@Autowired
	private TimeslotRepository timeslotRepository;
	@Autowired
	private PatientRepository patientRepository;


	// addObject methods
	// responds to the endpoint /addDoctor
	public void addDoctor (Doctor d) throws Exception {
		System.out.println("in service doctor amka: " + d.getDamka());
		System.out.println("in service doctor name: " + d.getDoctorname());

		Optional<Doctor> byId = doctorRepository.findById(d.getDamka());
		if(!byId.isPresent()) {doctorRepository.save(d);
		} else {throw new Exception("Doctor already exists");}
	}
	// responds to the endpoint /addStudent
	public void addPatient(Patient p) throws Exception {
		Optional<Patient> byId = patientRepository.findById(p.getAmka());
		if (!byId.isPresent()) {patientRepository.save(p);
		} else {throw new Exception("Patient already exists");}
	}
	// responds to the endpoint /addTimeslot
	public void addTimeslot(Timeslot t) throws Exception {
		System.out.println("in service timeslot id: " + t.getTid());
		System.out.println("in service timeslot date: " + t.getDate());
		System.out.println("in service timeslot start: " + t.getStart());
		System.out.println("in service timeslot end: " + t.getEnd());

		Optional<Timeslot> byId = timeslotRepository.findById(t.getTid());
		if(!byId.isPresent()) {timeslotRepository.save(t);
		} else {throw new Exception("Timeslot already exists");}
	}

	// no endpoint for this method - vaccination centers are added by configuration
	public void addVaccinationCenter(VaccinationCenter vc) throws Exception {
		Optional<VaccinationCenter> byId = vaccinationCenterRepository.findById(vc.getVcname());
		if (!byId.isPresent()) {vaccinationCenterRepository.save(vc);
		} else {throw new Exception("Vaccination center already exists");}
	}









	public List<VaccinationCenter> getVaccinationCenters() throws Exception {
		return vaccinationCenterRepository.findAll();
	}
	public List<Timeslot> getTimeslots() throws Exception {
		return timeslotRepository.findAll();
	}

	public List<Timeslot> getTimeslotsByDate(String date) throws Exception {
		List<Timeslot> timeslots = timeslotRepository.findAll();

		List<Timeslot> timeslotsByDate = timeslotRepository.findByDate(date);


		for (Timeslot t : timeslots) {
			System.out.println("in service timeslot id: " + t.getTid());
			System.out.println("in service timeslot date: " + t.getDate() + "date is: " + date);
			System.out.println("in service timeslot start: " + t.getStart());
			System.out.println("in service timeslot end: " + t.getEnd());
		}

		return timeslotsByDate;
		/*
		System.out.println("date passed in service: " + date);
		ArrayList<Timeslot> timeslotsByDate = timeslotRepository.findByStart(date);
		for (Timeslot t : timeslotsByDate) {
			System.out.println("timeslot that date: " + t.getTid());
		}
		System.out.println("size of timeslots that date: " + timeslotsByDate.size());
		System.out.println("type of timeslots that date: " + timeslotsByDate.getClass());

		return timeslotsByDate;
	*/
	}




    public List<Patient> getPatients() {
		return patientRepository.findAll();
    }

	public List<Doctor> getDoctors() {
		return doctorRepository.findAll();
	}


	public void bookTimeslot(BookedTimeslot a) throws Exception {
		Patient p = a.getPatient();
		Timeslot t = a.getTimeslot();

		System.out.println("in service patient amka: " + p.getAmka());
		System.out.println("in service patient name: " + p.getName());
		System.out.println(("in service patient surname: " + p.getSurname()));
		System.out.println("in service timeslot id: " + t.getTid());
		System.out.println("in service timeslot date: " + t.getDate());
		System.out.println("in service timeslot start: " + t.getStart());
		System.out.println("in service timeslot end: " + t.getEnd());

		t.setPatient(p);
		timeslotRepository.save(t);
	}

	public void addAvailableTimeslot(AvailableTimeslot at) {
		Doctor d = at.getDoctor();
		Timeslot t = at.getTimeslot();

		System.out.println("in service doctor amka: " + d.getDamka());
		System.out.println("in service doctor name: " + d.getDoctorname());
		System.out.println("in service timeslot id: " + t.getTid());
		System.out.println("in service timeslot date: " + t.getDate());
		System.out.println("in service timeslot start: " + t.getStart());
		System.out.println("in service timeslot end: " + t.getEnd());

		t.setDoctor(d);
		timeslotRepository.save(t);
	}

	public void removeTimeslot(Timeslot t) {
		System.out.println("to be deleted timeslot id: " + t.getTid());
		System.out.println("to be deleted timeslot date: " + t.getDate());
		System.out.println("to be deleted timeslot start: " + t.getStart());
		System.out.println("to be deleted timeslot end: " + t.getEnd());

		t.setPatient(null);
		t.setDoctor(null);

		timeslotRepository.delete(t);

	}
}

	//JSON response FOR the endpoint /bookTimeslot:
/* {
			"patient": {
		"name": "Michael",
		"amka": "20231",
		"surname": "Jackson"
		},
		"timeslot": {
		"date": "14/07/2021",
		"start": "15:00"

		}
		} */
