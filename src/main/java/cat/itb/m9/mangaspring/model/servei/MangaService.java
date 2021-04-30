package cat.itb.m9.mangaspring.model.servei;

import cat.itb.m9.mangaspring.model.entitat.Manga;
import cat.itb.m9.mangaspring.model.repositori.RepositoryManga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MangaService {

    @Autowired
    private RepositoryManga repositoryManga;

    @PostConstruct
    public void init(){
        repositoryManga.save(new Manga("1","Jujutsu Kaisen","Gege Akutami",144));
        repositoryManga.save(new Manga("2", "Boku no Hero Academia", "Kohei Horikoshi", 307));
        repositoryManga.save(new Manga("3", "Aharen-san wa Hakarenai", "Mizu Asato", 95));
    }
    public void add(Manga m){
        repositoryManga.save(m);
    }
    public void removeManga(String id){
        repositoryManga.deleteById(id);
    }

    public void updateManga(Manga m){
        if(repositoryManga.existsById(m.getId())){
            repositoryManga.save(m);
        }
    }
    public Manga getManga(String id){
        return repositoryManga.findById(id).orElse(null);
    }
    public List<Manga> list(){
        List<Manga> listado = new ArrayList<>();
        repositoryManga.findAll().iterator().forEachRemaining(listado::add);
        return listado;
    }
}
