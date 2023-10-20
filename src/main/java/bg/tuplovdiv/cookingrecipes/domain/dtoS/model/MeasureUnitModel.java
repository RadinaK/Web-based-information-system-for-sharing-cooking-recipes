package bg.tuplovdiv.cookingrecipes.domain.dtoS.model;

import bg.tuplovdiv.cookingrecipes.domain.enums.MeasureUnitType;

public class MeasureUnitModel {
    private Long id;
    private MeasureUnitType measureUnitType;

    public MeasureUnitModel() {
    }

    public Long getId() {
        return id;
    }

    public MeasureUnitModel setId(Long id) {
        this.id = id;
        return this;
    }

    public MeasureUnitType getMeasureUnitType() {
        return measureUnitType;
    }

    public MeasureUnitModel setMeasureUnitType(MeasureUnitType measureUnitType) {
        this.measureUnitType = measureUnitType;
        return this;
    }

}
