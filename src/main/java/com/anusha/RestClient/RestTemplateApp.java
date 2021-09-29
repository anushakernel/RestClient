package com.anusha.RestClient;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.anusha.RestClient.Model.Product;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class RestTemplateApp {

	static RestTemplateApp app = new RestTemplateApp();
	private static Logger logger = LogManager.getLogger(RestTemplateApp.class);

	public static void main(String[] args) {
		SpringApplication.run(RestTemplateApp.class, args);
		app.methodCalls();
	}

	public void getCallMethod() {
		List<Product> list = app.getRestTemplate().getForObject("http://localhost:8082/products", List.class);
		logger.info("Rest Template get call size =  " + list.size() + "\n");
		logger.info("products = " + list + "\n");
	}

	public void methodCalls() {
		app.getCallMethod();
		
		Product product = new Product("5", "CastorBoard", "50$", "Skating");
		logger.info("Before Rest Template post call");
		String postRsp = app.getRestTemplate().postForObject("http://localhost:8082/products", product, String.class);
		logger.info(postRsp + "\n");
		app.getCallMethod();
		logger.info("After Rest Template post call" + "\n");
		
		logger.info("Before put call" + "\n");
		app.getRestTemplate().put("http://localhost:8082/products/5", "5");
		logger.info("Product updated name is: " + product.getName());
		app.getCallMethod();
		
		logger.info("\n" + "Before delete method");
		app.getRestTemplate().delete("http://localhost:8082/products/5", "5");
		logger.info("Product deleted " + "\n");
		app.getCallMethod();

	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}

/*
 * JSONObject json =
 * app.getRestTemplate().getForObject("http://localhost:8082/products",
 * JSONObject.class); List<String> list = new ArrayList<>(); try { JSONArray
 * jsonarray = json.getJSONArray(""); for(int i=0;i<jsonarray.length();i++){
 * list.add(jsonarray.getJSONObject(i).getString("")); } } catch (JSONException
 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
 */
