package pl.shopkeeper.shopkeeper.users.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.shopkeeper.shopkeeper.users.models.AppUser;
import pl.shopkeeper.shopkeeper.users.repository.UserRepository;


import java.util.List;

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