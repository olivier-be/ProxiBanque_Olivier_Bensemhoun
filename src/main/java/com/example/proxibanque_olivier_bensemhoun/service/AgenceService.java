package com.example.proxibanque_olivier_bensemhoun.service;

import com.example.proxibanque_olivier_bensemhoun.model.Agence;
import com.example.proxibanque_olivier_bensemhoun.repository.AgenceRepo;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AgenceService {


    private final AgenceRepo agenceRepo;

    @PostConstruct
    private void initDB()
    {

        agenceRepo.saveAll(List.of(
                new Agence("a", new Date()),
                new Agence("b",new Date())
        ));
    }


    public Agence saveAgence(Agence agence) {
        return agenceRepo.save(agence);
    }

    public Optional<Agence> getAgenceId(long id) {
        return agenceRepo.findById(id);
    }

    public List<Agence> getAgence() {
        return agenceRepo.findAll();
    }


}
