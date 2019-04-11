/**
 * 
 */
package com.waylau.spring.boot.blog.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;


@Entity
public class Authority implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // self increaseing
    private Long id;
    @Column(nullable = false) // cannot be null
    private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.GrantedAuthority#getAuthority()
	 */
	@Override
	public String getAuthority() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
