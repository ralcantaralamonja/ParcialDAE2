package parcial.isil.parcial.Reposotorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import parcial.isil.parcial.Modelo.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
