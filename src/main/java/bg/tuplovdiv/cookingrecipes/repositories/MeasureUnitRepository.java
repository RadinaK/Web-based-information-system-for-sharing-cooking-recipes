package bg.tuplovdiv.cookingrecipes.repositories;

import bg.tuplovdiv.cookingrecipes.domain.entities.MeasureUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasureUnitRepository extends JpaRepository<MeasureUnit, Long> {
}
