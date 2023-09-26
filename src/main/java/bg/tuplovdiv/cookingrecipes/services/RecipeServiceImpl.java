package bg.tuplovdiv.cookingrecipes.services;


import bg.tuplovdiv.cookingrecipes.domain.entities.Recipe;
import bg.tuplovdiv.cookingrecipes.repositories.RecipeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    private final ModelMapper mapper;

//    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository, ModelMapper mapper) {
        this.recipeRepository = recipeRepository;
        this.mapper = mapper;
    }

    @Override
    public Recipe create(Recipe recipe) {
        return this.recipeRepository.save(recipe);
    }

//    @Override
//    public Address create(AddressDTO data) {
//        Address address = mapper.map(data, Address.class);
//
//        return this.recipeRepository.save(address);
//    }
}
