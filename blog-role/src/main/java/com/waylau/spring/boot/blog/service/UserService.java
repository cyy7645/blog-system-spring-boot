package com.waylau.spring.boot.blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.waylau.spring.boot.blog.domain.User;

public interface UserService {
	 /**
     * Add, edit, save users
     * @param user
     * @return
     */
    User saveOrUpateUser(User user);

    /**
     * registered user
     * @param user
     * @return
     */
    User registerUser(User user);

    /**
     * delete users
     * @param user
     * @return
     */
    void removeUser(Long id);

    /**
     * Get users based on id
     * @param user
     * @return
     */
    User getUserById(Long id);

    /**
     * Paging fuzzy query based on user name
     * @param user
     * @return
     */
    Page<User> listUsersByNameLike(String name, Pageable pageable);
}