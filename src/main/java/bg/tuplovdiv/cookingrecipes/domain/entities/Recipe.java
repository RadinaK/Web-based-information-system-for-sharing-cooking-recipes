package bg.tuplovdiv.cookingrecipes.domain.entities;

import bg.tuplovdiv.cookingrecipes.domain.enums.NameCategory;
import jakarta.persistence.*;

import java.time.LocalDate;

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

//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(name = "recipe_ingredients",
//            joinColumns = @JoinColumn(name = "recipe_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id"))
//    private Set<Ingredient> ingredients;
//
//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(name = "recipe_measureunits",
//            joinColumns = @JoinColumn(name = "recipe_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "measureunit_id", referencedColumnName = "id"))
//    private Set<MeasureUnit> measureUnits;


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

}
