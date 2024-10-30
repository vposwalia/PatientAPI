package com.example.patientapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.patientapi.models.Patient;
import com.example.patientapi.repositories.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // Create a new patient
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    // Get all patients
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Get a patient by ID
    public Optional<Patient> getPatientById(String id) {
        return patientRepository.findById(id);
    }

    // Update an existing patient
    public Patient updatePatient(String id, Patient updatedPatient) {
        Optional<Patient> existingPatient = patientRepository.findById(id);
        if (existingPatient.isPresent()) {
            Patient patient = existingPatient.get();
            patient.setName(updatedPatient.getName());
            patient.setAge(updatedPatient.getAge());
            patient.setCondition(updatedPatient.getCondition());
            patient.setAssignedTherapist(updatedPatient.getAssignedTherapist());
            patient.setContactInfo(updatedPatient.getContactInfo());
            return patientRepository.save(patient);
        } else {
            return null;  // Handle case when patient is not found
        }
    }

    // Delete a patient by ID
    public boolean deletePatient(String id) {
        if (patientRepository.existsById(id)) {
            patientRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
