package in.anubhav.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import in.anubhav.dto.Student;
import in.anubhav.service.ServiceData;

@WebMvcTest(value = WelcomeRestController.class)
 class WelcomeRestControllerTest {
	
	//@MockBean -> deprecated
	@MockitoBean
	private ServiceData srvc;
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	 void dataTest() throws Exception {
		List<Student> list= new ArrayList<>();
		
		Student s = new Student();
		s.setEmailId("abc@gmail.com");
		s.setName("abc");
		
		Student s1 = new Student();
		s1.setEmailId("lal@gmail.com");
		s1.setName("lal");
		
		list.add(s);
		list.add(s1);
		
		when(srvc.data()).thenReturn(list);
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/data");
		
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		
		MockHttpServletResponse response = mvcResult.getResponse();
		
		int status = response.getStatus();
		
		assertEquals(200, status);
	}
	
	
	@Test
	 void dataPurTest() throws Exception {
		Student s = new Student();
		s.setEmailId("abc@gmail.com");
		s.setName("abc");
		
		Student s1 = new Student();
		s1.setEmailId("lal@gmail.com");
		s1.setName("lal");
		
		when(srvc.putData(s)).thenReturn(s1);
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/data");
		
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		
		MockHttpServletResponse response = mvcResult.getResponse();
		
		int status = response.getStatus();
		
		assertEquals(200, status);
	}

}
