package com.kda;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
@Slf4j
public class ProductService {

    List<String> productList = new ArrayList<>();

    public List<String> add(List<String> list) throws InvalidArgumentException {
        System.out.println(list);
        System.out.println(productList.stream().noneMatch(list::contains));
        if(productList.stream().noneMatch(list::contains)) {
            productList.addAll(list);
        } else {
            throw new InvalidArgumentException("Element already exist");
        }

        return productList;
    }

    public List<String> getList() {
        return productList.stream().sorted().toList();
    }

    public List<String> delete(List<String> list) {
        if (new HashSet<>(list).containsAll(productList)){
            list.forEach(item -> productList.remove(item));
        } else {
            throw new InvalidArgumentException("Element not exist");
        }
        return productList;
    }

    public List<String> updateList(ProductModel product) {

        List<String> deleteList = new ArrayList<>();
        product.getChangeProduct().keySet().forEach(key-> {
            if(productList.contains(key)){
                log.info(product.getChangeProduct().get(key));
                add(Collections.singletonList(product.getChangeProduct().get(key)));
                deleteList.add(key);
            }});

        productList.removeAll(deleteList);
        return productList;
    }
}
