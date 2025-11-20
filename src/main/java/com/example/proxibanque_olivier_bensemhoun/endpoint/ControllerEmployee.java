package com.example.proxibanque_olivier_bensemhoun.endpoint;


import com.example.proxibanque_olivier_bensemhoun.model.Director;
import com.example.proxibanque_olivier_bensemhoun.model.Employee;
import com.example.proxibanque_olivier_bensemhoun.service.DirectorService;
import com.example.proxibanque_olivier_bensemhoun.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ControllerEmployee {
    private final EmployeeService directorService;

    @GetMapping("/employee")
    List<Employee> getClient()
    {
        return directorService.getEmployee();
    }


    @PostMapping("/employee")
    void saveAgence(@RequestBody Employee director)
    {
        directorService.saveEmployee(director);
    }

    @GetMapping("/employee/{id}")
    ResponseEntity<Employee> getIdAgence(@PathVariable long id)
    {
        return directorService.getEmployeeId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
