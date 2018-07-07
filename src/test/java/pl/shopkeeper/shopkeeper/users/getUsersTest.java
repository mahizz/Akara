package pl.shopkeeper.shopkeeper.users;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import pl.shopkeeper.shopkeeper.auth.models.AppUser;
import pl.shopkeeper.shopkeeper.auth.repository.AuthRepository;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)

public class getUsersTest {

    @Autowired
    private AuthRepository authRepository;

    @Test
    public void whenFindByName_thenReturnUser() {

        String name = "name";
        // when
        AppUser found = authRepository.findByUsername(name);

        // then
        assertEquals(found.getUsername(), name);
    }

}

