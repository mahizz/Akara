package pl.shopkeeper.shopkeeper.users.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.shopkeeper.shopkeeper.users.models.AppUser;
import pl.shopkeeper.shopkeeper.users.repository.UserRepository;
import pl.shopkeeper.shopkeeper.users.services.UserService;

import java.util.List;

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

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody AppUser signUp(@RequestBody AppUser user) {
        user.setPasswd(bCryptPasswordEncoder.encode(user.getPasswd()));
        userService.addUser(user);
        return user;
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<AppUser> getAll() {
        return (userService.getAllUsers());
    }
}
