package bg.tuplovdiv.cookingrecipes.web;

import bg.tuplovdiv.cookingrecipes.domain.dtoS.banding.RecipeAddForm;
import bg.tuplovdiv.cookingrecipes.domain.dtoS.banding.RecipeIngredientAddForm;
import bg.tuplovdiv.cookingrecipes.domain.entities.Ingredient;
import bg.tuplovdiv.cookingrecipes.domain.entities.MeasureUnit;
import bg.tuplovdiv.cookingrecipes.domain.entities.Recipe;
import bg.tuplovdiv.cookingrecipes.domain.entities.RecipeIngredient;
import bg.tuplovdiv.cookingrecipes.helpers.LoggedUser;
import bg.tuplovdiv.cookingrecipes.repositories.IngredientRepository;
import bg.tuplovdiv.cookingrecipes.repositories.MeasureUnitRepository;
import bg.tuplovdiv.cookingrecipes.repositories.RecipeIngredientRepository;
import bg.tuplovdiv.cookingrecipes.services.RecipeService;
import bg.tuplovdiv.cookingrecipes.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/recipes")
public class RecipeController extends BaseController {
    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @Autowired
    private MeasureUnitRepository measureUnitRepository;

    @Autowired
    private IngredientRepository ingredientRepository;


    @GetMapping
    public ModelAndView getAllRecipes(ModelAndView modelAndView) {


        return super.view("recipes",
                modelAndView.addObject("recipes", this.recipeService.getAllRecipesPartialViews()));
    }

    @GetMapping("/{id}")
    public ModelAndView getById(@PathVariable Long id,
                                ModelAndView modelAndView) {
        List<Ingredient> ingredientList = ingredientRepository.findAll();
        List<MeasureUnit> measureUnitList = measureUnitRepository.findAll();

        modelAndView.addObject("ingredientList", ingredientList);
        modelAndView.addObject("measureUnitList", measureUnitList);
        return super.view("recipe-details",
                modelAndView.addObject("recipe", this.recipeService.findById(id)));
    }

    @RequestMapping(value="/add")
    public ModelAndView getAdd(ModelAndView modelAndView) {

        List<Ingredient> ingredientList = ingredientRepository.findAll();
        List<MeasureUnit> measureUnitList = measureUnitRepository.findAll();

        modelAndView.addObject("ingredientList", ingredientList);
        modelAndView.addObject("measureUnitList", measureUnitList);
        modelAndView.addObject("recipeAddForm", new RecipeAddForm());

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

    @RequestMapping(value="/add", params={"addRow"})
    public ModelAndView addRow(final RecipeAddForm recipeAddForm, final BindingResult bindingResult,
                         ModelAndView modelAndView) {

        List<Ingredient> ingredientList = ingredientRepository.findAll();
        List<MeasureUnit> measureUnitList = measureUnitRepository.findAll();

        modelAndView.addObject("ingredientList", ingredientList);
        modelAndView.addObject("measureUnitList", measureUnitList);
        modelAndView.addObject("recipeAddForm",recipeAddForm);
        recipeAddForm.getRecipeIngredientList().add(new RecipeIngredientAddForm());
        return super.view("add-recipe", modelAndView);
    }

    @RequestMapping(value="/add", params={"removeRow"})
    public ModelAndView removeRow(
            final RecipeAddForm recipeAddForm, final BindingResult bindingResult,
            final HttpServletRequest req, ModelAndView modelAndView) {

        List<Ingredient> ingredientList = ingredientRepository.findAll();
        List<MeasureUnit> measureUnitList = measureUnitRepository.findAll();

        modelAndView.addObject("ingredientList", ingredientList);
        modelAndView.addObject("measureUnitList", measureUnitList);
        modelAndView.addObject("recipeAddForm", new RecipeAddForm());
        final Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
        recipeAddForm.getRecipeIngredientList().remove(rowId.intValue());
        return super.view("add-recipe", modelAndView);
    }

//    @RequestMapping(value="/seedstartermng", params={"addRow"})
//    public String addRow(final SeedStarter seedStarter, final BindingResult bindingResult) {
//        seedStarter.getRows().add(new Row());
//        return "seedstartermng";
//    }
//
//    @RequestMapping(value="/seedstartermng", params={"removeRow"})
//    public String removeRow(
//            final SeedStarter seedStarter, final BindingResult bindingResult,
//            final HttpServletRequest req) {
//        final Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
//        seedStarter.getRows().remove(rowId.intValue());



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

    //TODO: Handle form submission
//    @PostMapping("/submitRecipe")
    @PostMapping("/submitRecipeIngredients")
    public String submitRecipe(@ModelAttribute RecipeAddForm recipeAddForm) {
        // Process the form data, save to the database, etc.
        return "redirect:/recipeList"; // Redirect to the recipe list page or another appropriate page.
    }

    //TODO: Handle adding an ingredient. Model instead ModelAndView -> addAttribute instead addObject
    @PostMapping("/addRecipeIngredient")
    public String addIngredient(@ModelAttribute RecipeAddForm recipeAddForm, Model model) {
        RecipeIngredientAddForm newIngredient = new RecipeIngredientAddForm();
        recipeAddForm = recipeService.addIngredient(recipeAddForm, newIngredient);
        model.addAttribute("recipeAddForm", recipeAddForm);
        return "recipe-form :: recipes_ingredients"; // Return a Thymeleaf fragment or use AJAX to update the UI.
    }

    //TODO: Handle removing an ingredient
    @GetMapping("/removeIngredient/{index}")
    public String removeIngredient(@ModelAttribute RecipeAddForm recipeAddForm, @PathVariable int index, Model model) {
        recipeAddForm = recipeService.removeIngredient(recipeAddForm, index);
        model.addAttribute("recipeAddForm", recipeAddForm);
        return "recipe-form :: recipes_ingredients"; // Return a Thymeleaf fragment or use AJAX to update the UI.
    }
}
