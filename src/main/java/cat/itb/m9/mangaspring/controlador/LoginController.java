package cat.itb.m9.mangaspring.controlador;


import cat.itb.m9.mangaspring.model.entitat.UserManga;
import cat.itb.m9.mangaspring.model.servei.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;

@Controller
public class LoginController {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

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
    public String addUser(@Valid @ModelAttribute("user") UserManga e, BindingResult result){

        if(service.userExists(e.getUsername())){
            result.addError(new FieldError("user", "username", "Username already exists"));
        }
        if(!service.passwordLength(e.getPassword())){
            result.addError(new FieldError("user", "password", "Password must have more than 8 characters"));
        }

        if(result.hasErrors()){
            return "register";
        }

        e.setRol("USER");
        service.afegir(e);
        return "redirect:/";

    }
}
