package com.example.patientapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.patientapi.models.Patient;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {
    
}
