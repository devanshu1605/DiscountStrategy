package com.shopping.shoppingCart;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*************************************************************
 * 
 * @author devanshu.chaurasia
 * Test class to test Controller layer
 *
 *************************************************************/

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ShoppingCartControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    
    String baseUrl="http://localhost:";

    @DisplayName("Test customer details fetched based on customer id")
    @Test
    public void getCustomerDetails() throws Exception {

        ResponseEntity<String> response = restTemplate. getForEntity(
			new URL(baseUrl+ port + "/discount/getCustomer/1").toString(), String.class);
        assertEquals("{\"customerId\":1,\"customerType\":\"Regular\",\"slab\":\"Regular\",\"customerName\":null}", response.getBody());

    }
    
    @DisplayName("Test Price Calculation based on customer id and billing amount for regular customer")
    @Test
    public void getRegularCustomerPrice() throws Exception {
        ResponseEntity<String> response = restTemplate. getForEntity(
			new URL(baseUrl+ port + "/discount/getCustomerPrice/1/15000").toString(), String.class);
        assertEquals("13500", response.getBody());
    }
    
    @DisplayName("Test Price Calculation based on regular slab type and billing amount")
    @Test
    public void getRegularSlabPrice() throws Exception {
        ResponseEntity<String> response = restTemplate. getForEntity(
			new URL(baseUrl + port + "/discount/getSlabPrice/Regular/15000").toString(), String.class);
        assertEquals("13500", response.getBody());
    }
    
    @DisplayName("Test Price Calculation based on customer id and billing amount for Premium custmer")
    @Test
    public void getPremiumCustomerPrice() throws Exception {
        ResponseEntity<String> response = restTemplate. getForEntity(
			new URL(baseUrl+ port + "/discount/getCustomerPrice/3/15000").toString(), String.class);
        assertEquals("12300", response.getBody());
    }
    
    @DisplayName("Test Price Calculation based on Premium slab type and billing amount")
    @Test
    public void getPremiumSlabPrice() throws Exception {
        ResponseEntity<String> response = restTemplate. getForEntity(
			new URL(baseUrl+ port + "/discount/getSlabPrice/Premium/15000").toString(), String.class);
        assertEquals("12300", response.getBody());
    }

}