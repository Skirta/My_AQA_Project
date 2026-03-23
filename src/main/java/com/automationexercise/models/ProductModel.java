package com.automationexercise.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductModel {
    private String id;
    private String name;
    private String price;
}