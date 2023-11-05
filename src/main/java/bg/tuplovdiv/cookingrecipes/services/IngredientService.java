package bg.tuplovdiv.cookingrecipes.services;

import bg.tuplovdiv.cookingrecipes.domain.dtoS.model.IngredientModel;
import bg.tuplovdiv.cookingrecipes.domain.entities.Ingredient;
import bg.tuplovdiv.cookingrecipes.repositories.IngredientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService  {
    private final IngredientRepository ingredientRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository, ModelMapper modelMapper) {
        this.ingredientRepository = ingredientRepository;
        this.modelMapper = modelMapper;
    }


    public IngredientModel findByName(String ingredientName) {
        return this.modelMapper.map(this.ingredientRepository.findByName(ingredientName), IngredientModel.class);
    }

    //TODO findAll query
    public List<String> findAll() {
        return ingredientRepository.findAll()
                .stream()
                .map(Ingredient::getName)
                .toList();
    }
}

