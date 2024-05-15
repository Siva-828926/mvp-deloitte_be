package com.mvp.mvp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvp.mvp.entity.RoleTypes;

@Repository
public interface RoleTypeRepo extends JpaRepository<RoleTypes , Integer> {

    
} 
