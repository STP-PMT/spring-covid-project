package net.csmsu.covid.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.csmsu.covid.entity.Vaccine2;

public interface Vaccine2Repository extends JpaRepository<Vaccine2, Integer> {

	List<Vaccine2> findByDate(Date date);

}
