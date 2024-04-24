package mx.edu.utez.extra.controllers;

import jakarta.validation.Valid;
import mx.edu.utez.extra.dtos.UserDto;
import mx.edu.utez.extra.models.User;
import mx.edu.utez.extra.services.UserService;
import mx.edu.utez.extra.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/")
@CrossOrigin(origins = {"*"})
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<User>>> getAll(){
        return new ResponseEntity<>(
                this.userService.getAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/adult/{id}")
    public ResponseEntity<CustomResponse<User>> getOne(@PathVariable Long id){
        return new ResponseEntity<>(
                this.userService.getById(id),
                HttpStatus.OK
        );
    }

    @GetMapping("/adultOne/{id}")
    public ResponseEntity<CustomResponse<User>> getOneAdult(@PathVariable Long id){
        return new ResponseEntity<>(
                this.userService.getOneAdult(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<CustomResponse<User>> insert(UserDto dto, @Valid BindingResult result){
        if (result.hasErrors()){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        CustomResponse<User> response = this.userService.save(dto.getUser());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/over18")
    public ResponseEntity<CustomResponse<List<User>>> getUsersOver18() {
        CustomResponse<List<User>> response = userService.getUsersOver18();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
