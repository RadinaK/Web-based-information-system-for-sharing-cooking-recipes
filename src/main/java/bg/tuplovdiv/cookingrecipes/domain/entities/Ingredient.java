package bg.tuplovdiv.cookingrecipes.domain.entities;

import bg.tuplovdiv.cookingrecipes.domain.enums.Allergy;
import bg.tuplovdiv.cookingrecipes.domain.enums.NutritionFact;
import jakarta.persistence.*;

@Entity
@Table(name = "ingredients")
public class Ingredient extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column
    private Double calories;

    @Enumerated(EnumType.STRING)
    private Allergy allergy;

//    @Enumerated(EnumType.STRING)
//    private NutritionFact nutritionFact;


//    @ManyToMany(mappedBy = "ingredients",
//            fetch = FetchType.EAGER,
//            cascade = CascadeType.ALL)
//    public Set<Recipe> recipes;

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

//    public NutritionFact getNutritionFact() {
//        return nutritionFact;
//    }
//
//    public Ingredient setNutritionFact(NutritionFact nutritionFact) {
//        this.nutritionFact = nutritionFact;
//        return this;
//    }
}
