package com.drones.dronesapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;

import com.drones.dronesapi.dronesapi.DronesAPI;



@RunWith(SpringRunner.class)
@SpringBootTest(classes=DronesAPI.class,webEnvironment=WebEnvironment.RANDOM_PORT)
class DronesapiApplicationTests {
	
	@LocalServerPort
    private String randomServerPort;
	
	private static String hostUrl = "http://localhost:";
	
	
	
	@Test
	void addDrone() throws URISyntaxException{
		RestTemplate restTemplate = new RestTemplate();
		String baseUrl = hostUrl + randomServerPort; 
	    String url = baseUrl + "/drone/addDrone";
	    URI uri = new URI(url);
	    
	    String drone = "{\r\n"
	    		+ "    \"id\":0,\r\n"
	    		+ "    \"serialNumber\":\"E34FF0C\",\r\n"
	    		+ "    \"model\":{\r\n"
	    		+ "        \"id\":1,\r\n"
	    		+ "        \"droneModel\":\"Lightweight\"\r\n"
	    		+ "    },\r\n"
	    		+ "    \"weightLimit\":500,\r\n"
	    		+ "    \"batteryCapacity\":75,\r\n"
	    		+ "    \"state\":{\r\n"
	    		+ "        \"id\":1,\r\n"
	    		+ "        \"droneState\":\"IDLE\"\r\n"
	    		+ "    }\r\n"
	    		+ "}";
	    try {
	    	MultiValueMap<String,String> headers = new LinkedMultiValueMap<String, String>();
	    	headers.set("Content-Type","application/json");
	    	HttpEntity<String> entity = new HttpEntity<String>(drone, headers);
	    	restTemplate.put(uri, entity);
	    }
	    catch (Exception e) {
	    	//test failed	    	
	    	assertEquals("", e.toString());
		}	    
	}
	
	@Test
	void getDroneById() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		String baseUrl = hostUrl + randomServerPort; 
	    String url = baseUrl + "/drone/getById/1";
	    URI uri = new URI(url);
	    
	    ResponseEntity<String> result = restTemplate.getForEntity(uri,String.class );
	    String drone = "{\"id\":1,\"serialNumber\":\"E34FF0C\",\"model\":{\"id\":1,\"droneModel\":\"Lightweight\"},\"weightLimit\":500,\"batteryCapacity\":75,\"state\":{\"id\":1,\"droneState\":\"IDLE\"}}";	    
	    assertEquals(200, result.getStatusCodeValue());	
	    assertEquals(drone, result.getBody());
	}
	
	@Test
	void getAllDrone() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		String baseUrl = hostUrl + randomServerPort; 
	    String url = baseUrl + "/drone/getAll";
	    URI uri = new URI(url);
	    
	    ResponseEntity<String> result = restTemplate.getForEntity(uri,String.class );
	    	    
	    assertEquals(200, result.getStatusCodeValue());	    
	}

}
