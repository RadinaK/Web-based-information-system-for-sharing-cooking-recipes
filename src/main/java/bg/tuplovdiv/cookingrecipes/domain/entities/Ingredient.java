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

    @Column
    private double quantity;

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
}
