package bg.tuplovdiv.cookingrecipes.services;

import bg.tuplovdiv.cookingrecipes.domain.dtoS.banding.RecipeAddForm;
import bg.tuplovdiv.cookingrecipes.domain.dtoS.banding.RecipeIngredientAddForm;
import bg.tuplovdiv.cookingrecipes.domain.dtoS.model.RecipeModel;
import bg.tuplovdiv.cookingrecipes.domain.dtoS.veiw.RecipePartialViewModel;
import bg.tuplovdiv.cookingrecipes.domain.entities.*;
import bg.tuplovdiv.cookingrecipes.domain.enums.NameCategory;
import bg.tuplovdiv.cookingrecipes.helpers.LoggedUser;
import bg.tuplovdiv.cookingrecipes.repositories.PictureRepository;
import bg.tuplovdiv.cookingrecipes.repositories.RecipeIngredientRepository;
import bg.tuplovdiv.cookingrecipes.repositories.RecipeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class RecipeService  {
    private final RecipeRepository recipeRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final LoggedUser loggedUser;
    private final RecipeIngredientService recipeIngredientService;
    private final IngredientService ingredientService;

    private final PictureRepository pictureRepository;

    private final RecipeIngredientRepository recipeIngredientRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository, ModelMapper modelMapper, UserService userService, LoggedUser loggedUser, RecipeIngredientService recipeIngredientService, IngredientService ingredientService, PictureRepository pictureRepository, RecipeIngredientRepository recipeIngredientRepository) {
        this.recipeRepository = recipeRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.loggedUser = loggedUser;
        this.recipeIngredientService = recipeIngredientService;
        this.ingredientService = ingredientService;
        this.pictureRepository = pictureRepository;
        this.recipeIngredientRepository = recipeIngredientRepository;
    }


    public RecipeModel findByTitle(String title) {
        return this.modelMapper.map(this.recipeRepository.findByTitle(title), RecipeModel.class);
    }

    public RecipeModel findByNameCategory(NameCategory nameCategory) {
        return this.modelMapper.map(this.recipeRepository.findByNameCategory(nameCategory), RecipeModel.class);
    }

    public List<RecipePartialViewModel> getAllRecipesPartialViews() {
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

    //Without saving recipeIngredient
//    public void addNewRecipe(RecipeAddForm recipeAddForm) throws IOException {
//        Recipe recipe = this.modelMapper.map(recipeAddForm, Recipe.class);
//        MultipartFile picture = recipeAddForm.getPhoto();
//        Picture pictureModel = new Picture();
//        pictureModel.setRecipe(recipe);
//        HashSet pictures = new HashSet<Picture>();
//        // Handle saving the photo to a local folder (replace "path/to/your/upload/directory/")
//        if (picture != null && !picture.isEmpty()) {
//            pictureModel.setPictureBytes(picture.getBytes());
//            pictureModel.setMimeType(picture.getContentType());
//            pictures.add(pictureModel);
//            recipe.setPictures(pictures);
//        } else {
//            pictureModel.setPictureBytes(this.getClass().getClassLoader()
//                        .getResourceAsStream("static/images/recipe-placeholder.jpg").readAllBytes());
//            pictureModel.setMimeType("image/jpeg");
//            pictures.add(pictureModel);
//            recipe.setPictures(pictures);
//        }
//
//        recipe
//                .setCook(this.modelMapper
//                        .map(this.userService
//                                        .findByUsername(this.loggedUser.getUsername()),
//                                User.class));
//
//        this.recipeRepository.saveAndFlush(recipe);
//        this.pictureRepository.saveAndFlush(pictureModel);
//    }


    public void addNewRecipe(RecipeAddForm recipeAddForm) throws IOException {
        Recipe recipe = this.modelMapper.map(recipeAddForm, Recipe.class);
        MultipartFile picture = recipeAddForm.getPhoto();
        Picture pictureModel = new Picture();
        pictureModel.setRecipe(recipe);
        HashSet pictures = new HashSet<Picture>();
        // Handle saving the photo to a local folder (replace "path/to/your/upload/directory/")
        if (picture != null && !picture.isEmpty()) {
            pictureModel.setPictureBytes(picture.getBytes());
            pictureModel.setMimeType(picture.getContentType());
            pictures.add(pictureModel);
            recipe.setPictures(pictures);
        } else {
            pictureModel.setPictureBytes(this.getClass().getClassLoader()
                    .getResourceAsStream("static/images/recipe-placeholder.jpg").readAllBytes());
            pictureModel.setMimeType("image/jpeg");
            pictures.add(pictureModel);
            recipe.setPictures(pictures);
        }

        recipe
                .setCook(this.modelMapper
                        .map(this.userService
                                        .findByUsername(this.loggedUser.getUsername()),
                                User.class));

        this.recipeRepository.saveAndFlush(recipe);
        this.pictureRepository.saveAndFlush(pictureModel);
    }


    //TODO: refactoring
    public RecipeAddForm addIngredient(RecipeAddForm recipeAddForm, RecipeIngredientAddForm newIngredient) {
        recipeAddForm.getRecipeIngredientList().add(newIngredient);
        return recipeAddForm;
    }

    //TODO: refactoring
    public RecipeAddForm removeIngredient(RecipeAddForm recipeAddForm, int index) {
        if (index >= 0 && index < recipeAddForm.getRecipeIngredientList().size()) {
            recipeAddForm.getRecipeIngredientList().remove(index);
        }
        return recipeAddForm;
    }




}
