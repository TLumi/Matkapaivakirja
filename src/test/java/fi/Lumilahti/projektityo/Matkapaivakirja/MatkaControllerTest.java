package fi.Lumilahti.projektityo.Matkapaivakirja;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

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
import static org.assertj.core.api.Assertions.assertThat;

import fi.Lumilahti.projektityo.Matkapaivakirja.web.MatkaController;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class MatkaControllerTest {

	
	@Autowired
	private MockMvc mockMvc;
	
			
	@Test
	public void testMatkaLista() throws Exception {
		this.mockMvc.perform(get("/matkalista")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("aurinkoa")));
		}
		
		
	}
