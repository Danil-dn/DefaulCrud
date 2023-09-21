package com.kda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class ProductControllerTest extends BaseControllerTest {


    @BeforeEach
    void setupThis(){
        if(productService.getList().isEmpty()) {
            productService.add(baseAddProduct());
        }
    }

    @Test
    @DisplayName("POST /addProduct")
    public void addProduct() {
        productService.add(List.of("Tomato"));
        System.out.println(productService.getList());
        assertEquals(4, productService.getList().size());
    }

    @Test
    @DisplayName("DELETE /deleteProduct")
    public void deleteProduct() {
        System.out.println(productService.getList().get(0));
        productService.delete(productService.getList());
    }

    @Test
    @DisplayName("GET /getProduct")
    public void getProduct() {
        assertFalse(productService.getList().isEmpty());
        assertEquals(3, productService.getList().size());
    }

    @Test
    @DisplayName("PATCH /updateProduct")
    public void updateProduct() {
        var productModel = new ProductModel();
        productModel.setChangeProduct(Map.of("Milk","Ice"));
        final List<String> items = productService.updateList(productModel);
        assertTrue(items.contains("Ice"));
        assertEquals(3, items.size());
    }
}
