package com.springinaction.tacocloud.entity;

import lombok.Data;

import java.util.List;

@Data
public class Taco {
    private String name;
    List<Ingredient> ingredients;
}
