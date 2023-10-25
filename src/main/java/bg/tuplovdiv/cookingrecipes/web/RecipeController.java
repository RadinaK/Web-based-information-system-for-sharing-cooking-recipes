package bg.tuplovdiv.cookingrecipes.web;

import bg.tuplovdiv.cookingrecipes.domain.dtoS.banding.RecipeAddForm;
import bg.tuplovdiv.cookingrecipes.services.RecipeService;
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
@RequestMapping("/recipes")
public class RecipeController extends BaseController {
    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public ModelAndView getAllRoutes(ModelAndView modelAndView) {
        return super.view("recipes",
                modelAndView.addObject("recipes", this.recipeService.getAllRoutesPartialViews()));
    }

    @GetMapping("/add")
    public ModelAndView getAdd(ModelAndView modelAndView) {
        return super.view("add-recipe", modelAndView);
    }

    @PostMapping("/add")
    public ModelAndView postAdd(@Valid RecipeAddForm recipeAddForm,
                                BindingResult bindingResult,
                                ModelAndView modelAndView) throws IOException {
        if (bindingResult.hasErrors()) {
            return super.view("add-recipe",
                    modelAndView.addObject(recipeAddForm));
        }

        this.recipeService.addNewRecipe(recipeAddForm);

        return super.view("redirect:/recipes");
    }

}
