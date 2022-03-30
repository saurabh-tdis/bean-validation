package com.app.repository;

import com.app.dto.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @Author saurabh vaish
 * @Date 27-03-2022
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
