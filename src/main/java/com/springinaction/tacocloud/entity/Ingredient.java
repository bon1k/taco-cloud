package com.springinaction.tacocloud.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Ingredient {
    private String id;
    private String name;
    private ETypeIngredient type;
}


