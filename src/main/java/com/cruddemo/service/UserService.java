package com.cruddemo.service;

import com.cruddemo.model.UserBO;
import com.cruddemo.persistence.UserDto;
import com.cruddemo.persistence.UserRepository;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ObjectFactory<WeatherService> objectFactory;

    public UserDto getUser(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public List<UserDto> getAllUsers() {
        return (List<UserDto>) userRepository.findAll();
    }

    public UserDto updateUser(UserDto userDtoRq) {
        UserDto dto = userRepository.findById(userDtoRq.getId()).orElseThrow();
        dto.setFirstName(userDtoRq.getFirstName());
        dto.setLastName(userDtoRq.getLastName());
        dto.setEmail(userDtoRq.getEmail());
        return userRepository.save(dto);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    public UserDto createUser(UserBO userBO) {
        UserDto userDto = new UserDto();
        userDto.setFirstName(userBO.getFirstName());
        userDto.setLastName(userBO.getLastName());
        userDto.setEmail(userBO.getEmail());
        return userRepository.save(userDto);
    }

    public String getWeatherInfoFromWeatherAPI() {
        return getWeatherServiceBean().getTodaysWeatherInfo();
    }

    @Lookup
    public WeatherService getWeatherServiceBean(){
        return null;
    }
}