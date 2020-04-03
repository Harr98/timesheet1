package com.example.Time.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Time.model.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long>{
public List<UserDetails> findByModuleMasterId(long id);
}
