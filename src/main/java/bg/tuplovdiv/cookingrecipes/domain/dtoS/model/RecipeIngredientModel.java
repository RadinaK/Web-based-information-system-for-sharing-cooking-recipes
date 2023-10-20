package bg.tuplovdiv.cookingrecipes.domain.dtoS.model;

import bg.tuplovdiv.cookingrecipes.domain.entities.MeasureUnit;

public class RecipeIngredientModel {

    private Long id;
    private RecipeModel recipe;

    private IngredientModel ingredient;

    private MeasureUnitModel measureUnit;

    private Double amount;

    public RecipeIngredientModel() {
    }

    public Long getId() {
        return id;
    }

    public RecipeIngredientModel setId(Long id) {
        this.id = id;
        return this;
    }

    public RecipeModel getRecipe() {
        return recipe;
    }

    public RecipeIngredientModel setRecipe(RecipeModel recipe) {
        this.recipe = recipe;
        return this;
    }

    public IngredientModel getIngredient() {
        return ingredient;
    }

    public RecipeIngredientModel setIngredient(IngredientModel ingredient) {
        this.ingredient = ingredient;
        return this;
    }

    public MeasureUnitModel getMeasureUnit() {
        return measureUnit;
    }

    public RecipeIngredientModel setMeasureUnit(MeasureUnitModel measureUnit) {
        this.measureUnit = measureUnit;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public RecipeIngredientModel setAmount(Double amount) {
        this.amount = amount;
        return this;
    }
}
