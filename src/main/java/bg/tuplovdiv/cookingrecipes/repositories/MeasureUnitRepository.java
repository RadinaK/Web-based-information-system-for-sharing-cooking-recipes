package bg.tuplovdiv.cookingrecipes.repositories;

import bg.tuplovdiv.cookingrecipes.domain.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MeasureUnitRepository extends JpaRepository<MeasureUnit, String> {

    Optional<MeasureUnit> findByType(MeasureUnit type);

}

