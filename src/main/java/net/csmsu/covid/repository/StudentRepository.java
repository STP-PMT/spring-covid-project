package net.csmsu.covid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.csmsu.covid.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	public List<Student> findBySid(int id);
	
	@Query("SELECT s FROM  Student s LEFT JOIN Register r on s.sid = r.tbStudent.sid WHERE r.tbStudent.sid IS NULL")
	List<Student> getStudentNotRegister();
}
