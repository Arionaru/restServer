package ru.ariona.userManagement.server;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> getUserById(Long id);

    void save(User user);

    void delete(Long id);

    List<User> getAll();
}
