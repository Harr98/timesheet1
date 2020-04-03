package com.example.Time.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Time.model.ClientManager;
import com.example.Time.model.ProjectManager;

public interface ClientManagerRepository extends JpaRepository<ClientManager, Long> {
public List<ClientManager> findByProjectManagerId(long id);
}
