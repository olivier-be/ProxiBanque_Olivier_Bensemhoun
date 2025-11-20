package com.example.proxibanque_olivier_bensemhoun.endpoint;

import com.example.proxibanque_olivier_bensemhoun.model.Agence;
import com.example.proxibanque_olivier_bensemhoun.service.AgenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final AgenceService agenceService;

    @GetMapping("/agence")
    List<Agence> getAgence()
    {
        return agenceService.getAgence();
    }


    @PostMapping("/agence")
    void saveAgence(@RequestBody Agence client)
    {
        agenceService.saveAgence(client);
    }

    @GetMapping("/agence/{id}")
    ResponseEntity<Agence> getIdAgence(@PathVariable long id)
    {
        return agenceService.getAgenceId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

}
