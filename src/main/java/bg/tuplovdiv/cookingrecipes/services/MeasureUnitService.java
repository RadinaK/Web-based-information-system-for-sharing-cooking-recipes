package bg.tuplovdiv.cookingrecipes.services;

import bg.tuplovdiv.cookingrecipes.domain.dtoS.model.MeasureUnitModel;
import bg.tuplovdiv.cookingrecipes.domain.entities.Ingredient;
import bg.tuplovdiv.cookingrecipes.domain.entities.MeasureUnit;
import bg.tuplovdiv.cookingrecipes.domain.enums.MeasureUnitType;
import bg.tuplovdiv.cookingrecipes.repositories.MeasureUnitRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasureUnitService  {

    private final MeasureUnitRepository measureUnitRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MeasureUnitService(MeasureUnitRepository measureUnitRepository, ModelMapper modelMapper) {
        this.measureUnitRepository = measureUnitRepository;
        this.modelMapper = modelMapper;
    }


    public MeasureUnitModel findByType(String type) {
        return this.modelMapper.map(this.measureUnitRepository.findByType(type), MeasureUnitModel.class);
    }

    //TODO findAll query
    public List<MeasureUnitType> findAll() {
        return measureUnitRepository.findAll()
                .stream()
                .map(MeasureUnit::getType)
                .toList();
    }

    public MeasureUnitModel findByMeasureUnitType(MeasureUnitType type) {
        return this.modelMapper.map(this.measureUnitRepository.findByType(type.name()), MeasureUnitModel.class);
    }
}
