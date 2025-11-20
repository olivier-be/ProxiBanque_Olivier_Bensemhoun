package com.example.proxibanque_olivier_bensemhoun.service;

import com.example.proxibanque_olivier_bensemhoun.model.Client;
import com.example.proxibanque_olivier_bensemhoun.model.Director;
import com.example.proxibanque_olivier_bensemhoun.repository.ClientRepo;
import com.example.proxibanque_olivier_bensemhoun.repository.DirectorRepo;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DirectorService {


    private final DirectorRepo agenceRepo;

    @PostConstruct
    private void initDB()
    {

        agenceRepo.saveAll(List.of(
                new Director("a"),
                new Director("b")
        ));
    }


    public Director saveDirector(Director director) {
        return agenceRepo.save(director);
    }

    public Optional<Director> getDirectorId(long id) {
        return agenceRepo.findById(id);
    }

    public List<Director> getDirector() {
        return agenceRepo.findAll();
    }


}
