package parcial.isil.parcial.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import parcial.isil.parcial.Modelo.User;
import parcial.isil.parcial.Reposotorio.UserRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
@Autowired
    private UserRepository userRepository;

@GetMapping("/")
    public  String UserIngreso(){
    return "Ingreso";
}
    @GetMapping("/registro")
    public String UserIndex() {
      return "registro";
    }

    @PostMapping("/crear")
    public String crearUsuario(
            RedirectAttributes redirectAttributes,
            @Valid @ModelAttribute User user,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "ingresarEstudiante";
        }

        try {
            userRepository.save(user);
            redirectAttributes.addFlashAttribute("exito", true);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", true);
            e.printStackTrace();
        }
        return "redirect:/Ingreso";
    }
//api rest
    @PostMapping("/api/crear")
    public ResponseEntity<String> crearUsuario(@Valid @RequestBody User user) {
        try {
            userRepository.save(user);
            return new ResponseEntity<>("Usuario creado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el usuario", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
