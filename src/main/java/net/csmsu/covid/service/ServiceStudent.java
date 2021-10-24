package net.csmsu.covid.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.csmsu.covid.entity.Student;
import net.csmsu.covid.repository.StudentRepository;

@Service
public class ServiceStudent {
	@Autowired
	StudentRepository student_repo;
	
	public List<Student> getAllStudent(){
		return student_repo.findAll();
	}
	
	public Optional<Student> getStudentById(String id){
		return student_repo.findBySid(id);
	}
	public List<Student> getStudentNotInRegister(){
		return student_repo.getStudentNotRegister();
	}
	
	public List<Student> getStudentNotInRegister(String text){
		return student_repo.getStudentNotRegister(text,"%"+text+"%");
	}
	
	public List<Student> getStudentBySidOrName(String text){
		return student_repo.findBySidOrFirstnameStartingWith(text, text);
	}
	public Student updateUpdate(Student s) {
		return student_repo.save(s);
	}
	public boolean deleteBySid(String sid) {
		try {			
			 student_repo.deleteById(sid);
			 return true;
		}catch (Exception e) {
			return false;
		}
	}
}
