package com.anusha.RestClient.Controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.anusha.RestClient.Model.Product;


@RestController
@RequestMapping(value="/products")
public class RestfulClient {
	@Autowired
	RestTemplate restTemplate;
	
	HttpHeaders headers;
	

	@GetMapping //(produces= MediaType.APPLICATION_JSON_VALUE,consumes= MediaType.APPLICATION_JSON_VALUE)
	public String getProductList() {
		 headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		 System.out.println("In Client get method");
		return restTemplate.exchange("http://localhost:8082/products", HttpMethod.GET, entity, String.class).getBody();
	}

	@PostMapping(path="/",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addProducts(@RequestBody Product product){
		
		headers= new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Product> entity = new HttpEntity<>(product,headers);
		System.out.println("In Client post method");
		return restTemplate.exchange("http://localhost:8082/products", HttpMethod.POST, entity, String.class).getBody();
	}
	
	@PutMapping(path="//{id}")
	public String updateProducts(@PathVariable ("id") String id){
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(headers);
		return restTemplate.exchange("http://localhost:8082/products/{id}", HttpMethod.PUT, entity, String.class,id).getBody();
	}
	
	@DeleteMapping(path="//{id}")
	public String deleteProducts(@PathVariable ("id") String id){
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(headers);
		return restTemplate.exchange("http://localhost:8082/products/{id}", HttpMethod.DELETE, entity, String.class,id).getBody();
	}
	/*  
	@PutMapping()
	public String editProduct() {
		headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate.exchange("http://localhost:8082/products" + id, HttpMethod.POST, entity, String.class).getBody();
	}*/
}
