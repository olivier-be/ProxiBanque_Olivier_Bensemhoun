package com.example.proxibanque_olivier_bensemhoun.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue
    private Long id;

    private String nom;

    public Employee(String nom) {
        this.nom = nom;
    }

    @ManyToOne()
    private Agence agence;

}
