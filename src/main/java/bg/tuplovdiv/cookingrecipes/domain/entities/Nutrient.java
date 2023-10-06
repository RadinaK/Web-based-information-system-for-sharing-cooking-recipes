package bg.tuplovdiv.cookingrecipes.domain.entities;

import bg.tuplovdiv.cookingrecipes.domain.enums.NutrientType;
import jakarta.persistence.*;

@Entity
@Table(name = "nutrients")
public class Nutrient extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private NutrientType type;

    @Column
    private double quantity;

//    @ManyToMany(mappedBy = "nutrients",
//            fetch = FetchType.EAGER,
//            cascade = CascadeType.ALL)
//    public Set<Ingredient> ingredients;


    public Nutrient() {
    }

    public NutrientType getType() {
        return type;
    }

    public Nutrient setType(NutrientType type) {
        this.type = type;
        return this;
    }

    public double getQuantity() {
        return quantity;
    }

    public Nutrient setQuantity(double quantity) {
        this.quantity = quantity;
        return this;
    }
}
