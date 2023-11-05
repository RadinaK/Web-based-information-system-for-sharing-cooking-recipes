package bg.tuplovdiv.cookingrecipes.web;

import bg.tuplovdiv.cookingrecipes.domain.dtoS.banding.RecipeAddForm;
import bg.tuplovdiv.cookingrecipes.domain.dtoS.banding.RecipeIngredientAddForm;
import bg.tuplovdiv.cookingrecipes.services.RecipeIngredientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("/recipe_ingredients")
public class RecipeIngredientController extends BaseController {
    private final RecipeIngredientService recipeIngredientService;

    @Autowired
    public RecipeIngredientController(RecipeIngredientService recipeIngredientService) {
        this.recipeIngredientService = recipeIngredientService;
    }

//    @GetMapping("/add")
//    public ModelAndView getAdd(ModelAndView modelAndView) {
//        return super.view("add-recipe", modelAndView);
//    }

    @GetMapping("/add")
    public ModelAndView getAdd(ModelAndView modelAndView) {
        modelAndView.addObject("recipeIngredientAddForm", new RecipeIngredientAddForm());

        return super.view("add-recipe", modelAndView);
    }

    @PostMapping("/add")
    public ModelAndView postAdd(@Valid RecipeIngredientAddForm recipeIngredientAddForm,
                                BindingResult bindingResult,
                                ModelAndView modelAndView) throws IOException {
        if (bindingResult.hasErrors()) {
            return super.view("add-recipe",
                    modelAndView.addObject(recipeIngredientAddForm));
        }


        this.recipeIngredientService.addNewRecipeIngredient(recipeIngredientAddForm);

        return super.view("redirect:/recipes");
    }
}
