package bg.tuplovdiv.cookingrecipes.domain.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ingredients")
public class Ingredient extends BaseEntity {

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
