package diseases.history.DHapplication.IntegrationLayer;

import diseases.history.DHapplication.Objects.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    Optional<User> findByUserName(String userName);

}
