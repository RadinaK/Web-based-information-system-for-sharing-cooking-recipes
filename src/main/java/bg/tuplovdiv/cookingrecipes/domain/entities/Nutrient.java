package bg.tuplovdiv.cookingrecipes.domain.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "nutrients")
public class Nutrient extends BaseEntity {

    @Column(name = "name", unique = true)
    private String name;

    @Column
    private double quantity;

//    @ManyToMany(mappedBy = "nutrients",
//            fetch = FetchType.EAGER,
//            cascade = CascadeType.ALL)
//    public Set<Ingredient> ingredients;
}
