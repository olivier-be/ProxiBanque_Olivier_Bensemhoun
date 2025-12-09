package com.example.proxibanque_olivier_bensemhoun.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@Getter
@Setter
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    public Director(String nom) {
        this.nom = nom;
    }



    @OneToOne(mappedBy = "director")
    private Agence agence;

}
