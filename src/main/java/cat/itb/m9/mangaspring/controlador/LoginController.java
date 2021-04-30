package cat.itb.m9.mangaspring.controlador;


import cat.itb.m9.mangaspring.model.entitat.UserManga;
import cat.itb.m9.mangaspring.model.servei.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class LoginController {

    @Autowired
    private UserService service;

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        model.addAttribute("user", new UserManga());
        return "register";
    }
    @PostMapping("/registration")
    public String addUser(@ModelAttribute("user") UserManga e){
        e.setRol("USER");
        service.afegir(e);
        return "redirect:/";

    }
}
