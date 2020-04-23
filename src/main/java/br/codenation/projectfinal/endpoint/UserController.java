package br.codenation.projectfinal.endpoint;

import br.codenation.projectfinal.model.User;
import br.codenation.projectfinal.service.UserServiceImpl;
import br.codenation.projectfinal.util.FormatAndConvertDateToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/v1.0")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id).orElse(null);
    }

    @GetMapping("/user")
    public List<User> findAll() {
        return userService.findAll();
    }

    /*@PostMapping("/user")
    public ResponseEntity<User> save(@Valid @RequestBody User user){
        User userSaved = userService.save(user);
        return new ResponseEntity<>(userSaved, HttpStatus.CREATED);
    }*/

}
