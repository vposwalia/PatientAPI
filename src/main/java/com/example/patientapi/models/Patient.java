package com.example.patientapi.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "patients")
public class Patient {
    @Id
    private String id;
    private String name;
    private int age;
    private String condition;
    private String assignedTherapist;
    private String contactInfo;

    // Constructors
    public Patient() {}

    public Patient(String name, int age, String condition, String assignedTherapist, String contactInfo) {
        this.name = name;
        this.age = age;
        this.condition = condition;
        this.assignedTherapist = assignedTherapist;
        this.contactInfo = contactInfo;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }

    public String getAssignedTherapist() { return assignedTherapist; }
    public void setAssignedTherapist(String assignedTherapist) { this.assignedTherapist = assignedTherapist; }

    public String getContactInfo() { return contactInfo; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }
}
