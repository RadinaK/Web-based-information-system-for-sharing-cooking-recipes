package bg.tuplovdiv.cookingrecipes.domain.models.nutritionfacts;

import javax.persistence.*;

@Entity
@Table(name = "nutrition_facts")
public class NutritionFact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "type", nullable = false)
    private String type;
}
