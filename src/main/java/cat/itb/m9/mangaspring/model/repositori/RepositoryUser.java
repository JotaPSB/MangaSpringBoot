package cat.itb.m9.mangaspring.model.repositori;

import cat.itb.m9.mangaspring.model.entitat.UserManga;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryUser extends CrudRepository<UserManga, String> {
}
