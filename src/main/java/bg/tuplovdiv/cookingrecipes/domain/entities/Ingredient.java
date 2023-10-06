package bg.tuplovdiv.cookingrecipes.domain.entities;

import bg.tuplovdiv.cookingrecipes.domain.enums.Allergy;
import bg.tuplovdiv.cookingrecipes.domain.enums.NutritionFact;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ingredients")
public class Ingredient extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

//    @Column
//    private double quantity;

    @Column
    private double calories;

    @Enumerated(EnumType.STRING)
    private Allergy allergy;

    @Enumerated(EnumType.STRING)
    private NutritionFact nutritionFact;

    @OneToOne
    private MeasureUnit measureUnit;

    @ManyToMany(mappedBy = "ingredients",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    public Set<Recipe> recipes;

//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(name = "ingredients_nutrients",
//            joinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "nutrient_id", referencedColumnName = "id"))
//    private Set<Nutrient> nutrients;
    @OneToOne
    private Nutrient nutrients;

    public Ingredient() {
    }

    public String getName() {
        return name;
    }

    public Ingredient setName(String name) {
        this.name = name;
        return this;
    }

    public double getCalories() {
        return calories;
    }

    public Ingredient setCalories(double calories) {
        this.calories = calories;
        return this;
    }

    public Allergy getAllergy() {
        return allergy;
    }

    public Ingredient setAllergy(Allergy allergy) {
        this.allergy = allergy;
        return this;
    }

    public NutritionFact getNutritionFact() {
        return nutritionFact;
    }

    public Ingredient setNutritionFact(NutritionFact nutritionFact) {
        this.nutritionFact = nutritionFact;
        return this;
    }

    public MeasureUnit getMeasureUnit() {
        return measureUnit;
    }

    public Ingredient setMeasureUnit(MeasureUnit measureUnit) {
        this.measureUnit = measureUnit;
        return this;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public Ingredient setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
        return this;
    }

    public Nutrient getNutrients() {
        return nutrients;
    }

    public Ingredient setNutrients(Nutrient nutrients) {
        this.nutrients = nutrients;
        return this;
    }

//    public Set<Nutrient> getNutrients() {
//        return nutrients;
//    }
//
//    public Ingredient setNutrients(Set<Nutrient> nutrients) {
//        this.nutrients = nutrients;
//        return this;
//    }
}
