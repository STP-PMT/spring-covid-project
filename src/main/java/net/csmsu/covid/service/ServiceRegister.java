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
	
	public Register getRegisterByRid(int rid) {
		return register_repo.findByRid(rid);
	}
	
	public List<Register> getNotVaccine(){
		return register_repo.getRegisterNullVaccine();
	}
	public List<Register> getNotNullVaccine(){
		return register_repo.getRegisterNotNullVaccine();
	}
	
	public List<Register> getRegisterByRidOrName(String text){
		return register_repo.getRegisterByRidOrName(text,"%"+text+"%");
	}
	
	public boolean deleteByRid(int rid) {
		try {			
			 register_repo.deleteById(rid);
			 return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	
}
