package com.mvp.mvp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvp.mvp.entity.RoleDetails;

@Repository
public interface RoleDetailRepo extends JpaRepository<RoleDetails , String> {
    
}
