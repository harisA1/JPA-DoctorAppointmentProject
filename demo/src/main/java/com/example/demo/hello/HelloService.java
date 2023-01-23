package com.example.demo.hello;

import java.sql.Time;
import java.util.*;

import com.example.demo.objectclasses.*;
import com.example.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
	@Autowired
	private AppointmentRepository appointmentRepository;


	// addObject methods
	// responds to the endpoint /addDoctor
	public Boolean addDoctor (Doctor d) {
		Boolean exists ;
		Optional<Doctor> byId = doctorRepository.findByDamka(d.getDamka());
		if(!byId.isPresent()) {
			doctorRepository.save(d);
			exists = false;
		} else {
			System.out.println("Doctor already exists");
			exists = true;
		}
		return exists;
	}
	// responds to the endpoint /addPatient
	public void addPatient(Patient p) throws Exception {
		patientRepository.save(p);
	}
	// responds to the endpoint /addTimeslot
	public void addTimeslot(Timeslot t) throws Exception {
		Optional<Timeslot> byId = timeslotRepository.findById(t.getTimeslotID());
		if(!byId.isPresent()) {timeslotRepository.save(t);
		} else {throw new Exception("Timeslot already exists");}
	}
	// responds to the endpoint /addAppointment
	public void addAppointment(Appointment a) throws Exception {
		appointmentRepository.save(a);
	}
	// no endpoint for this method - vaccination centers are added by configuration
	public void addVaccinationCenter(VaccinationCenter vc) throws Exception {
		Optional<VaccinationCenter> byId = vaccinationCenterRepository.findById(vc.getVcname());
		if (!byId.isPresent()) {vaccinationCenterRepository.save(vc);
		} else {throw new Exception("Vaccination center already exists");}
	}
	// responds to the endpoint /addAvailableTimeslot
	// sets doctor and VC in timeslot
	// adds timeslot to the database
	public void addAvailableTimeslot(AvailableTimeslotInVc at) {
		Doctor d = at.getDoctor();
		Timeslot t = at.getTimeslot();
		VaccinationCenter vc = at.getVaccinationCenter();

		t.setDoctor(d);
		t.getEnd();
		t.setVaccinationCenter(vc);
		timeslotRepository.save(t);



		//remove appointment method needs to uncomment
	}
	//get methods for all objects
	public List<VaccinationCenter> getVaccinationCenters() throws Exception {
		return vaccinationCenterRepository.findAll();
	}
	public List<Timeslot> getTimeslots() throws Exception {
		return timeslotRepository.findAll();
	}
    public List<Patient> getPatients() throws Exception {
		return patientRepository.findAll();
    }
	public List<Doctor> getDoctors() throws Exception{
		return doctorRepository.findAll();
	}
	public List<Appointment> getAppointments() throws Exception{
		return appointmentRepository.findAll();
	}
	//get methods for specific objects
	public List<Timeslot> getByMonth(String month) {
		return timeslotRepository.findByDateContaining(month);
	}
	public List<Timeslot> getTimeslotsByDate(String date) throws Exception {
		List<Timeslot> timeslotsByDate = timeslotRepository.findByDate(date);
		return timeslotsByDate;
	}
	//remove methods
	public void removeTimeslot(Timeslot t) {
		System.out.println("to be deleted timeslot id: " + t.getTimeslotID());
		System.out.println("to be deleted timeslot date: " + t.getDate());
		System.out.println("to be deleted timeslot start: " + t.getStart());
		System.out.println("to be deleted timeslot end: " + t.getEnd());
		timeslotRepository.deleteById(t.getTimeslotID());
	}
	public void removeAppointment(Appointment a) {
		//finds the timeslot from the appointment to be deleted
		Timeslot t =timeslotRepository.findByTimeslotID(a.getTimeslot().getTimeslotID());
		//creates new supporting class object in order to store the timeslot back to the database
		VaccinationCenter vc = t.getVaccinationCenter();
		Doctor d = t.getDoctor();
		AvailableTimeslotInVc at = new AvailableTimeslotInVc(t,vc,d);
		//deletes appointment
		appointmentRepository.delete(a);
		//adds the timeslot back to the database
		addAvailableTimeslot(at);
	}



	public <List>Appointment findAppointmentsByPatient(Patient p) {
		return appointmentRepository.findByPatient(p);
	}


	public List<Appointment> findAppointmentsByDoctor(Doctor d) {
		return appointmentRepository.findByTimeslotDoctor(d);

	}
}

	//JSON  FOR the endpoint /bookTimeslot:
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
