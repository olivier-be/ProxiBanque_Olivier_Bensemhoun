package com.example.proxibanque_olivier_bensemhoun.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@Getter
@Setter
public class Client {
        @Id
        @GeneratedValue
        private Long id;

        private String nom;
        private String prenom;
        private String adresse;
        private String codePostal;
        private String ville;
        private String telephone;
        public Client(String Nom, String Prenom, String adresse, String codePostal, String ville, String telephone) {
            this.nom = Nom;
            this.prenom = Prenom;
            this.adresse = adresse;
            this.codePostal = codePostal;
            this.ville = ville;
            this.telephone = telephone;
        }
}
