package net.csmsu.covid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.csmsu.covid.entity.Vaccine;
import net.csmsu.covid.repository.VaccineRepository;
@Service
public class ServiceVaccine {
	@Autowired VaccineRepository vaccine_repo;
	
	public List<Vaccine> getAllVaccine(){
		return vaccine_repo.findAll();
	}
}
