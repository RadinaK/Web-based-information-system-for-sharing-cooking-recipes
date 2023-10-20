package bg.tuplovdiv.cookingrecipes.domain.entities;

import bg.tuplovdiv.cookingrecipes.domain.enums.MeasureUnitType;
import jakarta.persistence.*;

@Entity
@Table(name = "measure_units")
public class MeasureUnit extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private MeasureUnitType type;


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

    public MeasureUnitType getType() {
        return type;
    }
}
