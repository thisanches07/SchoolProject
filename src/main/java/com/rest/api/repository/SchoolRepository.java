package com.rest.api.repository;

import com.rest.api.entity.School;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School,Long>{
    @Query("SELECT s FROM School s ")
    public Page<School> find(Pageable pageRequest);

}
