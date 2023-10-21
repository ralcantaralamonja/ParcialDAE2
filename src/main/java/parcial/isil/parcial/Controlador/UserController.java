package parcial.isil.parcial.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import parcial.isil.parcial.Modelo.User;
import parcial.isil.parcial.Reposotorio.UserRepository;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
@Autowired
    private UserRepository userRepository;
    @GetMapping("/")
    public String UserIndex(Model model) {
        List<User> user = userRepository.findAll();
        model.addAttribute("user", user);
        return "index";
    }
}
