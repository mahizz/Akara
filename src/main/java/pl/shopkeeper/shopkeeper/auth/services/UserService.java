package pl.shopkeeper.shopkeeper.auth.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.shopkeeper.shopkeeper.auth.models.AppUser;
import pl.shopkeeper.shopkeeper.auth.repository.UserRepository;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<AppUser> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(AppUser user) {
        userRepository.save(user);
    }
}