package cat.itb.m9.mangaspring.model.servei;

import cat.itb.m9.mangaspring.model.entitat.Manga;
import cat.itb.m9.mangaspring.model.entitat.UserManga;
import cat.itb.m9.mangaspring.model.repositori.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private RepositoryUser repositoryUser;

    public void afegir(UserManga e) {

        e.setPassword(passwordEncoder(e.getPassword()));
        repositoryUser.save(e);
    }
    public List<UserManga> list() {
        List<UserManga> listado = new ArrayList<>();
        repositoryUser.findAll().iterator().forEachRemaining(listado::add);
        return listado;
    }

    @PostConstruct
    public void init() {
        repositoryUser.save(new UserManga("jota", passwordEncoder("pipo")));
        repositoryUser.save(new UserManga("guest", passwordEncoder("hola")));
        repositoryUser.save(new UserManga("ADMIN", passwordEncoder("admin1234"),"ADMIN"));

    }


    public UserManga consultaPerId(String s) {
        return  repositoryUser.findById(s).orElse(null);
    }

    public boolean userExists(String username){
        for (UserManga u: list()
             ) {
            if(u.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
    public boolean passwordLength(String s){
        if(s.length()>=8){
            return true;
        }
        return false;
    }


    public String passwordEncoder(String s) {
        return new BCryptPasswordEncoder().encode(s);
    }

}
