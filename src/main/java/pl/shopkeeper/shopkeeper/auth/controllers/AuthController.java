package pl.shopkeeper.shopkeeper.auth.controllers;


import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.shopkeeper.shopkeeper.auth.models.AuthUser;
import pl.shopkeeper.shopkeeper.auth.services.AuthService;

@RestController
public class AuthController {

    private final AtomicLong counter = new AtomicLong();

    private AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @RequestMapping("/user-test")
    public List<AuthUser> newUser(@RequestParam(value="username", defaultValue="noname") String name){

        AuthUser user = new AuthUser();

        user.setUsername(name);

        this.authService.addUser(user);

        return this.authService.getAllUsers();
    }

    @RequestMapping("/auth")
    public String test(){

        return "test";
    }


}