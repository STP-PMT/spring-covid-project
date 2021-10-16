package net.csmsu.covid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.csmsu.covid.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
