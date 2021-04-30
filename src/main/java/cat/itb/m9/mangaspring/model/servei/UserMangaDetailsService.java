package cat.itb.m9.mangaspring.model.servei;

import cat.itb.m9.mangaspring.model.entitat.UserManga;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserMangaDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserManga u= userService.consultaPerId(s);
        User.UserBuilder builder;
        if(u!=null){
            builder=User.withUsername(s);
            builder.disabled(false);
            builder.password(u.getPassword());
            builder.roles(u.getRol());
        }
        else throw new UsernameNotFoundException("User Not Found");
        return builder.build();
    }

}
