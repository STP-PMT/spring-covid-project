package net.csmsu.covid.service;

import java.util.List;

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
	
	public List<Student> getStudentById(String id){
		return student_repo.findBySid(id);
	}
	public List<Student> getStudentNotInRegister(){
		return student_repo.getStudentNotRegister();
	}
}
