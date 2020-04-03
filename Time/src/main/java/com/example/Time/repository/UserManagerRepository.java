package com.example.Time.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Time.model.UserManager;

public interface UserManagerRepository extends JpaRepository<UserManager, Long>{
public List<UserManager> findByClientManagerId(long id);
}
