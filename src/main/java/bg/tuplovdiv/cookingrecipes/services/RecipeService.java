package bg.tuplovdiv.cookingrecipes.services;

import bg.tuplovdiv.cookingrecipes.domain.dtoS.banding.RecipeAddForm;
import bg.tuplovdiv.cookingrecipes.domain.dtoS.model.RecipeModel;
import bg.tuplovdiv.cookingrecipes.domain.dtoS.veiw.RecipePartialViewModel;
import bg.tuplovdiv.cookingrecipes.domain.entities.Recipe;
import bg.tuplovdiv.cookingrecipes.domain.entities.RecipeIngredient;
import bg.tuplovdiv.cookingrecipes.domain.entities.User;
import bg.tuplovdiv.cookingrecipes.domain.enums.NameCategory;
import bg.tuplovdiv.cookingrecipes.helpers.LoggedUser;
import bg.tuplovdiv.cookingrecipes.repositories.RecipeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RecipeService  {
    private final RecipeRepository recipeRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final LoggedUser loggedUser;
    private final RecipeIngredientService recipeIngredientService;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository, ModelMapper modelMapper, UserService userService, LoggedUser loggedUser, RecipeIngredientService recipeIngredientService) {
        this.recipeRepository = recipeRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.loggedUser = loggedUser;
        this.recipeIngredientService = recipeIngredientService;
    }


    public RecipeModel findByTitle(String title) {
        return this.modelMapper.map(this.recipeRepository.findByTitle(title), RecipeModel.class);
    }

    public RecipeModel findByNameCategory(NameCategory nameCategory) {
        return this.modelMapper.map(this.recipeRepository.findByNameCategory(nameCategory), RecipeModel.class);
    }

    public List<RecipePartialViewModel> getAllRecipesPartialViews() {
        return this.recipeRepository
                .findAll()
                .stream()
                .map(RecipePartialViewModel::fromRecipe)
                .toList();
    }

    @Transactional
    public RecipeModel findById(Long id) {
        return this.modelMapper
                .map(this.recipeRepository
                                .findById(id)
                                .orElseThrow(NoSuchElementException::new),
                        RecipeModel.class);
    }

    public void addNewRecipe(RecipeAddForm recipeAddForm) throws IOException {
        Recipe recipe = this.modelMapper.map(recipeAddForm, Recipe.class);

        recipe
//                .setTitle(recipeAddForm.getTitle())
                .setCook(this.modelMapper
                        .map(this.userService
                                        .findByUsername(this.loggedUser.getUsername()),
                                User.class))
//                .getRecipeIngredients()
//                    .stream()
//                    .map(recipeIngredient -> this.modelMapper
//                        .map(recipeIngredient.getIngredient(),
//                                recipeIngredient.getMeasureUnit(),
//                                recipeIngredient.getAmount()), RecipeIngredient.class)

//                .setCategories(recipeAddForm.getCategories()
//                        .stream()
//                        .map(cm -> this.modelMapper
//                                .map(this.categoryService
//                                                .findByName(CategoryName.valueOf(cm)),
//                                        Category.class))
//                        .collect(Collectors.toSet()))
        ;

        this.recipeRepository.saveAndFlush(recipe);
    }




}
