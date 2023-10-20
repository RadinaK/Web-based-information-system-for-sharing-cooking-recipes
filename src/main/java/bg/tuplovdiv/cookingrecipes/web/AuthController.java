package bg.tuplovdiv.cookingrecipes.web;

import bg.tuplovdiv.cookingrecipes.domain.dtoS.banding.UserLoginForm;
import bg.tuplovdiv.cookingrecipes.domain.dtoS.banding.UserRegisterForm;
import bg.tuplovdiv.cookingrecipes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/auth")
public class AuthController extends BaseController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public ModelAndView getRegister(ModelAndView modelAndView) {
        return super.view("register", modelAndView);
    }

    @PostMapping("/register")
    public ModelAndView doRegister(@Validated UserRegisterForm userRegisterForm,
                                   BindingResult bindingResult,
                                   ModelAndView modelAndView) {
        if (bindingResult.hasErrors()) {
            return super.view("register", modelAndView.addObject(userRegisterForm));
        }

        this.userService.registerUser(userRegisterForm);

        return super.redirect("register");
    }

    @GetMapping("/login")
    public ModelAndView getLogin() {
        return super.view("login");
    }

    @PostMapping("/login")
    public ModelAndView postLogin(@Validated UserLoginForm userLoginForm,
                                  BindingResult bindingResult,
                                  ModelAndView modelAndView) {

        if (bindingResult.hasErrors()) {
            return super.view("login", modelAndView.addObject(userLoginForm));
        }

        return this.userService.loginUser(userLoginForm).isValid()
                ? super.redirect("/")
                : super.redirect("login");
    }

    @GetMapping("/logout")
    public ModelAndView postLogout() {
        this.userService.logout();
        return super.redirect("/");
    }

    // Model Attributes
    @ModelAttribute("userRegisterForm")
    public UserRegisterForm initRegisterForm() {
        return new UserRegisterForm();
    }

    @ModelAttribute("userLoginForm")
    public UserLoginForm initLoginForm() {
        return new UserLoginForm();
    }
}