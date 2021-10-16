package net.csmsu.covid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.csmsu.covid.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	public List<Student> findBySid(int id);
}
