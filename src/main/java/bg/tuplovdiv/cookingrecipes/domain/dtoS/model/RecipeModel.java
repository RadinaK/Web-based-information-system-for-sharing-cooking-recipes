package bg.tuplovdiv.cookingrecipes.domain.dtoS.model;

import bg.tuplovdiv.cookingrecipes.domain.entities.RecipeIngredient;
import bg.tuplovdiv.cookingrecipes.domain.enums.NameCategory;

import java.util.List;
import java.util.Set;

public class RecipeModel {
    private Long id;

    private String title;

    private Integer cookingTime;

    private Integer servings;

    private String description;

    private NameCategory nameCategory;

    private UserModel cook;

    private Set<PictureModel> pictures;

    private List<RecipeIngredient> recipeIngredientList;

    public RecipeModel() {
    }

    public List<RecipeIngredient> getRecipeIngredientList() {
        return recipeIngredientList;
    }

    public RecipeModel setRecipeIngredientList(List<RecipeIngredient> recipeIngredientList) {
        this.recipeIngredientList = recipeIngredientList;
        return this;
    }


    public Long getId() {
        return id;
    }

    public RecipeModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public RecipeModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getCookingTime() {
        return cookingTime;
    }

    public RecipeModel setCookingTime(Integer cookingTime) {
        this.cookingTime = cookingTime;
        return this;
    }

    public Integer getServings() {
        return servings;
    }

    public RecipeModel setServings(Integer servings) {
        this.servings = servings;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RecipeModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public NameCategory getNameCategory() {
        return nameCategory;
    }

    public RecipeModel setNameCategory(NameCategory nameCategory) {
        this.nameCategory = nameCategory;
        return this;
    }

    public UserModel getCook() {
        return cook;
    }

    public RecipeModel setCook(UserModel cook) {
        this.cook = cook;
        return this;
    }

    public Set<PictureModel> getPictures() {
        return pictures;
    }

    public RecipeModel setPictures(Set<PictureModel> pictures) {
        this.pictures = pictures;
        return this;
    }
}
