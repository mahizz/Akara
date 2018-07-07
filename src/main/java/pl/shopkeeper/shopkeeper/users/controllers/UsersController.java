package pl.shopkeeper.shopkeeper.users.controllers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.shopkeeper.shopkeeper.users.models.AppUser;
import pl.shopkeeper.shopkeeper.users.repository.UserRepository;
import pl.shopkeeper.shopkeeper.users.services.UserService;

@RestController
@RequestMapping("/users")
public class UsersController {

    private UserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UsersController(UserService userService,
                           BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/add")
    public void signUp(@RequestBody AppUser user) {
        user.setPasswd(bCryptPasswordEncoder.encode(user.getPasswd()));
        userService.addUser(user);
    }
}
