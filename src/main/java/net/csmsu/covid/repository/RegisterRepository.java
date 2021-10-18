package net.csmsu.covid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.csmsu.covid.entity.Register;
import net.csmsu.covid.entity.Student;

public interface RegisterRepository extends JpaRepository<Register, Integer> {
	
}
