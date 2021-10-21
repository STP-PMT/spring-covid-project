package net.csmsu.covid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.csmsu.covid.entity.Register;
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
	@Autowired VaccineRepository vaccine_repo;
	@Autowired Vaccine1Repository vaccine1_repo;
	@Autowired Vaccine2Repository vaccine2_repo;
	@Autowired Vaccine3Repository vaccine3_repo;
	
	public List<Vaccine> getAllVaccine(){
		return vaccine_repo.findAll();
	}
	/* vaccine1 */
	public Vaccine1 getVaccine1ByRid(int rid) {
		return vaccine1_repo.getVaccineByRid(rid);
	}
	public Vaccine1 updateVaccine1(Vaccine1 vaccine) {
		return vaccine1_repo.save(vaccine);
	}
	
	/* vaccine2 */
	public Vaccine2 updateVaccine2(Vaccine2 vaccine) {
		return vaccine2_repo.save(vaccine);
	}
	
	/* vaccine3 */
	public Vaccine3 updateVaccine3(Vaccine3 vaccine) {
		return vaccine3_repo.save(vaccine);
	}
}
