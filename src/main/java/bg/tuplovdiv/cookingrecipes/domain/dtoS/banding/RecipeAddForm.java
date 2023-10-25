package bg.tuplovdiv.cookingrecipes.domain.dtoS.banding;

import bg.tuplovdiv.cookingrecipes.domain.entities.Picture;
import org.springframework.web.multipart.MultipartFile;
import bg.tuplovdiv.cookingrecipes.domain.entities.RecipeIngredient;
import bg.tuplovdiv.cookingrecipes.domain.enums.NameCategory;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Set;

public class RecipeAddForm {
    @Size(min = 4, max = 50)
    private String name;

    @NotNull
    private List<RecipeIngredientAddForm> recipeIngredientList;

    @Size(min = 200)
    private String description;

    private MultipartFile pictures;

    private NameCategory nameCategory;

    private Integer cookingTime;

    private Integer servings;

    public RecipeAddForm() {
    }
}
