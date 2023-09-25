package bg.tuplovdiv.cookingrecipes.domain.models.allergies;

import javax.persistence.*;

@Entity
@Table(name = "allergies")
public class Allergy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;
}
