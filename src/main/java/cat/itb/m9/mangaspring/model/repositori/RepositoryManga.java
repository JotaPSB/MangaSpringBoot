package cat.itb.m9.mangaspring.model.repositori;

import cat.itb.m9.mangaspring.model.entitat.Manga;
import org.hibernate.engine.spi.Managed;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryManga extends CrudRepository<Manga, String> {
}
