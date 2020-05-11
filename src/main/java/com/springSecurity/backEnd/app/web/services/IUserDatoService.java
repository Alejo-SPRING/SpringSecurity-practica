package com.springSecurity.backEnd.app.web.services;

import java.util.List;

import com.springSecurity.backEnd.app.web.model.entity.UserData;

public interface IUserDatoService {

	public void insert(UserData userData);

	public List<UserData> findAll();

	public UserData findForId(Integer id);

	public void edit(UserData userData);

	public void delete(UserData userData);

}
