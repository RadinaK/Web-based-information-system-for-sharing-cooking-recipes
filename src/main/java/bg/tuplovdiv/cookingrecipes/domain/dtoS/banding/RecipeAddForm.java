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
    private String title;

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

    public String getTitle() {
        return title;
    }

    public RecipeAddForm setTitle(String title) {
        this.title = title;
        return this;
    }

    public List<RecipeIngredientAddForm> getRecipeIngredientList() {
        return recipeIngredientList;
    }

    public RecipeAddForm setRecipeIngredientList(List<RecipeIngredientAddForm> recipeIngredientList) {
        this.recipeIngredientList = recipeIngredientList;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RecipeAddForm setDescription(String description) {
        this.description = description;
        return this;
    }

    public MultipartFile getPictures() {
        return pictures;
    }

    public RecipeAddForm setPictures(MultipartFile pictures) {
        this.pictures = pictures;
        return this;
    }

    public NameCategory getNameCategory() {
        return nameCategory;
    }

    public RecipeAddForm setNameCategory(NameCategory nameCategory) {
        this.nameCategory = nameCategory;
        return this;
    }

    public Integer getCookingTime() {
        return cookingTime;
    }

    public RecipeAddForm setCookingTime(Integer cookingTime) {
        this.cookingTime = cookingTime;
        return this;
    }

    public Integer getServings() {
        return servings;
    }

    public RecipeAddForm setServings(Integer servings) {
        this.servings = servings;
        return this;
    }
}
