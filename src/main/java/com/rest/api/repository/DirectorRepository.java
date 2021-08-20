package com.rest.api.repository;

import com.rest.api.entity.Director;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director,Long>{
    @Query("SELECT d FROM Director d ")
    public Page<Director> find(Pageable pageRequest);

}
