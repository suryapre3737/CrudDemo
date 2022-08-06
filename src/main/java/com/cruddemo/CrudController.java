package com.cruddemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class CrudController {

    @Autowired
    UserService userService;

    @GetMapping
    public UserDto getUser(@RequestParam(name = "id") long id){
        return userService.getUser(id);
    }

    @GetMapping(path = "all")
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserBO userBO){
        return userService.createUser(userBO);
    }

    @PutMapping
    public UserDto updateUser(@RequestBody UserDto userDtoRq){
        return userService.updateUser(userDtoRq);
    }

    @DeleteMapping
    public String deleteUser(@RequestParam(name = "id") long id){
        userService.deleteUser(id);
        return "User deleted successfully having ID : "+id;
    }


}
