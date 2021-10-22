package net.csmsu.covid.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.csmsu.covid.entity.Vaccine2;
import net.csmsu.covid.entity.Vaccine3;

public interface Vaccine3Repository extends JpaRepository<Vaccine3,Integer> {
	@Query("select v from Vaccine3 v where v.tbRegister.rid = :rid")
	Vaccine3 getVaccineByRid(int rid);
	List<Vaccine3> findByDate(Date date);
}
