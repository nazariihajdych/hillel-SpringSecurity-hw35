package ua.hillel.springsecurityapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.hillel.springsecurityapp.model.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByName(String name);
}
