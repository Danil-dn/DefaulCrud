package com.kda;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ProductControllerExceptionTest extends BaseControllerTest {

    @Test
    @DisplayName("addProduct with exception")
    public void addProductException() {
        productService.add(baseAddProduct());

        assertEquals("Element already exist", assertThrows(IllegalArgumentException.class, () -> {
            productService.add(Collections.singletonList("Water"));
        }).getMessage());
    }
}
