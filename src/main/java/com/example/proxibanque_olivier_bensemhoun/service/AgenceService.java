package com.example.proxibanque_olivier_bensemhoun.service;

import com.example.proxibanque_olivier_bensemhoun.model.Agence;
import com.example.proxibanque_olivier_bensemhoun.model.Client;
import com.example.proxibanque_olivier_bensemhoun.model.Director;
import com.example.proxibanque_olivier_bensemhoun.model.Employee;
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

    public Agence setDirector(long agenceId, Director director) {
         var t = agenceRepo.findById(agenceId);
        if (t.isPresent()) {
             Agence res=  t.get();
             res.setDirector(director);
            agenceRepo.save(res);
            return res;

        }
        return null;
    }

    public Boolean addEmployee(long agenceId, Employee employee) {
        var t = agenceRepo.findById(agenceId);
        if (t.isPresent()) {
             var l = t.get().getAdvisor();
             l.add(employee);
             var res = t.get();
             res.setAdvisor(l);
             agenceRepo.save(res);
        }
        return t.isPresent();
    }


}
