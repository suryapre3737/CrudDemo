package com.cruddemo.persistence;

import com.cruddemo.persistence.UserDto;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserDto, Long> {
}
