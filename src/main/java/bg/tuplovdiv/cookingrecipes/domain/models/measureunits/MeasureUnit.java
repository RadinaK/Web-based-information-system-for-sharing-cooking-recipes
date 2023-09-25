package bg.tuplovdiv.cookingrecipes.domain.models.measureunits;

import bg.tuplovdiv.cookingrecipes.domain.models.ingredients.Ingredient;

import javax.persistence.*;

@Entity
@Table(name = "measure_units")
public class MeasureUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne
    private Ingredient ingredient;
}
