package com.example.proxibanque_olivier_bensemhoun.endpoint;


import com.example.proxibanque_olivier_bensemhoun.Response.EmployeeResponse;
import com.example.proxibanque_olivier_bensemhoun.model.Employee;
import com.example.proxibanque_olivier_bensemhoun.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ControllerEmployee {
    private final EmployeeService employeeService;

    @GetMapping("/employee")
    List<EmployeeResponse> getClient()
    {
        return employeeService.getEmployee().stream().map(a -> employeeService.getEmployeeResponse(a)).toList();
    }


    @PostMapping("/employee")
    void saveAgence(@RequestBody Employee director)
    {
        employeeService.saveEmployee(director);
    }

    @GetMapping("/employee/{id}")
    ResponseEntity<EmployeeResponse> getIdAgence(@PathVariable long id)
    {
        return employeeService.getEmployeeId(id).map(a -> employeeService.getEmployeeResponse(a)).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
