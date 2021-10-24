package net.csmsu.covid.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.csmsu.covid.entity.Vaccine;
import net.csmsu.covid.entity.Vaccine1;
import net.csmsu.covid.entity.Vaccine2;
import net.csmsu.covid.entity.Vaccine3;
import net.csmsu.covid.repository.Vaccine1Repository;
import net.csmsu.covid.repository.Vaccine2Repository;
import net.csmsu.covid.repository.Vaccine3Repository;
import net.csmsu.covid.repository.VaccineRepository;

@Service
public class ServiceVaccine {
	@Autowired
	VaccineRepository vaccine_repo;
	@Autowired
	Vaccine1Repository vaccine1_repo;
	@Autowired
	Vaccine2Repository vaccine2_repo;
	@Autowired
	Vaccine3Repository vaccine3_repo;

	public List<Vaccine> getAllVaccine() {
		return vaccine_repo.findAll();
	}

	public Vaccine getVaccineById(int id) {
		return vaccine_repo.getById(id);
	}
	
	public List<Vaccine> getEfficacy(int efficacy){
		return vaccine_repo.findByEfficacyGreaterThanEqual(efficacy);
	}

	/* vaccine1 */
	public List<Vaccine1> getVaccine1ByRidOrName(String text){
		return vaccine1_repo.getVaccineByRidOrName(text,"%"+text+"%");
	}
	
	public List<Vaccine1> getAllVaccine1() {
		return vaccine1_repo.findAll();
	}
	
	public List<Vaccine1> getVaccine1ByDate(Date date){
		return vaccine1_repo.findByDate(date);
	}

	public Vaccine1 getVaccine1ByRid(int rid) {
		return vaccine1_repo.getVaccineByRid(rid);
	}

	public Vaccine1 updateVaccine1(Vaccine1 vaccine) {
		return vaccine1_repo.save(vaccine);
	}
	
	public boolean deleteVaccin1ByVid(int vid1) {
		try {			
			 vaccine1_repo.deleteById(vid1);
			 return true;
		}catch (Exception e) {
			return false;
		}
	}

	/* vaccine2 */
	public List<Vaccine2> getVaccine2ByRidOrName(String text){
		return vaccine2_repo.getVaccineByRidOrName(text,"%"+text+"%");
	}
	
	public List<Vaccine2> getAllVaccine2() {
		return vaccine2_repo.findAll();
	}
	public List<Vaccine2> getVaccine2ByDate(Date date){
		return vaccine2_repo.findByDate(date);
	}
	public Vaccine2 getVaccine2ByRid(int rid) {
		return vaccine2_repo.getVaccineByRid(rid);
	}

	public Vaccine2 updateVaccine2(Vaccine2 vaccine) {
		return vaccine2_repo.save(vaccine);
	}
	
	public boolean deleteVaccin2ByVid(int vid2) {
		try {			
			 vaccine2_repo.deleteById(vid2);
			 return true;
		}catch (Exception e) {
			return false;
		}
	}

	/* vaccine3 */
	public List<Vaccine3> getVaccine3ByRidOrName(String text){
		return vaccine3_repo.getVaccineByRidOrName(text,"%"+text+"%");
	}
	public List<Vaccine3> getAllVaccine3() {
		return vaccine3_repo.findAll();
	}
	public List<Vaccine3> getVaccine3ByDate(Date date){
		return vaccine3_repo.findByDate(date);
	}
	public Vaccine3 getVaccine3ByRid(int rid) {
		return vaccine3_repo.getVaccineByRid(rid);
	}

	public Vaccine3 updateVaccine3(Vaccine3 vaccine) {
		return vaccine3_repo.save(vaccine);
	}
	
	public boolean deleteVaccin3ByVid(int vid3) {
		try {			
			 vaccine3_repo.deleteById(vid3);
			 return true;
		}catch (Exception e) {
			return false;
		}
	}
}
