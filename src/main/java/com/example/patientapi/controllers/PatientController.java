package com.example.patientapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.patientapi.models.Patient;
import com.example.patientapi.services.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    // POST /patients: Add a new patient record
    @PostMapping
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        Patient newPatient = patientService.addPatient(patient);
        return new ResponseEntity<>(newPatient, HttpStatus.CREATED);
    }

    // GET /patients: Retrieve a list of all patients
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    // GET /patients/{id}: Retrieve details of a specific patient by their ID
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable String id) {
        Optional<Patient> patient = patientService.getPatientById(id);
        return patient.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // PUT /patients/{id}: Update an existing patient's information
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable String id, @RequestBody Patient updatedPatient) {
        Patient patient = patientService.updatePatient(id, updatedPatient);
        if (patient != null) {
            return new ResponseEntity<>(patient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE /patients/{id}: Remove a patient's record
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable String id) {
        boolean isDeleted = patientService.deletePatient(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
