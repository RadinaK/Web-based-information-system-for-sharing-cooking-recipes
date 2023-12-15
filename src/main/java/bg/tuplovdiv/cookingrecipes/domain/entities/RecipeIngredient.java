package bg.tuplovdiv.cookingrecipes.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "recipes_ingredients")
public class RecipeIngredient extends BaseEntity {

    @ManyToOne
    private Recipe recipe;

    @ManyToOne
    private Ingredient ingredient;

    @ManyToOne
    private MeasureUnit measureUnit;

    @Column
    private Double amount;

    public RecipeIngredient() {
    }

    public RecipeIngredient(Recipe recipe, Ingredient ingredient, MeasureUnit measureUnit, Double amount) {
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.measureUnit = measureUnit;
        this.amount = amount;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public RecipeIngredient setRecipe(Recipe recipe) {
        this.recipe = recipe;
        return this;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public RecipeIngredient setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
        return this;
    }

    public MeasureUnit getMeasureUnit() {
        return measureUnit;
    }

    public RecipeIngredient setMeasureUnit(MeasureUnit measureUnit) {
        this.measureUnit = measureUnit;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public RecipeIngredient setAmount(Double amount) {
        this.amount = amount;
        return this;
    }
}
