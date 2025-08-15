package in.anubhav.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.anubhav.dto.Student;
import in.anubhav.repo.StudentRepo;

@Service
public class ServiceData {

	private StudentRepo stuRepo;

	public ServiceData(StudentRepo stuRepo) {
		super();
		this.stuRepo = stuRepo;
	}

	public List<Student> data() {
		return stuRepo.findAll();
		 
	}

	public Student putData(Student obj) {

		return stuRepo.save(obj);
		
	}
}
