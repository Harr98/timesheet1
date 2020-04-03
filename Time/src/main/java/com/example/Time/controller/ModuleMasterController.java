package com.example.Time.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Time.model.ModuleMaster;
import com.example.Time.model.UserManager;
import com.example.Time.repository.ModuleMasterRepository;
import com.example.Time.repository.UserManagerRepository;

@RestController
public class ModuleMasterController {
	@Autowired
	private ModuleMasterRepository moduleMasterRepository;
	@Autowired
	private UserManagerRepository userManagerRepository;

	@GetMapping("/mmaster/{uid}")
	public List<ModuleMaster> getMmaster(@PathVariable("uid") long uid) {
		return moduleMasterRepository.findByUserManagerId(uid);
	}

	@PostMapping("/mmaster/{uid}")
	public ModuleMaster postMmaster(@PathVariable("uid") long uid, @RequestBody ModuleMaster mm) {
		UserManager um = userManagerRepository.getOne(uid);
		mm.setUserManager(um);
		return moduleMasterRepository.save(mm);
	}

	@PutMapping("/mmaster/{mid}")
	public ModuleMaster updateMmaster(@PathVariable("mid") long mid, @RequestBody ModuleMaster mm) {
		ModuleMaster m = moduleMasterRepository.getOne(mid);
		m.setModulename(mm.getModulename());
		m.setModulespecification(mm.getModulespecification());
		m.setProjectid(mm.getProjectid());
		return moduleMasterRepository.save(m);
	}

	@DeleteMapping("/mmaster/{mid}")
	public void deleteMmaster(@PathVariable("mid") long mid) {
		moduleMasterRepository.deleteById(mid);
	}
}
