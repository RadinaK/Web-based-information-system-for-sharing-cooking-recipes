package bg.tuplovdiv.cookingrecipes.domain.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "measure_units")
public class MeasureUnit extends BaseEntity {

    @Column
    private String type;

    @Column
    private double quantity;

    public MeasureUnit() {
    }

    public String getType() {
        return type;
    }

    public MeasureUnit setType(String type) {
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

    //Teaspoon = t or tsp
    //Tablespoon = T, TB, or tbsp
    //Cup = C or c
    //Pint = pt
    //Quart = qt
    //Gallon = gal
    //Ounce = oz
    //Fluid ounce = fl oz
    //Pound = lb

    //Milliliter = mL
    //Liter = L or l
    //Gram = g
    //Kilogram = kg
}
