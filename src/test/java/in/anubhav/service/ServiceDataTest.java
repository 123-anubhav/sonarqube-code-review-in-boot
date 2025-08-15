package in.anubhav.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import in.anubhav.dto.Student;
import in.anubhav.repo.StudentRepo;

@ExtendWith(MockitoExtension.class) // Enables Mockito in JUnit 5
 class ServiceDataTest {

	@Mock // Creates a mock object
	private StudentRepo studentRepository;

	@InjectMocks // Creates the class under test and injects mocks into it
	private ServiceData serviceData;

	@Test
	void testPutDataWithMock() {
		Student stu = new Student();
		stu.setEmailId("anubhav.aa2@gmail.com");
		stu.setName("anubhav srivastava");

		when(studentRepository.save(stu)).thenReturn(stu);

		Student result = serviceData.putData(stu);
		assertEquals("anubhav srivastava", result.getName());

	}

	@Test
	void data() {
		List<Student> list = new ArrayList<>();

		Student stu = new Student();
		stu.setEmailId("anubhav.aa2@gmail.com");
		stu.setName("anubhav srivastava");

		Student stu1 = new Student();
		stu1.setEmailId("jitendra@gmail.com");
		stu1.setName("jitendra kumar");
		
		
		Student stu2 = new Student();
		stu2.setEmailId("ajay@gmail.com");
		stu2.setName("ajay rai");
		
		list.add(stu);
		list.add(stu1);
		list.add(stu2);

		// Mocking the repository call
		when(studentRepository.findAll()).thenReturn(list);

		// Calling the actual method from ServiceData
		List<Student> result = serviceData.data();

		// Assertions to verify the result
		assertEquals(3, result.size());
		assertEquals("anubhav srivastava", result.get(0).getName());
		assertEquals("jitendra kumar", result.get(1).getName());
		assertEquals("ajay rai", result.get(2).getName());
	}

}
