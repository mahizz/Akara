package pl.shopkeeper.shopkeeper.auth.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import pl.shopkeeper.shopkeeper.auth.models.AppUser;

/**
 * User: Quinten
 * Date: 29-4-2014
 * Time: 17:04
 *
 * @author Quinten De Swaef
 */

public interface UserRepository extends JpaRepository<AppUser, Long>{

    AppUser findByNameAndPasswd
            (
                @Param("name") String name,
                @Param("passwd") String passwd
            );

    AppUser findByName(
                @Param("name") String name
            );
}