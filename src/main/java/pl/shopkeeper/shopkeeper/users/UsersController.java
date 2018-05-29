package pl.shopkeeper.shopkeeper.users;


import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greetings")
    public Users greeting(@RequestParam(value="name", defaultValue="OLfpplihb") String name) {
        return new Users(counter.incrementAndGet(),
                String.format(template, name));
    }
}
