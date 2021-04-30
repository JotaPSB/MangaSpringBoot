package cat.itb.m9.mangaspring.controlador;

import cat.itb.m9.mangaspring.model.entitat.Manga;
import cat.itb.m9.mangaspring.model.servei.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControladorManga {
    int id;
    @Autowired
    private MangaService service;

    @GetMapping("manga/list")
    public String list(Model m){
        m.addAttribute("listManga", service.list());
        return "list";
    }
    @GetMapping("/manga/new")
    public String afegirManga(Model m){
        m.addAttribute("mangaForm",new Manga());
        return "afegir";
    }
    @PostMapping("/manga/new/submit")

    public String afegirSubmit(@ModelAttribute("mangaForm") Manga m){
        service.add(m);
        return "redirect:/manga/list";
    }
    @RequestMapping( value ="/manga/delete/{mangaID}", method = RequestMethod.POST)
    public String deleteManga(@PathVariable("mangaID") String id){
        service.removeManga(id);
        return "redirect:/manga/list";
    }

    @RequestMapping(value = "/manga/update/{id}", method  = RequestMethod.POST)
    public String updateManga(@PathVariable("id") String id, Model m){
        m.addAttribute("Manga", service.getManga(id));
        return "updateManga";
    }
    @PostMapping("/manga/updateManga")
    public String updateMangaPost(@ModelAttribute("Manga") Manga m){
        service.updateManga(m);
        return "redirect:list";
    }



}
