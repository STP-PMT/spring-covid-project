package net.csmsu.covid.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.csmsu.covid.entity.Vaccine2;

public interface Vaccine2Repository extends JpaRepository<Vaccine2, Integer> {
	@Query("select v from Vaccine2 v where v.tbRegister.rid = :rid")
	Vaccine2 getVaccineByRid(int rid);
	
	List<Vaccine2> findByDate(Date date);
	@Query("select v from Vaccine2 v WHERE v.tbRegister.tbStudent.sid =:id OR v.tbRegister.tbStudent.firstname LIKE :text")
	List<Vaccine2> getVaccineByRidOrName(String id, String text);
}
