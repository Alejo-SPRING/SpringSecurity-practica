package com.springSecurity.backEnd.app.web.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springSecurity.backEnd.app.web.model.entity.Roles;
import com.springSecurity.backEnd.app.web.model.entity.UserLogin;

@Service
public class UserJpaRegistryService implements UserDetailsService {

	@Autowired
	private IUserLoginService userLoginDao;
	@Autowired
	private IRolesService rolesDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserLogin user = userLoginDao.findByCorreo(username);
		List<Roles> roles = rolesDao.findAllRolesForUser(user.getId());
		List<GrantedAuthority> authoritys = new ArrayList<>();
		for (Roles rol : roles) {
			System.out.println(rol.getAuthority());
			authoritys.add(new SimpleGrantedAuthority(rol.getAuthority()));
		}
		return new User(user.getCorreo(), user.getPass(), true, true, true, true, authoritys);
	}

}
