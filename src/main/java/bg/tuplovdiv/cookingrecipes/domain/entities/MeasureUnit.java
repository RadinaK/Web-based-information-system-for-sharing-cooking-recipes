package bg.tuplovdiv.cookingrecipes.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "measure_units")
public class MeasureUnit extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;
}
