package com.rest.api.dto;

import com.rest.api.entity.School;

public class SchoolDTO {
    private Long id;
    private String name;
    private String cnpj;
    private Integer maxCapacity;

    public SchoolDTO(){

    }
    public SchoolDTO(Long id,String name,String cnpj, Integer maxCapacity){
        setId(id);
        setCnpj(cnpj);
        setName(name);
        setMaxCapacity(maxCapacity);
    }
    public SchoolDTO(School school){
        this.id = school.getId();
        this.name = school.getName();
        this.cnpj=school.getCnpj();
        this.maxCapacity=school.getMaxCapacity();

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
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public Integer getMaxCapacity() {
        return maxCapacity;
    }
    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
    
    
}
