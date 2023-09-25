package bg.tuplovdiv.cookingrecipes.domain.models.ingredients;

import bg.tuplovdiv.cookingrecipes.domain.models.allergies.Allergy;
import bg.tuplovdiv.cookingrecipes.domain.models.measureunits.MeasureUnit;
import bg.tuplovdiv.cookingrecipes.domain.models.nutritionfacts.NutritionFact;
import bg.tuplovdiv.cookingrecipes.domain.models.recipes.Recipe;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne
    private Allergy allergy;

    @OneToOne
    private NutritionFact nutritionFact;

    @OneToOne
    private MeasureUnit measureUnit;

    @ManyToMany(mappedBy = "ingredients",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    public Set<Recipe> recipes;

}
