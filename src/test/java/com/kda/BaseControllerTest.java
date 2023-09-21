package com.kda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseControllerTest {

    @Autowired
    ProductService productService;

    public List<String> productList = new ArrayList<>();


    public List<String> baseAddProduct() {
        if (productList.isEmpty()) {
            productList.add("Milk");
            productList.add("Sugar");
            productList.add("Water");
        }
        return  productList;
    }
}
