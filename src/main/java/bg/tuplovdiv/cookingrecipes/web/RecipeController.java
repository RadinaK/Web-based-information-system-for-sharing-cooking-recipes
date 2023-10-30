package bg.tuplovdiv.cookingrecipes.web;

import bg.tuplovdiv.cookingrecipes.domain.dtoS.banding.RecipeAddForm;
import bg.tuplovdiv.cookingrecipes.domain.dtoS.banding.RecipeIngredientAddForm;
import bg.tuplovdiv.cookingrecipes.domain.entities.Recipe;
import bg.tuplovdiv.cookingrecipes.helpers.LoggedUser;
import bg.tuplovdiv.cookingrecipes.services.RecipeService;
import bg.tuplovdiv.cookingrecipes.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/recipes")
public class RecipeController extends BaseController {
    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public ModelAndView getAllRecipes(ModelAndView modelAndView) {
        return super.view("recipes",
                modelAndView.addObject("recipes", this.recipeService.getAllRecipesPartialViews()));
    }

    @GetMapping("/{id}")
    public ModelAndView getById(@PathVariable Long id,
                                ModelAndView modelAndView) {
        return super.view("recipe-details",
                modelAndView.addObject("recipe", this.recipeService.findById(id)));
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


//    @RequestMapping(value="/add", params={"addRow"})
//    public String addRow(final RecipeIngredientAddForm recipeIngredientAddForm, final BindingResult bindingResult) {
//        recipeIngredientAddForm.getRows().add(new Row());
//        return "recipes";
//    }
//
//    @RequestMapping(value="/recipes", params={"removeRow"})
//    public String removeRow(
//            final RecipeIngredientAddForm recipeIngredientAddForm, final BindingResult bindingResult,
//            final HttpServletRequest req) {
//        final Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
//        recipeIngredientAddForm.getRows().remove(rowId.intValue());
//        return "recipes";
//    }

}
