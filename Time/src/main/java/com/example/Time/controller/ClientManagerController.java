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

import com.example.Time.model.ClientManager;
import com.example.Time.model.ProjectManager;
import com.example.Time.repository.ClientManagerRepository;
import com.example.Time.repository.ProjectManagerRepository;

@RestController
public class ClientManagerController {
@Autowired
	private ClientManagerRepository clientManagerRepository;
@Autowired
private ProjectManagerRepository projectManagerRepository;

	@GetMapping("/cmanager/{pid}")
	public List<ClientManager> getCmanager(@PathVariable("pid") long pid) {
		return clientManagerRepository.findByProjectManagerId(pid);
	}
	@PostMapping("/cmanager/{pid}")
	public ClientManager postCmanager(@RequestBody ClientManager cm,@PathVariable("pid") long pid) {
		ProjectManager pn=projectManagerRepository.getOne(pid);
		cm.setProjectManager(pn);
		return clientManagerRepository.save(cm);
	}
	@PutMapping("/cmanager/{cid}")
	public ClientManager updateCmanager(@RequestBody ClientManager cm,@PathVariable("cid") long cid) {
	try{ClientManager c=	clientManagerRepository.getOne(cid);
	c.setAddress(cm.getAddress());
	c.setClientname(cm.getClientname());
	c.setContactnumber(cm.getContactnumber());
	c.setContactperson(cm.getContactperson());
	return clientManagerRepository.save(c);
	}
	catch (Exception e) {
		return null;
	}
	
	}
	@DeleteMapping("/cmanager/{cid}")
	public void deleteCmanager(@PathVariable("cid") long cid) {
		clientManagerRepository.deleteById(cid);
	}
}
