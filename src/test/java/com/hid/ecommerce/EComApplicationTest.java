package com.hid.ecommerce;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hid.ecommerce.model.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EComApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllProductsTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/ecom/products")).andDo(print()).andReturn();
        Assert.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        Assert.assertNotNull(mvcResult.getResponse());
    }

    @Test
    public void addProductTest() throws Exception {
        Product product = new Product();
        product.setName("Mobile");
        product.setPrice(19000.00);
        product.setUserId("Ben");
        String jsonString = new ObjectMapper().writeValueAsString(product);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/ecom/product/add")
        .contentType(MediaType.APPLICATION_JSON).content(jsonString)).andDo(print()).andReturn();
        Assert.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        Assert.assertNotNull(mvcResult.getResponse());
    }

    @Test
    public void removeProductTest() throws Exception {
        Product product = new Product();
        product.setName("Mobile");
        product.setPrice(19000.00);
        product.setUserId("Ben");
        String jsonString = new ObjectMapper().writeValueAsString(product);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/ecom/product/add")
                .contentType(MediaType.APPLICATION_JSON).content(jsonString)).andDo(print()).andReturn();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/api/ecom/product/remove/1")).andDo(print()).andReturn();
        Assert.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        Assert.assertNotNull(mvcResult.getResponse());
    }
}
