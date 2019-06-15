package ru.ariona.userManagement.server;

import org.springframework.data.repository.CrudRepository;
import ru.ariona.userManagement.server.User;

public interface UserRepo extends CrudRepository<User, Long> {
}
