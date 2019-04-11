package com.waylau.spring.boot.blog.service;

import com.waylau.spring.boot.blog.domain.Authority;


public interface AuthorityService {
	/**
	 * get Authority bu ID
	 * @param id
	 * @return
	 */
    Authority getAuthorityById(Long id);
}
