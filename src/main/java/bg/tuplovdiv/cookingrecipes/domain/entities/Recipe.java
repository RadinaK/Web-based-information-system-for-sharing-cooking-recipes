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

    @Column(name = "description", nullable = false, length = 5000)
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
}
