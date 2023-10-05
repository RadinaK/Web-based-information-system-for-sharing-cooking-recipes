package bg.tuplovdiv.cookingrecipes.domain.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "measure_units")
public class MeasureUnit extends BaseEntity {

    @Column
    private String type;

    @Column
    private double quantity;

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
