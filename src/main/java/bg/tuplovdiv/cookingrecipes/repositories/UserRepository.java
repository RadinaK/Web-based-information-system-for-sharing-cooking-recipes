package bg.tuplovdiv.cookingrecipes.repositories;

import bg.tuplovdiv.cookingrecipes.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
