package com.example.proxibanque_olivier_bensemhoun.endpoint;

import com.example.proxibanque_olivier_bensemhoun.model.Agence;
import com.example.proxibanque_olivier_bensemhoun.model.Director;
import com.example.proxibanque_olivier_bensemhoun.service.AgenceService;
import com.example.proxibanque_olivier_bensemhoun.service.DirectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final AgenceService agenceService;
    private final DirectorService directorService;


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

    @GetMapping("/agence/{id}/director/{idDirector}")
    ResponseEntity<Agence> setDirectorIdAgence(@PathVariable long id, @PathVariable long idDirector)
    {
        var d = directorService.getDirectorId(idDirector);
        System.out.println("idDirector: " + idDirector);

        System.out.println("found: " + d.isPresent());
        if (d.isPresent())
        {
            return ResponseEntity.ok(agenceService.setDirector(id,d.get()));
        }
        return ResponseEntity.notFound().build();
    }

}
