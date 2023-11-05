package bg.tuplovdiv.cookingrecipes.domain.dtoS.banding;

import bg.tuplovdiv.cookingrecipes.domain.dtoS.model.IngredientModel;
import bg.tuplovdiv.cookingrecipes.domain.dtoS.model.MeasureUnitModel;
import jakarta.validation.constraints.NotNull;

public class RecipeIngredientAddForm {

    @NotNull
    private String ingredient; //String?

    @NotNull
    private MeasureUnitModel measureUnit; //String?

    @NotNull
    private Double amount;

    public RecipeIngredientAddForm() {
    }

    public Double getAmount() {
        return amount;
    }

    public RecipeIngredientAddForm setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public String getIngredient() {
        return ingredient;
    }

    public RecipeIngredientAddForm setIngredient(String ingredient) {
        this.ingredient = ingredient;
        return this;
    }

    public MeasureUnitModel getMeasureUnit() {
        return measureUnit;
    }

    public RecipeIngredientAddForm setMeasureUnit(MeasureUnitModel measureUnit) {
        this.measureUnit = measureUnit;
        return this;
    }
}
