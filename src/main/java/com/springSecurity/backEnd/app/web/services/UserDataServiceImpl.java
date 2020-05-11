package com.springSecurity.backEnd.app.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springSecurity.backEnd.app.web.model.entity.UserData;
import com.springSecurity.backEnd.app.web.model.services.UserDataServiceDao;

@Service
public class UserDataServiceImpl implements IUserDatoService {

	@Autowired
	private UserDataServiceDao userDataDao;
	
	@Override
	public void insert(UserData userData) {
		userDataDao.save(userData);
	}
	
	@Override
	public List<UserData> findAll() {
		return (List<UserData>) userDataDao.findAll();
	}
	
	@Override
	public UserData findForId(Integer id) {
		return userDataDao.findById(id).orElse(new UserData());
	}
	
	@Override
	public void edit(UserData userData) {
		userDataDao.save(userData);
	}
	
	@Override
	public void delete(UserData userData) {
		userDataDao.delete(userData);
	}
	
}
