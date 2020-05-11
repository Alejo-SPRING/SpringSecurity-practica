package com.springSecurity.backEnd.app.web.model.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springSecurity.backEnd.app.web.model.entity.Roles;

public interface RolesServiceDao extends CrudRepository<Roles, Integer>{

	@Query("SELECT r FROM Roles r WHERE r.userLogin.id = :id")
	List<Roles> findRolesForUser(@Param("id") Integer id);
	
}
