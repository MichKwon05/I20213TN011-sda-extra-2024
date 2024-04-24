package mx.edu.utez.extra.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import mx.edu.utez.extra.models.User;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private Long id;
    @NotEmpty(message = "Nombre no puede estar en blanco")
    @Size(max = 30, message = "Nombre máx 30 caracteres")
    private String username;
    @NotEmpty(message = "Appellidos no puede estar en blanco")
    @Size(max = 30, message = "apellidos máx 30 caracteres")
    private String lastname;
    @NotEmpty(message = "El email no puede estar en blanco")
    @Size(max = 50, message = "correo máx 50 caracteres")
    private String email;
    private LocalDate birthday;
    @NotEmpty(message = "La contraseña no puede estar en blanco")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    private String password;

    public User getUser(){
        return new User(
                getId(),
                getUsername(),
                getLastname(),
                getEmail(),
                getBirthday(),
                getPassword()
        );
    }
}
