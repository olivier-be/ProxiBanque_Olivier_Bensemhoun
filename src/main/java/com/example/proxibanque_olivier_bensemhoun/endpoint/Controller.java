package com.example.proxibanque_olivier_bensemhoun.endpoint;

import com.example.proxibanque_olivier_bensemhoun.Response.AgenceResponse;
import com.example.proxibanque_olivier_bensemhoun.model.Agence;
import com.example.proxibanque_olivier_bensemhoun.model.Director;
import com.example.proxibanque_olivier_bensemhoun.service.AgenceService;
import com.example.proxibanque_olivier_bensemhoun.service.DirectorService;
import com.example.proxibanque_olivier_bensemhoun.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final AgenceService agenceService;
    private final DirectorService directorService;
    private final EmployeeService employeeService;


    @GetMapping("/agence")
    List<AgenceResponse> getAgence()
    {
        var l = agenceService.getAgence().stream().map(a ->
                agenceService.AgenceResponse(a)
        );
        return l.toList();
    }


    @PostMapping("/agence")
    void saveAgence(@RequestBody Agence client)
    {
        agenceService.saveAgence(client);
    }

    @GetMapping("/agence/{id}")
    ResponseEntity<AgenceResponse> getIdAgence(@PathVariable long id)
    {
        return agenceService.getAgenceId(id).map(a -> agenceService.AgenceResponse(a)).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
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

    @GetMapping("/agence/{id}/employee/{idEmployee}")
    ResponseEntity<Agence> setEmployeeAgence(@PathVariable long id, @PathVariable long idEmployee)
    {
        var d = employeeService.getEmployeeId(idEmployee);
        System.out.println("idDirector: " + idEmployee);

        System.out.println("found: " + d.isPresent());
        if (d.isPresent())
        {
            if (agenceService.addEmployee(id,d.get())) {
                return ResponseEntity.ok(agenceService.getAgenceId(id).get());
            }
            else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

}
