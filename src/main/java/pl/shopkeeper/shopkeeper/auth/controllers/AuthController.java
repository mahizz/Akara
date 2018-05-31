package pl.shopkeeper.shopkeeper.auth.controllers;


import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.shopkeeper.shopkeeper.auth.models.AppUser;
import pl.shopkeeper.shopkeeper.auth.services.UserService;

@RestController
public class AuthController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private UserService userService;

    public AuthController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping("/user-test")
    public List<AppUser> newUser(@RequestParam(value="name", defaultValue="noname") String name){

        AppUser user = new AppUser();

        user.setName(name);

        this.userService.addUser(user);

        return this.userService.getAllUsers();
    }

    @RequestMapping("/auth")
    public String test(){

        return "test";
    }


}