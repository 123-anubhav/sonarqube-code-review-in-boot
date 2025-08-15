package in.anubhav.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import in.anubhav.dto.Student;
import in.anubhav.service.ServiceData;

@RestController
public class WelcomeRestController {

	// @Autowired
	private ServiceData srvc;

	public WelcomeRestController(ServiceData srvc) {
		super();
		this.srvc = srvc;
	}

	@GetMapping("/data")
	public List<Student> h() {
		return srvc.data();
		 
	}

	@PostMapping("/data")
	public Student writeh(Student s1) {
		return srvc.putData(s1);
		 
	}
}
