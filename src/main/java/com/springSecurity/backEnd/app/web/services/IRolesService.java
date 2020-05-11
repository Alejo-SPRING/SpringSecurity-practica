package com.springSecurity.backEnd.app.web.services;

import java.util.List;

import com.springSecurity.backEnd.app.web.model.entity.Roles;

public interface IRolesService {

	public List<Roles> findAll();

	public Roles findForId(Integer id);

	public void insert(Roles roles);

	public void update(Roles roles);

	public void delete(Roles roles);

	public List<Roles> findAllRolesForUser(Integer id);

}
