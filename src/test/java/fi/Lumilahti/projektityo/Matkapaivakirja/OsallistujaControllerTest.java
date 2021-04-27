package fi.Lumilahti.projektityo.Matkapaivakirja;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import fi.Lumilahti.projektityo.Matkapaivakirja.web.OsallistujaController;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class OsallistujaControllerTest {

	
	@Autowired
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new OsallistujaController()).build();
	}
		
	@Test
	public void testOsallistujaPage() throws Exception {
		this.mockMvc.perform(get("/osallistuja"))
		.andExpect(status().isOk())
		.andExpect(view().name("osallistujalista"))
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
	}
}
	
	