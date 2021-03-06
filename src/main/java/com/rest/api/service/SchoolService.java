package com.rest.api.service;

import java.util.Optional;

import com.rest.api.dto.SchoolDTO;
import com.rest.api.dto.SchoolInsertDTO;
import com.rest.api.dto.SchoolUpdateDTO;
import com.rest.api.entity.School;
import com.rest.api.repository.SchoolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
@Service
public class SchoolService {

    @Autowired
    private SchoolRepository repo;

    public Page<SchoolDTO>getSchools(PageRequest pageRequest){
        Page<School> list = repo.find(pageRequest);
        return list.map(s-> new SchoolDTO(s));
    }

    public SchoolDTO insert(SchoolInsertDTO school){
        School entity = new School(school);
        entity = repo.save(entity);
        return new SchoolDTO(entity);
    }

    public SchoolDTO getSchoolById(long id){
        Optional<School> op = repo.findById(id);
        School school = op.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"School doesn't exsist"));
        return new SchoolDTO(school);
    }

    public void delete(long id){
        try{
            repo.deleteById(id);
        }catch(EmptyResultDataAccessException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"School doesn's exist!");
        }
    }
    public SchoolDTO update(SchoolUpdateDTO schoolUpdateDTO, long id){
        try{
            School school = repo.getOne(id);
            school.setName(schoolUpdateDTO.getName());
            school.setCnpj(schoolUpdateDTO.getCnpj());
            school.setMaxCapacity(schoolUpdateDTO.getMaxCapacity());
            school = repo.save(school);
            return new SchoolDTO(school);
        }
        catch(ResponseStatusException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"School not found");
        }
    }
}
