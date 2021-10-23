package net.csmsu.covid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.csmsu.covid.entity.Register;
import net.csmsu.covid.entity.Student;


public interface RegisterRepository extends JpaRepository<Register, Integer> {
	public Register findByRid(int rid);
	//@Query("SELECT s FROM  Student s LEFT JOIN Register r on s.sid = r.tbStudent.sid WHERE r.tbStudent.sid IS NULL")
	@Query("select r from  Register r LEFT JOIN Vaccine1 v on r.rid = v.tbRegister where v.tbRegister.rid IS NULL")
	List<Register> getRegisterNullVaccine();
	
	@Query("select r from  Register r LEFT JOIN Vaccine1 v on r.rid = v.tbRegister where v.tbRegister.rid IS NOT NULL")
	List<Register> getRegisterNotNullVaccine();
	
	@Query("select tr from Register tr WHERE tr.tbStudent.sid =:id OR tr.tbStudent.firstname LIKE :text")
	List<Register> getRegisterByRidOrName(String id,String text);
}
