package com.springinaction.tacocloud.controller;

import com.springinaction.tacocloud.entity.ETypeIngredient;
import com.springinaction.tacocloud.entity.Ingredient;
import com.springinaction.tacocloud.entity.Taco;
import com.springinaction.tacocloud.entity.TacoOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("TacoOrder")
public class DesignTacoController {

    @ModelAttribute
    public void addIngredientToModel(Model model){
        List<Ingredient> ingredientList = Arrays.asList(
                Ingredient.builder().id("FLTO").name("Flour Tortilla").type(ETypeIngredient.WRAP).build(),
                Ingredient.builder().id("COTO").name("Corn Tortilla").type(ETypeIngredient.WRAP).build(),
                Ingredient.builder().id("GRBF").name("Ground Beef").type(ETypeIngredient.PROTEIN).build(),
                Ingredient.builder().id("CARN").name("Carnitas").type(ETypeIngredient.PROTEIN).build(),
                Ingredient.builder().id("TMTO").name("Diced Tomatoes").type(ETypeIngredient.VEGGIES).build(),
                Ingredient.builder().id("LETC").name("Lettuce").type(ETypeIngredient.VEGGIES).build(),
                Ingredient.builder().id("CHED").name("Cheddar").type(ETypeIngredient.CHEESE).build(),
                Ingredient.builder().id("JACK").name("Monterrey Jack").type(ETypeIngredient.CHEESE).build(),
                Ingredient.builder().id("SLSA").name("Salsa").type(ETypeIngredient.SAUCE).build(),
                Ingredient.builder().id("SRCR").name("Sour Cream").type(ETypeIngredient.SAUCE).build()
        );

        ETypeIngredient[] types = ETypeIngredient.values();
        for (ETypeIngredient type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredientList,type));
        }
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder tacoOrder(){
        return new TacoOrder();
    }
    @ModelAttribute(name = "taco")
    public Taco taco(){
        return new Taco();
    }

    @GetMapping
    public String showDesignForm(){
        return "design";
    }

    private  Iterable<Ingredient> filterByType(List<Ingredient> ingredients, ETypeIngredient type) {
        return ingredients.stream().filter(x-> x.getType().equals(type)).collect(Collectors.toList());
    }
}
