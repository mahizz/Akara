package pl.shopkeeper.shopkeeper.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pl.shopkeeper.shopkeeper.auth.models.AuthUser;
import pl.shopkeeper.shopkeeper.auth.repository.AuthRepository;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser authUser = authRepository.findByUsername(username);
        if (authUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(authUser.getUsername(), authUser.getPasswd(), emptyList());
    }
}