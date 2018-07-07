package pl.shopkeeper.shopkeeper.auth.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.shopkeeper.shopkeeper.auth.models.AppUser;
import pl.shopkeeper.shopkeeper.auth.repository.AuthRepository;

@Service
@Transactional
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    @Transactional(readOnly = true)
    public List<AppUser> getAllUsers() {
        return authRepository.findAll();
    }

    public void addUser(AppUser user) {
        authRepository.save(user);
    }
}