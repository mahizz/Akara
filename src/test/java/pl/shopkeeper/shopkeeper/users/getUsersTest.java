package pl.shopkeeper.shopkeeper.users;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import pl.shopkeeper.shopkeeper.users.models.AppUser;
import pl.shopkeeper.shopkeeper.users.repository.UserRepository;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)

public class getUsersTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenFindByName_thenReturnUser() {

        String name = "testowy";
        // when
        AppUser found = userRepository.findByUsername(name);

        // then
        assertEquals(found.getUsername(), name);
    }

}

