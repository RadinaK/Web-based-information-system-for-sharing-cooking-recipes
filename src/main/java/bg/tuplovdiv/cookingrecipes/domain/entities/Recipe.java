package bg.tuplovdiv.cookingrecipes.domain.entities;

import bg.tuplovdiv.cookingrecipes.domain.enums.RecipeCategory;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "recipes")
public class Recipe extends BaseEntity {

    @Column(name = "title", unique = true, nullable = false)
    private String title;

    @Column(name = "cooking_time", nullable = false)
    private int cookingTime;

    @Column(name = "servings", nullable = false)
    private int servings;

    @Column(columnDefinition = "TEXT", name = "description", nullable = false)
    private String description;

    @Column(name = "published_date", nullable = false)
    private LocalDate publishedDate;

    @Column
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private RecipeCategory recipeCategory;

    @ManyToOne
    private User user;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "recipe_ingredients",
            joinColumns = @JoinColumn(name = "recipe_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id"))
    private Set<Ingredient> ingredients;

    public Recipe() {
    }

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

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public Recipe setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Recipe setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public RecipeCategory getRecipeCategory() {
        return recipeCategory;
    }

    public Recipe setRecipeCategory(RecipeCategory recipeCategory) {
        this.recipeCategory = recipeCategory;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Recipe setUser(User user) {
        this.user = user;
        return this;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public Recipe setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
        return this;
    }
}