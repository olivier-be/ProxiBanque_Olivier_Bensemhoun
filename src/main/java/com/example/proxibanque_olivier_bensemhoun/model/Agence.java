package com.example.proxibanque_olivier_bensemhoun.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
public class Agence {
    @Id
    @GeneratedValue
    private Long id;

    private String agenceId;

    private Date date;

    /*
    @OneToOne
    private Director director;


    @OneToMany()
    private Set<Employee> advisor;

    Agence(String agenceId, Date date, Set<Employee> advisor, Director director) {
        this.agenceId = agenceId;
        this.date = date;
        this.advisor = advisor;
        this.director = director;

    }
    */

    public Agence(String agenceId, Date date) {
        this.agenceId = agenceId;
        this.date = date;
    }
}
