package com.kda;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ProductModel {
    private Map<String,String> changeProduct = new HashMap<>();
    private List<String> product = new ArrayList<>();
}
