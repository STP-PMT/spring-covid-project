package net.csmsu.covid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.csmsu.covid.entity.Register;
import net.csmsu.covid.repository.RegisterRepository;

@Service
public class ServiceRegister {
	@Autowired
	RegisterRepository register_repo;
	
	public List<Register> getAllRegister(){
		return register_repo.findAll();
	}
	
	public Register updateRegister(Register register) {
		return register_repo.save(register);
	}
	
}
