package bg.tuplovdiv.cookingrecipes.domain.dtoS.model;

import bg.tuplovdiv.cookingrecipes.domain.enums.Allergy;

public class IngredientModel {
    private Long id;
    private String name;
    private Double calories;
    private Allergy allergy;

    public IngredientModel() {
    }

    public Long getId() {
        return id;
    }

    public IngredientModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public IngredientModel setName(String name) {
        this.name = name;
        return this;
    }

    public Double getCalories() {
        return calories;
    }

    public IngredientModel setCalories(Double calories) {
        this.calories = calories;
        return this;
    }

    public Allergy getAllergy() {
        return allergy;
    }

    public IngredientModel setAllergy(Allergy allergy) {
        this.allergy = allergy;
        return this;
    }
}
