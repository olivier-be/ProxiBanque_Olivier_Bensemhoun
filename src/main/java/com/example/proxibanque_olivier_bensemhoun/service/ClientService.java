package com.example.proxibanque_olivier_bensemhoun.service;

import com.example.proxibanque_olivier_bensemhoun.model.Agence;
import com.example.proxibanque_olivier_bensemhoun.model.Client;
import com.example.proxibanque_olivier_bensemhoun.model.Employee;
import com.example.proxibanque_olivier_bensemhoun.repository.ClientRepo;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {


    private final ClientRepo agenceRepo;

    @PostConstruct
    private void initDB()
    {

        agenceRepo.saveAll(List.of(
                new Client("a", "","","","",""),
                new Client("b", "","","","","")
        ));
    }


    public Client saveClient(Client client) {
        return agenceRepo.save(client);
    }

    public Optional<Client> getClientId(long id) {
        return agenceRepo.findById(id);
    }

    public List<Client> getClient() {
        return agenceRepo.findAll();
    }


}
