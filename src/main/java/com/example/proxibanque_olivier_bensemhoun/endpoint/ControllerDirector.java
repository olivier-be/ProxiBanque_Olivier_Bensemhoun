package com.example.proxibanque_olivier_bensemhoun.endpoint;


import com.example.proxibanque_olivier_bensemhoun.Response.DirectorResponse;
import com.example.proxibanque_olivier_bensemhoun.model.Client;
import com.example.proxibanque_olivier_bensemhoun.model.Director;
import com.example.proxibanque_olivier_bensemhoun.service.DirectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ControllerDirector {
    private final DirectorService directorService;

    @GetMapping("/director")
    List<DirectorResponse> getClient()
    {

        return directorService.getDirector().stream().map(  a->directorService.getDirectorResponse(a)).toList() ;
    }


    @PostMapping("/director")
    void saveAgence(@RequestBody Director director)
    {
        directorService.saveDirector(director);
    }

    @GetMapping("/director/{id}")
    ResponseEntity<DirectorResponse> getIdAgence(@PathVariable long id)
    {
        return directorService.getDirectorId(id).map(a->directorService.getDirectorResponse(a)).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
