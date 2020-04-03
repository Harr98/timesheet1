package com.example.Time.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Time.model.ModuleMaster;

public interface ModuleMasterRepository extends JpaRepository<ModuleMaster, Long> {
public List<ModuleMaster> findByUserManagerId(long id);
}
