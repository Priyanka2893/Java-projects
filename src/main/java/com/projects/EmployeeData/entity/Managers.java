package com.projects.EmployeeData.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="managers")
public class Managers {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "managers_sequence")
    @SequenceGenerator(name = "managers_sequence", sequenceName = "managers_id_seq", allocationSize = 1)
    private int id;
    @Column(name = "First Name")
    private String fName;
    @Column(name = "Last Name")
    private String lName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
}
