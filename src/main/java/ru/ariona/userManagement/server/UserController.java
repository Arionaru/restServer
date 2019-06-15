package ru.ariona.userManagement.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/userlist")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public Iterable<User> getUserList() {
        return userRepo.findAll();
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable Long id) {
        Optional<User> optionalUser = userRepo.findById(id);
        if (!optionalUser.isPresent()) {
            throw new RuntimeException();
        }
        return optionalUser.get();

    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        System.out.println("rere");
        userRepo.save(user);
        return user;
    }

    @PutMapping("{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        Optional<User> optionalUser = userRepo.findById(id);
        if (!optionalUser.isPresent()) {
            throw new RuntimeException("Not Found");
        }
        User userFromDB = optionalUser.get();
        userFromDB.setFirstName(user.getFirstName());
        userFromDB.setLastName(user.getLastName());
        userFromDB.setBirthDate(user.getBirthDate());
        userFromDB.setAboutMe(user.getAboutMe());
        userRepo.save(userFromDB);
        return userFromDB;
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Long id){
        userRepo.deleteById(id);
    }

}
