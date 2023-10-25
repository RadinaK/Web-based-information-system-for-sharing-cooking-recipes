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
}
