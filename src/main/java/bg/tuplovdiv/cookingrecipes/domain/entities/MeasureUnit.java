package bg.tuplovdiv.cookingrecipes.domain.entities;

import bg.tuplovdiv.cookingrecipes.domain.enums.MeasureUnitType;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "measure_units")
public class MeasureUnit extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private MeasureUnitType type;

    @Column
    private Double quantity;

//    @ManyToMany(mappedBy = "measureUnits",
//            fetch = FetchType.EAGER,
//            cascade = CascadeType.ALL)
//    public Set<Recipe> recipes;

    public MeasureUnit() {
    }

    public MeasureUnit setType(MeasureUnitType type) {
        this.type = type;
        return this;
    }

    public double getQuantity() {
        return quantity;
    }

    public MeasureUnit setQuantity(double quantity) {
        this.quantity = quantity;
        return this;
    }

    public MeasureUnitType getType() {
        return type;
    }
}
