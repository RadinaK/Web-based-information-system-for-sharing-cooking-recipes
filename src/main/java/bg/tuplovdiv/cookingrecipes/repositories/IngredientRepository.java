package bg.tuplovdiv.cookingrecipes.repositories;

import bg.tuplovdiv.cookingrecipes.domain.models.ingredients.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
//    @Query("SELECT new bg.softuni.modelmapper.entities.dtos.EmployeeNamesDTO(e.firstName, e.lastName)" +
//            " FROM Employee AS e WHERE e.id = :id")
//    EmployeeNamesDTO findNamesById(long id);
//
//    EmployeeNameAndSalaryDTO findFirstNameAndSalaryById(long id);
}
