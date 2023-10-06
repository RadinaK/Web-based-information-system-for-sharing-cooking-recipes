package bg.tuplovdiv.cookingrecipes.domain.entities;

import bg.tuplovdiv.cookingrecipes.domain.enums.MeasureUnitType;
import jakarta.persistence.*;

@Entity
@Table(name = "measure_units")
public class MeasureUnit extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private MeasureUnitType type;

    @Column
    private double quantity;

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

}
