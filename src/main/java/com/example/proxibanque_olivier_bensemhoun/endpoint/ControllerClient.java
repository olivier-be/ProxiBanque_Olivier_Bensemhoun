package com.example.proxibanque_olivier_bensemhoun.endpoint;


import com.example.proxibanque_olivier_bensemhoun.model.Agence;
import com.example.proxibanque_olivier_bensemhoun.model.Client;
import com.example.proxibanque_olivier_bensemhoun.service.AgenceService;
import com.example.proxibanque_olivier_bensemhoun.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ControllerClient {
    private final ClientService clientService;

    @GetMapping("/client")
    List<Client> getClient()
    {
        return clientService.getClient();
    }


    @PostMapping("/client")
    void saveAgence(@RequestBody Client client)
    {
        clientService.saveClient(client);
    }

    @GetMapping("/client/{id}")
    ResponseEntity<Client> getIdAgence(@PathVariable long id)
    {
        return clientService.getClientId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
