package com.rest.api.dto;

import com.rest.api.entity.Director;

public class DirectorDTO {
    private Long id;
    private String name;
    private String cpf;

    public DirectorDTO(){

    }
    public DirectorDTO(Long id, String name,String cpf){
        setId(id);
        setName(name);
        setCpf(cpf);
    }
    public DirectorDTO(Director director){
        this.id=director.getId();
        this.name=director.getName();
        this.cpf=director.getCpf();

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

    
}
