package com.mvp.mvp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvp.mvp.entity.UserDetails;

@Repository
public interface AuthRepo extends JpaRepository<UserDetails, Integer> {

    public Optional<UserDetails> findByEmailId(String emailId);
}
