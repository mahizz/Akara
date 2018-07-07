package pl.shopkeeper.shopkeeper.auth.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import pl.shopkeeper.shopkeeper.auth.models.AuthUser;

/**
 * User: Quinten
 * Date: 29-4-2014
 * Time: 17:04
 *
 * @author Quinten De Swaef
 */

public interface AuthRepository extends JpaRepository<AuthUser, Long>{

    AuthUser findByUsernameAndPasswd
            (
                @Param("username") String username,
                @Param("passwd") String passwd
            );

    AuthUser findByUsername(
                @Param("username") String username
            );
}