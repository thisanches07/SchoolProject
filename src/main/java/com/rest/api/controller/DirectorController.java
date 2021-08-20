package com.rest.api.controller;

import com.rest.api.dto.DirectorDTO;
import com.rest.api.service.DirectorService;

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
@RequestMapping("/directors")
public class DirectorController {

   @Autowired
    private DirectorService service;

    @GetMapping
    public ResponseEntity<Page<DirectorDTO>> getDirectors(
        @RequestParam(value = "page",         defaultValue = "0")Integer page,          //pagina corrente
        @RequestParam(value = "linesPerPage", defaultValue = "6") Integer linesPerPage, //linhas por pagina
        @RequestParam(value = "direction",    defaultValue = "ASC") String direction,   //direcao
        @RequestParam(value = "orderBy",      defaultValue = "id") String orderBy,      //ordenacao
        @RequestParam(value = "name",      defaultValue = "") String name,              //nome
        @RequestParam(value = "cpf",      defaultValue = "") String cpf//cpf  
          ){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
        Page<DirectorDTO> list = service.getDirectors(pageRequest);
     return ResponseEntity.ok(list); 
    }
}
