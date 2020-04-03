package com.example.Time.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Time.model.ProjectManager;
import com.example.Time.repository.ProjectManagerRepository;

@RestController
public class ProjectManagerController {
	@Autowired
	private ProjectManagerRepository projectManagerRepository;

	@GetMapping("/pmanager")
	public List<ProjectManager> getPmanager() {
		return projectManagerRepository.findAll();
	}

	@PostMapping("/pmanager")
	public ProjectManager postPmanager(@RequestBody ProjectManager pm) {
		return projectManagerRepository.save(pm);
	}
	@PutMapping("/pmanager/{pid}")
	public ProjectManager updatePmanager(@RequestBody ProjectManager pm,@PathVariable("pid") long pid) {
		ProjectManager p=projectManagerRepository.getOne(pid);
		p.setCompletiondate(pm.getCompletiondate());;
		p.setClientid(pm.getClientid());
		p.setProjecname(pm.getProjecname());
		p.setStartdate(pm.getStartdate());
		p.setTaskspecification(pm.getTaskspecification());
		return projectManagerRepository.save(p);
		
	}
	@DeleteMapping("/pmanager/{pid}")
	 public void deletePmanager(@PathVariable("pid") long pid) {
		projectManagerRepository.deleteById(pid);
	 }

}
