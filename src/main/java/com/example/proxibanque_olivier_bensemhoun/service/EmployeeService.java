package com.example.proxibanque_olivier_bensemhoun.service;

import com.example.proxibanque_olivier_bensemhoun.Response.DirectorResponse;
import com.example.proxibanque_olivier_bensemhoun.Response.EmployeeResponse;
import com.example.proxibanque_olivier_bensemhoun.model.Agence;
import com.example.proxibanque_olivier_bensemhoun.model.Director;
import com.example.proxibanque_olivier_bensemhoun.model.Employee;
import com.example.proxibanque_olivier_bensemhoun.repository.AgenceRepo;
import com.example.proxibanque_olivier_bensemhoun.repository.EmployeeRepo;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {


    private final EmployeeRepo agenceRepo;

    @PostConstruct
    private void initDB()
    {

        agenceRepo.saveAll(List.of(
                new Employee("a"),
                new Employee("b")
        ));
    }


    public Employee saveEmployee(Employee employee) {
        return agenceRepo.save(employee);
    }

    public Optional<Employee> getEmployeeId(long id) {
        return agenceRepo.findById(id);
    }

    public List<Employee> getEmployee() {
        return agenceRepo.findAll();
    }

    //convert to DTO
    public EmployeeResponse getEmployeeResponse(Employee employee) {
        if (employee == null)
        {
            return null;
        }
        Long id = null;
        if (employee.getAgence() != null)
        {
            id = employee.getAgence().getId();
        }
        return new EmployeeResponse(employee.getId(), employee.getNom(),id);

    }

}
