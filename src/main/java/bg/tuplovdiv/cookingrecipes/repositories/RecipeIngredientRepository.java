package bg.tuplovdiv.cookingrecipes.repositories;

import bg.tuplovdiv.cookingrecipes.domain.entities.Ingredient;
import bg.tuplovdiv.cookingrecipes.domain.entities.MeasureUnit;
import bg.tuplovdiv.cookingrecipes.domain.entities.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipeIngredientRepository  extends JpaRepository<RecipeIngredient, Long> {

    Optional<RecipeIngredient> findByIngredient(Ingredient ingredient);
    Optional<RecipeIngredient> findByMeasureUnit(MeasureUnit measureUnit);

//    Optional<RecipeIngredient> findAll(RecipeIngredient recipeIngredient);
}
