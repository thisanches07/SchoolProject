package com.rest.api.service;

import com.rest.api.dto.SchoolDTO;
import com.rest.api.entity.School;
import com.rest.api.repository.SchoolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
@Service
public class SchoolService {

    @Autowired
    private SchoolRepository repo;

    public Page<SchoolDTO>getSchools(PageRequest pageRequest){
        Page<School> list = repo.find(pageRequest);
        return list.map(s-> new SchoolDTO(s));
    }
}
