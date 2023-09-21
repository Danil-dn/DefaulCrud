package com.kda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    /**
     * Эндпоинт на добавление предметов
     * @param product - список предмет которые необходимо добавить
     */

    @PostMapping(value = "/addProduct")
    public List<String> addProduct(
            @RequestBody() ProductModel product
    ) {
        return productService.add(product.getProduct());
    }

    /**
     * Эндпоинт на получение предметов
     *
     */

    @GetMapping(value = "/getProduct")
    public List<String> getProducts() {
        return productService.getList();
    }

    /**
     * Эндпоинт на изменение предметов
     * @param product - мапа, где ключом являеися текущий предмет
     *                (который необходимо изменить), а значением является новый предмет
     *                (который заменит старый)
     */
    @PatchMapping(value = "/updateProduct")
    public List<String> updateProduct(
            @RequestBody() ProductModel product
    ) {
        return productService.updateList(product);
    }

    /**
     * Эндпоинт на удаление предметов
     * @param product - список предметов которые необходимо убрать
     */
    @DeleteMapping(value = "/deleteProduct")
    public List<String> deleteProduct(
            @RequestBody() ProductModel product
    ) {
        return productService.delete(product.getProduct());
    }
}
