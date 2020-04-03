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
import com.example.Time.model.UserManager;
import com.example.Time.repository.ClientManagerRepository;
import com.example.Time.repository.UserManagerRepository;

@RestController
public class UserManagerController {
	@Autowired
	private UserManagerRepository userManagerRepository;
	@Autowired
	private ClientManagerRepository clientManagerRepository;
	
	@GetMapping("/umanager/{cid}")
	public List<UserManager> getUmanger(@PathVariable("cid") long cid) {
		return userManagerRepository.findByClientManagerId(cid);
	}
	@PostMapping("/umanager/{cid}")
	public UserManager postUmanager(@PathVariable("cid") long cid,@RequestBody UserManager um) {
		ClientManager cm=clientManagerRepository.getOne(cid);
		um.setClientManager(cm);
		return userManagerRepository.save(um);
	}
	@PutMapping("/umanager/uid")
	public UserManager updateUmanager(@PathVariable("uid") long uid,@RequestBody UserManager um) {
		UserManager u=userManagerRepository.getOne(uid);
		u.setUserid(um.getUserid());
		u.setFirstname(um.getFirstname());
		u.setMiddlename(um.getMiddlename());
		u.setLastname(um.getLastname());
		u.setGender(um.getGender());
		u.setDob(um.getDob());
		u.setMobileno(um.getMobileno());
		u.setPassword(um.getPassword());
		u.setLastpassword(um.getLastpassword());
		u.setStartdate(um.getStartdate());
		u.setEnddate(um.getEnddate());
		return userManagerRepository.save(u);
		
	}
	@DeleteMapping("/umanager/uid")
	public void deleteUmanager(@PathVariable("uid") long uid) {
		userManagerRepository.deleteById(uid);
	}
}
