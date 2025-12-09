package com.example.proxibanque_olivier_bensemhoun.model;


import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "advisor_id")

    private Agence agence;

}
