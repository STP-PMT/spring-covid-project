package net.csmsu.covid.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.csmsu.covid.entity.Vaccine3;

public interface Vaccine3Repository extends JpaRepository<Vaccine3,Integer> {

	List<Vaccine3> findByDate(Date date);

}
