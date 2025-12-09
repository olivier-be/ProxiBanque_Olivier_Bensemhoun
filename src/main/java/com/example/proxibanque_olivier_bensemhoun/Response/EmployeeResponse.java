package com.example.proxibanque_olivier_bensemhoun.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EmployeeResponse {
    @JsonProperty
    private Long id;
    @JsonProperty
    private String nom;


    @JsonProperty
    private Long agenceId;

}
