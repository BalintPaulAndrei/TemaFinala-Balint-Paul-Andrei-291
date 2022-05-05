package finalpcj.user.service;

import finalpcj.user.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    Optional<User> findById(String id);
    User save (User user);
    void delete (User user);
}
