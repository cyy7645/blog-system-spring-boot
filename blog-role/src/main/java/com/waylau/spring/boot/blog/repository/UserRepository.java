package com.waylau.spring.boot.blog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.waylau.spring.boot.blog.domain.User;


public interface UserRepository extends JpaRepository<User, Long>{
    /**
     * Query user list based on user name
     * @param name
     * @param pageable
     * @return
     */
    Page<User> findByNameLike(String name, Pageable pageable);

    /**
     * Query users based on user accounts
     * @param username
     * @return
     */
    User findByUsername(String username);
}
