package bg.tuplovdiv.cookingrecipes.domain.dtoS.banding;

import org.springframework.web.multipart.MultipartFile;
import bg.tuplovdiv.cookingrecipes.domain.enums.NameCategory;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class RecipeAddForm {
    @Size(min = 4, max = 20)
    private String title;

    @NotNull
    private List<RecipeIngredientAddForm> recipeIngredientList;

    @Size(min = 200)
    private String description;

    @NotNull
    private MultipartFile picture;

    private String photoFileName;

    @NotNull
    private NameCategory nameCategory;

    @NotNull
    private Integer cookingTime;

    @NotNull
    private Integer servings;

    public RecipeAddForm() {
        this.recipeIngredientList = new ArrayList<>();

//        this.recipeIngredientList.setIngredient
        //TODO delete

//        RecipeIngredientAddForm recipeIngredientAddForm = new RecipeIngredientAddForm();
//        IngredientModel ingredientModel = new IngredientModel();
//        ingredientModel.setId(20l);
//        ingredientModel.setAllergy(Allergy.NONE);
//        ingredientModel.
//
//        recipeIngredientAddForm.setIngredient()
//        recipeIngredientList.add(recipeIngredientAddForm);
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

    public String getPhotoFileName() {
        return photoFileName;
    }

    public RecipeAddForm setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
        return this;
    }

        public MultipartFile getPicture() {
        return picture;
    }

    public RecipeAddForm setPicture(MultipartFile picture) {
        this.picture = picture;
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
