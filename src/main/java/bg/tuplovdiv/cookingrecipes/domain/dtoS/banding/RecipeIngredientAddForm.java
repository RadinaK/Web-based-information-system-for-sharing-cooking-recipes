package bg.tuplovdiv.cookingrecipes.domain.dtoS.banding;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Map;

public class RecipeIngredientAddForm {
    @NotNull
    private List<String> ingredients; //String?

    @NotNull
    private List<String> measureUnits;

    @NotNull
    private List<Double> amount;

    @Size(min = 4, max = 50)
    private String name;


    @Size(min = 200)
    private String description;


    public RecipeIngredientAddForm() {
    }
}
