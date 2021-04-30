package cat.itb.m9.mangaspring.model.entitat;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Manga {
    @Id
    @NotNull
    private String id;
    @NotNull
    private String name;
    @NotNull
    private String author;
    @NotNull
    private int numCaps;

}
