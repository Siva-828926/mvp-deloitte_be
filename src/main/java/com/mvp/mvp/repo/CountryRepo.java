package com.mvp.mvp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvp.mvp.entity.Countries;

@Repository
public interface CountryRepo extends JpaRepository<Countries , Integer>{
    
}
