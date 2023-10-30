package bg.tuplovdiv.cookingrecipes.services;

import bg.tuplovdiv.cookingrecipes.domain.dtoS.model.RecipeIngredientModel;
import bg.tuplovdiv.cookingrecipes.domain.entities.Ingredient;
import bg.tuplovdiv.cookingrecipes.domain.entities.RecipeIngredient;
import bg.tuplovdiv.cookingrecipes.helpers.LoggedUser;
import bg.tuplovdiv.cookingrecipes.repositories.RecipeIngredientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeIngredientService {

    private final RecipeIngredientRepository recipeIngredientRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final MeasureUnitService measureUnitService;
    private final IngredientService ingredientService;
//    private final RecipeService recipeService;
    private final LoggedUser loggedUser;

    @Autowired
    public RecipeIngredientService(RecipeIngredientRepository recipeIngredientRepository, ModelMapper modelMapper, UserService userService, LoggedUser loggedUser, MeasureUnitService measureUnitService, IngredientService ingredientService) {
        this.recipeIngredientRepository = recipeIngredientRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.measureUnitService = measureUnitService;
        this.ingredientService = ingredientService;
        this.loggedUser = loggedUser;
    }

    public RecipeIngredientModel findByIngredient(Ingredient ingredient) {
        return this.modelMapper.map(this.recipeIngredientRepository.findByIngredient(ingredient), RecipeIngredientModel.class);
    }

//    public RecipeIngredientModel findAll(RecipeIngredient recipeIngredient) {
//        return this.modelMapper.map(this.recipeIngredientRepository.findAll(recipeIngredient), RecipeIngredientModel.class);
//    }
}
