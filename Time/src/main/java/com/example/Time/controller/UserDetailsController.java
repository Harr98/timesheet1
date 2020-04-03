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

import com.example.Time.model.UserDetails;
import com.example.Time.repository.ModuleMasterRepository;
import com.example.Time.repository.UserDetailsRepository;

@RestController
public class UserDetailsController {
	@Autowired
	private UserDetailsRepository userDetailsRepository;
	@Autowired
	private ModuleMasterRepository moduleMasterRepository;

	@GetMapping("/udetails/{mid}")
	public List<UserDetails> getUdetails(@PathVariable("mid") long mid) {
		return userDetailsRepository.findByModuleMasterId(mid);
	}

	@PostMapping("/udetails")
	public UserDetails postUdetails(@RequestBody UserDetails ud) {
		return userDetailsRepository.save(ud);
	}
	@PutMapping("/udetails/{uid}")
	public UserDetails updateUdetails(@RequestBody UserDetails ud,@PathVariable("uid") long uid) {
	UserDetails u=	userDetailsRepository.getOne(uid);
	u.setNickname(ud.getNickname());
	u.setAddress(ud.getAddress());
	u.setCity(ud.getCity());
	u.setCountry(ud.getCountry());
	u.setPincode(ud.getPincode());
	u.setQualification(ud.getQualification());
	u.setDesignation(ud.getDesignation());
	return userDetailsRepository.save(u);
	
	}
	@DeleteMapping("/udetails/{uid}")
	public void deleteUdetails(@PathVariable("uid") long uid) {
		userDetailsRepository.deleteById(uid);
	}
}
