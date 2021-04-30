package cat.itb.m9.mangaspring.model.entitat;

import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserManga {

    @Id
    private String username;
    private String password;
    private String rol;

    public UserManga(String user, String pwd) {
        username=user;
        password=pwd;
        rol="USER";
    }
}
