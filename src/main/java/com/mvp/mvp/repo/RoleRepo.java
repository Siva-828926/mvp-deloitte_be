package com.mvp.mvp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvp.mvp.entity.Roles;

@Repository
public interface RoleRepo extends JpaRepository<Roles , Integer>{
    
}