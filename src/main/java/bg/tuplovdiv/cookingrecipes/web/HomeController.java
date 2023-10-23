package bg.tuplovdiv.cookingrecipes.web;

import bg.tuplovdiv.cookingrecipes.services.RecipeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/") // localhost:8000/ -> all types of requests
public class HomeController extends BaseController {

    private static final String USERNAME_SESSION_KEY = "username";
    private final RecipeService recipeService;

    @Autowired
    public HomeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping // localhost:8000 -> get request
    public ModelAndView getHome(ModelAndView modelAndView, HttpSession httpSession) {
        final String username = httpSession.getAttribute(USERNAME_SESSION_KEY) != null
                ? httpSession.getAttribute(USERNAME_SESSION_KEY).toString()
                : "";

//        final RoutePartialViewModel mostCommented = routeService.getMostCommented();
//
//        modelAndView.addObject("mostCommented", mostCommented);
        modelAndView.addObject(USERNAME_SESSION_KEY, username);

        return super.view("index", modelAndView);
    }
}
