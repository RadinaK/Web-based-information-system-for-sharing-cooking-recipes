package bg.tuplovdiv.cookingrecipes.web;

import bg.tuplovdiv.cookingrecipes.domain.dtoS.model.RecipeModel;
import bg.tuplovdiv.cookingrecipes.domain.dtoS.veiw.RecipePartialViewModel;
import bg.tuplovdiv.cookingrecipes.helpers.LoggedUser;
import bg.tuplovdiv.cookingrecipes.repositories.RecipeRepository;
import bg.tuplovdiv.cookingrecipes.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class RecipeService {
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


    public List<RecipePartialViewModel> getAllRoutesPartialViews() {
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
    
}
