package com.waylau.spring.boot.blog.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity 
public class User implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id // primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY) // self increasing
	private Long id; 

    @NotEmpty(message = "Name cannot be empty")
    @Size(min=2, max=20)
    @Column(nullable = false, length = 20)
    private String name;

    @NotEmpty(message = "Email cannot be empty")
    @Size(max=50)
    @Email(message= "The mailbox format is incorrect." ) 
    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @NotEmpty(message = "Account cannot be empty")
    @Size(min=3, max=20)
    @Column(nullable = false, length = 20, unique = true)
    private String username; // User account, unique identifier when the user logs in

    @NotEmpty(message = "password can not be blank")
    @Size(max=100)
    @Column(length = 100)
    private String password; 

    @Column(length = 200)
    private String avatar;
	
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private List<Authority> authorities;
    
	protected User() { 
	}
	
	public User(Long id, String name, String username, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.username = username;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Override
	public String toString() {
		return String.format("User[id=%d,name='%s',username='%s',email='%s']", id, name, username, email);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        //  需将 List<Authority> 转成 List<SimpleGrantedAuthority>，否则前端拿不到角色列表名称
        List<SimpleGrantedAuthority> simpleAuthorities = new ArrayList<>();
        for(GrantedAuthority authority : this.authorities){
            simpleAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
        }
        return simpleAuthorities;
	}

	public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
