package bg.tuplovdiv.cookingrecipes.repositories;

import bg.tuplovdiv.cookingrecipes.domain.entities.NutritionFact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutritionFactRepository extends JpaRepository<NutritionFact, Long> {
}
