package com.example.proxibanque_olivier_bensemhoun.Response;

import com.example.proxibanque_olivier_bensemhoun.model.Agence;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class AgenceResponse {
    @JsonProperty
    private Long id;

    @JsonProperty
    private String agenceId;

    @JsonProperty
    private Date date;

    @JsonProperty
    private DirectorResponse director;

    @JsonProperty
    private List<EmployeeResponse> employee;



}
