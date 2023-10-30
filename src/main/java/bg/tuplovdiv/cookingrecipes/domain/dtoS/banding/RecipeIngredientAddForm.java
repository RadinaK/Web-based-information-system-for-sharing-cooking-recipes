package bg.tuplovdiv.cookingrecipes.domain.dtoS.banding;

import jakarta.validation.constraints.NotNull;

public class RecipeIngredientAddForm {

    @NotNull
    private String ingredient; //String?

    @NotNull
    private String measureUnit;

    @NotNull
    private Double amount;

    public RecipeIngredientAddForm() {
    }

    public String getIngredient() {
        return ingredient;
    }

    public RecipeIngredientAddForm setIngredient(String ingredient) {
        this.ingredient = ingredient;
        return this;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public RecipeIngredientAddForm setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public RecipeIngredientAddForm setAmount(Double amount) {
        this.amount = amount;
        return this;
    }
}
