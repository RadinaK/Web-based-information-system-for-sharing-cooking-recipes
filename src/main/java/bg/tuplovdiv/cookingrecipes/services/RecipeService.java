package bg.tuplovdiv.cookingrecipes.services;

//import bg.tuplovdiv.cookingrecipes.models.dtos.AddressDTO;

import bg.tuplovdiv.cookingrecipes.domain.models.recipes.Recipe;

public interface RecipeService {
//    Recipe create(AddressDTO data);

    Recipe create(Recipe recipe);
}
