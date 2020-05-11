package com.springSecurity.backEnd.app.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springSecurity.backEnd.app.web.model.entity.UserLogin;
import com.springSecurity.backEnd.app.web.model.services.UserLoginServiceDao;

@Service
public class UserLoginServiceImpl implements IUserLoginService {

	@Autowired
	private UserLoginServiceDao userLoginDao;
	
	@Override
	public List<UserLogin> findAll() {
		return (List<UserLogin>) userLoginDao.findAll();
	}
	
	@Override
	public UserLogin findForId(Integer id) {
		return userLoginDao.findById(id).orElse(new UserLogin());
	}
	
	@Override
	public void save(UserLogin userLogin) {
		userLoginDao.save(userLogin);
	}
	
	@Override
	public void edit(UserLogin userLogin) {
		userLoginDao.save(userLogin);
	}
	
	@Override
	public void delete(UserLogin userLogin) {
		userLoginDao.delete(userLogin);
	}
	
	@Override
	public UserLogin findByCorreo(String correo) {
		return userLoginDao.findForCorreo(correo);
	}
	
}
