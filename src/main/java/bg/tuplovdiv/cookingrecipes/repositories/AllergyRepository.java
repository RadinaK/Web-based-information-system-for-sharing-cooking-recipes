package bg.tuplovdiv.cookingrecipes.repositories;

import bg.tuplovdiv.cookingrecipes.domain.entities.Allergy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllergyRepository extends JpaRepository<Allergy, Long> {
}
