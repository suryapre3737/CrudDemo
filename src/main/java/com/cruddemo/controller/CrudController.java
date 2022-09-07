package com.cruddemo.controller;

import com.cruddemo.service.UserService;
import com.cruddemo.model.UserBO;
import com.cruddemo.persistence.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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

    @GetMapping(path = "weather_info")
    public Object getWeatherInfo() throws InterruptedException {
        String response1 = userService.getWeatherInfoFromWeatherAPI();
        Thread.sleep(1000);
        String response2 = userService.getWeatherInfoFromWeatherAPI();
        return Arrays.asList(response1,response2);
    }

}
