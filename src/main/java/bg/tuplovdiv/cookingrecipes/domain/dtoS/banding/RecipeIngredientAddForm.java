package bg.tuplovdiv.cookingrecipes.domain.dtoS.banding;

import bg.tuplovdiv.cookingrecipes.domain.dtoS.model.IngredientModel;
import bg.tuplovdiv.cookingrecipes.domain.dtoS.model.MeasureUnitModel;
import bg.tuplovdiv.cookingrecipes.domain.enums.MeasureUnitType;
import jakarta.validation.constraints.NotNull;

public class RecipeIngredientAddForm {

    @NotNull
    private Long ingredientId; //String?

    @NotNull
    private Long measureUnitId; //String?

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

    public Long getIngredientId() {
        return ingredientId;
    }

    public RecipeIngredientAddForm setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
        return this;
    }

    public Long getMeasureUnitId() {
        return measureUnitId;
    }

    public RecipeIngredientAddForm setMeasureUnitId(Long measureUnitId) {
        this.measureUnitId = measureUnitId;
        return this;
    }
}
