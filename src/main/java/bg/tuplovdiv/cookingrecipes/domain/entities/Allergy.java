package bg.tuplovdiv.cookingrecipes.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "allergies")
public class Allergy extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;
}
