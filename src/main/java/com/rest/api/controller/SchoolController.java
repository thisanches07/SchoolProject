package com.rest.api.controller;

import com.rest.api.dto.SchoolDTO;
import com.rest.api.service.SchoolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schools")
public class SchoolController {

    @Autowired
    private SchoolService service;

    @GetMapping
    public ResponseEntity<Page<SchoolDTO>> getSchools(
        @RequestParam(value = "page",         defaultValue = "0")Integer page,          //pagina corrente
        @RequestParam(value = "linesPerPage", defaultValue = "6") Integer linesPerPage, //linhas por pagina
        @RequestParam(value = "direction",    defaultValue = "ASC") String direction,   //direcao
        @RequestParam(value = "orderBy",      defaultValue = "id") String orderBy,      //ordenacao
        @RequestParam(value = "name",      defaultValue = "") String name,              //nome
        @RequestParam(value = "cnpj",      defaultValue = "") String cnpj,//cnpj
        @RequestParam(value = "maxCapacity",      defaultValue = "") Integer maxCapacity   //capacidade maxima
    ){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
        Page<SchoolDTO> list = service.getSchools(pageRequest);
     return ResponseEntity.ok(list); 
    }
}
