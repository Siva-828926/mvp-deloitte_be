package com.mvp.mvp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvp.mvp.entity.RoleTiers;

@Repository
public interface RoleTierRepo extends JpaRepository<RoleTiers , Integer> {

    
} 
