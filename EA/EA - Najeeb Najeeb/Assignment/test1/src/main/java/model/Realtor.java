package model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Realtor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long noOfEmployees;

    public Realtor() {
    }

    public Long getNoOfEmployees() {
        return noOfEmployees;
    }

    public void setNoOfEmployees(Long noOfEmployees) {
        this.noOfEmployees = noOfEmployees;
    }

}
