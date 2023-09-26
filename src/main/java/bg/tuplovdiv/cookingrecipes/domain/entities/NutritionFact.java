package bg.tuplovdiv.cookingrecipes.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "nutrition_facts")
public class NutritionFact extends BaseEntity {

    @Column(name = "type", nullable = false)
    private String type;
}
