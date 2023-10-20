package bg.tuplovdiv.cookingrecipes.services;

import bg.tuplovdiv.cookingrecipes.domain.dtoS.model.RecipeModel;
import bg.tuplovdiv.cookingrecipes.domain.enums.NameCategory;
import bg.tuplovdiv.cookingrecipes.repositories.RecipeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService  {

    private final RecipeRepository recipeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository, ModelMapper modelMapper) {
        this.recipeRepository = recipeRepository;
        this.modelMapper = modelMapper;
    }


    public RecipeModel findByTitle(String title) {
        return this.modelMapper.map(this.recipeRepository.findByTitle(title), RecipeModel.class);
    }

    public RecipeModel findByNameCategory(NameCategory nameCategory) {
        return this.modelMapper.map(this.recipeRepository.findByNameCategory(nameCategory), RecipeModel.class);
    }
}
