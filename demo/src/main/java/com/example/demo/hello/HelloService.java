package com.example.demo.hello;

import java.sql.Time;
import java.util.*;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.demo.objectclasses.*;
import com.example.demo.repositories.*;
import com.sun.xml.bind.v2.runtime.output.SAXOutput;
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
	@Autowired
	private VaccinationRepository vaccinationRepository;


	// addObject methods
	// responds to the endpoint /addDoctor
	public void addDoctor (Doctor d) throws Exception{
		Optional<Doctor> byId = doctorRepository.findByDamka(d.getDamka());
		if(!byId.isPresent()) {
			doctorRepository.save(d);
		} else {
			System.out.println("Doctor already exists!");
		}
	}
	// responds to the endpoint /addPatient
	public void addPatient(Patient p) throws Exception {
		Optional<Patient> byId = patientRepository.findById(p.getAmka());
		if (!byId.isPresent()) {
			patientRepository.save(p);
		} else {
		throw new Exception("Patient already exists!");
		}
	}
	// responds to the endpoint /addTimeslot
	public void addTimeslot(Timeslot t) throws Exception {
		Optional<Timeslot> byId = timeslotRepository.findById(t.getTimeslotID());
		if(!byId.isPresent()) {timeslotRepository.save(t);
		} else {
			throw new Exception("Timeslot already exists!");
		}
	}
	// responds to the endpoint /addAppointment
	public void addAppointment(Appointment a) throws Exception {
		Optional<Appointment> byId =appointmentRepository.findById(a.getAppointmentID());
		if(!byId.isPresent()){
		appointmentRepository.save(a);
	}else{
		throw new Exception("Appointment Already exists");}
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
	// methods for specific objects
	public List<Timeslot> getByMonth(String month) {
		return timeslotRepository.findByDateContaining(month);
	}
	public List<Timeslot> getTimeslotsByDate(String date) throws Exception {
		List<Timeslot> timeslotsByDate = timeslotRepository.findByDate(date);
		return timeslotsByDate;
	}
	public <List>Appointment findAppointmentsByPatient(Patient p) {
		return appointmentRepository.findByPatient(p);
	}
	public List<Appointment> findAppointmentsByDoctor(Doctor d) {
		return appointmentRepository.findByTimeslotDoctor(d);
	}
	//remove methods
	public void removeTimeslot(Timeslot t) {
		timeslotRepository.delete(t);
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
	public void addVaccination(Vaccination v){
		v.setDate(v.getDate());
		v.setExpdate(v.getDate());

		v.setvID("3" +v.getPatient().getAmka());
		System.out.println("THE VAC DATE YO: "+v.getDate());
		System.out.println("THE DOCTOR: "+ v.getDoctor().getDoctorname());
		System.out.println("THE PATIENT: "+ v.getPatient().getName());
//		v.setDoctor(v.getDoctor());
//		v.setPatient(v.getPatient());
		vaccinationRepository.save(v);
	}

	public List<Vaccination> getVaccinations() {
		return vaccinationRepository.findAll();
	}

	public Vaccination findVaccinationByPatient(Patient p) {

		return vaccinationRepository.findByPatient(p);
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
