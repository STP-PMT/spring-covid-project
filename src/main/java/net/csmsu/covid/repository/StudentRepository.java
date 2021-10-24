package net.csmsu.covid.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.csmsu.covid.entity.Student;

public interface StudentRepository extends JpaRepository<Student, String>{
	Optional<Student> findBySid(String id);
	
	@Query("SELECT s FROM  Student s LEFT JOIN Register r on s.sid = r.tbStudent.sid WHERE r.tbStudent.sid IS NULL")
	List<Student> getStudentNotRegister();
	
	List<Student> findBySidOrFirstnameStartingWith(String sid,String fistname);
}
