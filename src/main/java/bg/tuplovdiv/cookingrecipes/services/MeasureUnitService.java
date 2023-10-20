package bg.tuplovdiv.cookingrecipes.services;

import bg.tuplovdiv.cookingrecipes.domain.dtoS.model.MeasureUnitModel;
import bg.tuplovdiv.cookingrecipes.repositories.MeasureUnitRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
