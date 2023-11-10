package bg.tuplovdiv.cookingrecipes.domain.entities;

import bg.tuplovdiv.cookingrecipes.domain.enums.NameCategory;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "recipes")
public class Recipe extends BaseEntity {

    @Column(name = "title", unique = true, nullable = false)
    private String title;

    @Column(name = "cooking_time", nullable = false)
    private Integer cookingTime;

    @Column(name = "servings", nullable = false)
    private Integer servings;

    @Column(columnDefinition = "TEXT", name = "description", nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    private NameCategory nameCategory;

    @ManyToOne
    private User cook;

    @OneToMany(targetEntity = Picture.class,
            mappedBy = "recipe",
            fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE})
    private Set<Picture> pictures;

//    @OneToMany(targetEntity = RecipeIngredient.class,
//            mappedBy = "recipe",
//            fetch = FetchType.EAGER,
//            cascade = {CascadeType.DETACH, CascadeType.MERGE})
//    private Set<RecipeIngredient> recipeIngredients;

    @OneToMany(targetEntity = RecipeIngredient.class,
            mappedBy = "recipe",
            fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE})
    private List<RecipeIngredient> recipeIngredientList;

    public Recipe() {
    }

    public List<RecipeIngredient> getRecipeIngredientList() {
        return recipeIngredientList;
    }

    public Recipe setRecipeIngredientList(List<RecipeIngredient> recipeIngredientList) {
        this.recipeIngredientList = recipeIngredientList;
        return this;
    }

    //    public Set<RecipeIngredient> getRecipeIngredients() {
//        return recipeIngredients;
//    }
//
//    public Recipe setRecipeIngredients(Set<RecipeIngredient> recipeIngredients) {
//        this.recipeIngredients = recipeIngredients;
//        return this;
//    }



    public String getTitle() {
        return title;
    }

    public Recipe setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public Recipe setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
        return this;
    }

    public int getServings() {
        return servings;
    }

    public Recipe setServings(int servings) {
        this.servings = servings;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Recipe setDescription(String description) {
        this.description = description;
        return this;
    }


    public NameCategory getNameCategory() {
        return nameCategory;
    }

    public Recipe setNameCategory(NameCategory nameCategory) {
        this.nameCategory = nameCategory;
        return this;
    }

    public User getCook() {
        return cook;
    }

    public Recipe setCook(User cook) {
        this.cook = cook;
        return this;
    }

    public Recipe setCookingTime(Integer cookingTime) {
        this.cookingTime = cookingTime;
        return this;
    }

    public Recipe setServings(Integer servings) {
        this.servings = servings;
        return this;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public Recipe setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }
}
