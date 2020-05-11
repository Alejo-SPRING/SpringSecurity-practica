package com.springSecurity.backEnd.app.web.services;

import java.util.List;

import com.springSecurity.backEnd.app.web.model.entity.UserLogin;

public interface IUserLoginService {

	public List<UserLogin> findAll();

	public UserLogin findForId(Integer id);

	public void save(UserLogin userLogin);

	public void edit(UserLogin userLogin);

	public void delete(UserLogin userLogin);

	public UserLogin findByCorreo(String correo);

}
