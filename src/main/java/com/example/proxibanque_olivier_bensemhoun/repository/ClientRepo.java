package com.example.proxibanque_olivier_bensemhoun.repository;

import com.example.proxibanque_olivier_bensemhoun.model.Client;
import com.example.proxibanque_olivier_bensemhoun.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client,Long> {
}
