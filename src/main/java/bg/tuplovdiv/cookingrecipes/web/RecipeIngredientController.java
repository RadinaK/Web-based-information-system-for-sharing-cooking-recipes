package bg.tuplovdiv.cookingrecipes.web;

import bg.tuplovdiv.cookingrecipes.services.RecipeIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/recipe_ingredients")
public class RecipeIngredientController extends BaseController {
    private final RecipeIngredientService recipeIngredientService;

    @Autowired
    public RecipeIngredientController(RecipeIngredientService recipeIngredientService) {
        this.recipeIngredientService = recipeIngredientService;
    }

    @GetMapping("/add")
    public ModelAndView getAdd(ModelAndView modelAndView) {
        return super.view("add-recipe", modelAndView);
    }
}
