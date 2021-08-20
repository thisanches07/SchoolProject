package com.rest.api.service;

import com.rest.api.dto.DirectorDTO;
import com.rest.api.entity.Director;
import com.rest.api.repository.DirectorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class DirectorService {

    @Autowired
    private DirectorRepository repo;

    public Page<DirectorDTO>getDirectors(PageRequest pageRequest){
        Page<Director> list = repo.find(pageRequest);
        return list.map(d-> new DirectorDTO(d));
    }
}
