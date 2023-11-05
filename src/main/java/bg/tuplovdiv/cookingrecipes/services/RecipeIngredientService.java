package bg.tuplovdiv.cookingrecipes.services;

import bg.tuplovdiv.cookingrecipes.domain.dtoS.banding.RecipeAddForm;
import bg.tuplovdiv.cookingrecipes.domain.dtoS.banding.RecipeIngredientAddForm;
import bg.tuplovdiv.cookingrecipes.domain.dtoS.model.RecipeIngredientModel;
import bg.tuplovdiv.cookingrecipes.domain.entities.*;
import bg.tuplovdiv.cookingrecipes.helpers.LoggedUser;
import bg.tuplovdiv.cookingrecipes.repositories.RecipeIngredientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

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

    public RecipeIngredientModel findByMeasureUnit(MeasureUnit measureUnit) {
        return this.modelMapper.map(this.recipeIngredientRepository.findByMeasureUnit(measureUnit), RecipeIngredientModel.class);
    }

    public void addNewRecipeIngredient(RecipeIngredientAddForm recipeIngredientAddForm) throws IOException {
        RecipeIngredient recipeIngredient = this.modelMapper.map(recipeIngredientAddForm, RecipeIngredient.class);

//        recipeIngredient
//                .setIngredient(recipeIngredientAddForm.getIngredient())
//                .setMeasureUnit(recipeIngredientAddForm.getMeasureUnit())
//                .setTitle(recipeAddForm.getTitle())
//                .setCook(this.modelMapper
//                        .map(this.userService
//                                        .findByUsername(this.loggedUser.getUsername()),
//                                User.class))
//                .getRecipeIngredients()
//                    .stream()
//                    .map(recipeIngredient -> this.modelMapper
//                        .map(recipeIngredient.getIngredient(),
//                                recipeIngredient.getMeasureUnit(),
//                                recipeIngredient.getAmount()), RecipeIngredient.class)
//        ;

        this.recipeIngredientRepository.saveAndFlush(recipeIngredient);
    }

    public RecipeAddForm addRecipeIngredient(RecipeAddForm recipeAddForm, RecipeIngredientAddForm newRecipeIngredient) {
        recipeAddForm.getRecipeIngredientList().add(newRecipeIngredient);
        return recipeAddForm;
    }

    public RecipeAddForm removeRecipeIngredient(RecipeAddForm recipeAddForm, int index) {
        if (index >= 0 && index < recipeAddForm.getRecipeIngredientList().size()) {
            recipeAddForm.getRecipeIngredientList().remove(index);
        }
        return recipeAddForm;
    }

//    public RecipeIngredientModel findAll(RecipeIngredient recipeIngredient) {
//        return this.modelMapper.map(this.recipeIngredientRepository.findAll(recipeIngredient), RecipeIngredientModel.class);
//    }
}
