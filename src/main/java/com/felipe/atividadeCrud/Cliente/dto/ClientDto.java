package com.felipe.atividadeCrud.Cliente.dto;

import com.felipe.atividadeCrud.Cliente.Entity.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.Instant;
import java.time.LocalDate;

public class ClientDto {

    private Long id;
    @NotBlank(message = "Campo requerido")
    private String name;
    private String cpf;
    private Double income;
    @PastOrPresent(message = "Data de nascimento: não pode ser data futura")
    private LocalDate birthDate;
    private Integer children;

    public ClientDto(){

    }

    public ClientDto(Client client) {
        id = client.getId();
        name = client.getName();
        cpf = client.getCpf();
        income = client.getIncome();
        birthDate = client.getBirthDate();
        children = client.getChildren();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }
}
