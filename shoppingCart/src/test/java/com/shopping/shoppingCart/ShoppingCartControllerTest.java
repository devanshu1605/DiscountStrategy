package com.shopping.shoppingCart;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ShoppingCartControllerTest {

    @LocalServerPort
    private int port=8080;

    @Autowired
    private TestRestTemplate restTemplate;
    
    String baseUrl="http://localhost:";

    @Test
    public void getCustomerDetails() throws Exception {

        ResponseEntity<String> response = restTemplate. getForEntity(
			new URL(baseUrl+ port + "/discount/getCustomer/1").toString(), String.class);
        String body = response.getBody();
        assertEquals("{\"customerId\":1,\"customerType\":\"Regular\",\"slab\":\"Regular\",\"customerName\":null}", response.getBody());

    }
    
    @Test
    public void getRegularCustomerPrice() throws Exception {

        ResponseEntity<String> response = restTemplate. getForEntity(
			new URL(baseUrl+ port + "/discount/getCustomerPrice/1/15000").toString(), String.class);
        String body = response.getBody();
        assertEquals("13500", response.getBody());

    }
    
    @Test
    public void getRegularSlabPrice() throws Exception {

        ResponseEntity<String> response = restTemplate. getForEntity(
			new URL(baseUrl + port + "/discount/getSlabPrice/Regular/15000").toString(), String.class);
        String body = response.getBody();
        assertEquals("13500", response.getBody());

    }
    
    @Test
    public void getPremiumCustomerPrice() throws Exception {

        ResponseEntity<String> response = restTemplate. getForEntity(
			new URL(baseUrl+ port + "/discount/getCustomerPrice/3/15000").toString(), String.class);
        String body = response.getBody();
        assertEquals("12300", response.getBody());

    }
    
    @Test
    public void getPremiumSlabPrice() throws Exception {

        ResponseEntity<String> response = restTemplate. getForEntity(
			new URL(baseUrl+ port + "/discount/getSlabPrice/Premium/15000").toString(), String.class);
        String body = response.getBody();
        assertEquals("12300", response.getBody());

    }

}