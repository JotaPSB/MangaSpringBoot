package cat.itb.m9.mangaspring.model.entitat;

//import jdk.jfr.Enabled;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserManga {


    @Id
    @NotEmpty(message = "Enter your username")
    private String username;
    @NotEmpty(message = "Enter your password")
    @Size(min = 8)
    private String password;
    private String rol;

    public UserManga(String user, String pwd) {
        username=user;
        password=pwd;
        rol="USER";
    }
}
