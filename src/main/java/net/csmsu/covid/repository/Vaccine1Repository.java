package net.csmsu.covid.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.csmsu.covid.entity.Vaccine1;

public interface Vaccine1Repository extends JpaRepository<Vaccine1,Integer> {
	@Query("select v from Vaccine1 v where v.tbRegister.rid = :rid")
	Vaccine1 getVaccineByRid(int rid);
	
	public List<Vaccine1> findByDate(Date date);
	
	@Query("select v from Vaccine1 v WHERE v.tbRegister.tbStudent.sid =:id OR v.tbRegister.tbStudent.firstname LIKE :text")
	List<Vaccine1> getVaccineByRidOrName(String id, String text);
}
