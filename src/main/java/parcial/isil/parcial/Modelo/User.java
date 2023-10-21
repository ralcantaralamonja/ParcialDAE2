package parcial.isil.parcial.Modelo;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table( name="tbl_usuario")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    @NotNull
    private String nombres;
    @NotBlank
    @NotNull
    private String  apellido_paterno;
    @NotBlank
    @NotNull
    private String apellido_materno;
    @Column(unique = true)
    @NotBlank
    @NotNull
    private String correo_electronico;
    @NotBlank
    @NotNull
    private String contrasena;
}
