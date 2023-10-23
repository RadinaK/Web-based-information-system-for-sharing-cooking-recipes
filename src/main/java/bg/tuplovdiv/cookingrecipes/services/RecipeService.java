package bg.tuplovdiv.cookingrecipes.services;

import bg.tuplovdiv.cookingrecipes.domain.dtoS.model.RecipeModel;
import bg.tuplovdiv.cookingrecipes.domain.dtoS.veiw.RecipePartialViewModel;
import bg.tuplovdiv.cookingrecipes.domain.enums.NameCategory;
import bg.tuplovdiv.cookingrecipes.helpers.LoggedUser;
import bg.tuplovdiv.cookingrecipes.repositories.RecipeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService  {
    private final RecipeRepository recipeRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final LoggedUser loggedUser;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository, ModelMapper modelMapper, UserService userService, LoggedUser loggedUser) {
        this.recipeRepository = recipeRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.loggedUser = loggedUser;
    }


    public RecipeModel findByTitle(String title) {
        return this.modelMapper.map(this.recipeRepository.findByTitle(title), RecipeModel.class);
    }

    public RecipeModel findByNameCategory(NameCategory nameCategory) {
        return this.modelMapper.map(this.recipeRepository.findByNameCategory(nameCategory), RecipeModel.class);
    }

    public List<RecipePartialViewModel> getAllRoutesPartialViews() {
        return this.recipeRepository
                .findAll()
                .stream()
                .map(RecipePartialViewModel::fromRecipe)
                .toList();
    }
}
