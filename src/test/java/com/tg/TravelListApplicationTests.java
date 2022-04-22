package com.tg;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test; 
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class TravelListApplicationTests {

	@Autowired
    private MockMvc mockMvc;	

	//Add A New Travel
	@Test
    public void TestCase1() throws Exception {
		
		String dataOne = "{\"id\":\"12881\",\"name\":\"Travel Place 1\",\"description\":\"Travel Description 1\"}";
	 	mockMvc.perform(MockMvcRequestBuilders.post("/addTravel")
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.content(dataOne)
	 			.accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk())
	        	.andExpect(jsonPath("$").value("Travel Added Successfully !"))
	        	.andReturn();
	 	
    }
	
	//Get All Travel
	@Test
    public void TestCase2() throws Exception {
		
	 	mockMvc.perform(MockMvcRequestBuilders.get("/travel")
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk())
		        .andExpect(MockMvcResultMatchers.jsonPath("$[*].name").exists())
		        .andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty())
	        	.andReturn();
	 	
    }
	
	//Get Single Travel
	@Test
	public void TestCase3() throws Exception {
			
	 	mockMvc.perform(MockMvcRequestBuilders.get("/travel/tp001")
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk())
	        	.andExpect(jsonPath("$.name").value("Nandhi Hills"))
		        .andExpect(jsonPath("$.description").value("A Majestic View above the Clouds"))
	        	.andReturn();
		 	
	}
	
	//Update the Travel
	@Test
	public void TestCase4() throws Exception {
			
		String dataOne = "{\"id\":\"tp001\",\"name\":\"Nandhi Hills\",\"description\":\"A Majestic View above the Clouds and Refreshing\"}";
	 	mockMvc.perform(MockMvcRequestBuilders.put("/travel/tp001")
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.content(dataOne)
	 			.accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk())
	        	.andExpect(jsonPath("$").value("Travel Updated Successfully ! tp001"))
	        	.andReturn();
		 	
	}
	
	//Delete the Travel
	@Test
	public void TestCase5() throws Exception {
				
	 	mockMvc.perform(MockMvcRequestBuilders.delete("/travel/tp001")
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk())
	        	.andExpect(jsonPath("$").value("Travel Deleted Successfully ! tp001"))
	        	.andReturn();
			 	
	}

}
