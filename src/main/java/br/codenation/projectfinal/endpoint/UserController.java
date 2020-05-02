package br.codenation.projectfinal.endpoint;

import br.codenation.projectfinal.dto.UserDetailsDTO;
import br.codenation.projectfinal.error.ResourceNotFound;
import br.codenation.projectfinal.model.User;
import br.codenation.projectfinal.service.UserServiceImpl;
import br.codenation.projectfinal.util.FormatAndConvertDateToString;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/v1.0")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/user/{id}")
    @ApiOperation(value = "Returns user by ID")
    public UserDetailsDTO findById(@PathVariable("id") Long id) {
        User user = userService.findById(id).orElseThrow(()->new ResourceNotFound("User ID"+ id+ " not found"));
        return new UserDetailsDTO(user);
    }

    @GetMapping("/user")
    @ApiOperation(value = "Returns all users")
    public List<UserDetailsDTO> findAll() {
        List<User> users =  userService.findAll();
        return UserDetailsDTO.AsList(users);
    }

    @PostMapping("/user")
    @ApiOperation(value = "Save user")
    public ResponseEntity<UserDetailsDTO> save(@Valid @RequestBody User user){
        User userSaved = userService.save(user);
        return new ResponseEntity<>(new UserDetailsDTO(userSaved), HttpStatus.CREATED);
    }

    @DeleteMapping("/user/{id}")
    @ApiOperation(value="Delete user by id")
    public ResponseEntity<UserDetailsDTO> delete(@PathVariable("id") Long id){
        User userDeleted = userService.findById(id).orElseThrow(()->new ResourceNotFound("User ID "+id+" not found"));
        userService.delete(id);

        return new ResponseEntity<>(new UserDetailsDTO(userDeleted),HttpStatus.OK);
    }
}
