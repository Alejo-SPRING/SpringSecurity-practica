package com.springSecurity.backEnd.app.web.model.services;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springSecurity.backEnd.app.web.model.entity.UserLogin;

public interface UserLoginServiceDao extends CrudRepository<UserLogin, Integer>{

	@Query("SELECT u FROM UserLogin u WHERE u.correo = :correo")
	UserLogin findForCorreo(@Param("correo") String correo);
	
}
