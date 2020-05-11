package com.springSecurity.backEnd.app.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springSecurity.backEnd.app.web.model.entity.Roles;
import com.springSecurity.backEnd.app.web.model.services.RolesServiceDao;

@Service
public class RolesServiceImpl implements IRolesService{

	@Autowired
	private RolesServiceDao rolesDao;
	
	@Override
	public List<Roles> findAll() {
		return (List<Roles>) rolesDao.findAll(); 
	}
	
	@Override
	public List<Roles> findAllRolesForUser(Integer id) {
		return rolesDao.findRolesForUser(id);
	}
	
	@Override
	public Roles findForId(Integer id) {
		return rolesDao.findById(id).orElse(new Roles());
	}
	
	@Override
	public void insert(Roles roles) {
		rolesDao.save(roles);
	}
	
	@Override
	public void update(Roles roles) {
		rolesDao.save(roles);
	}
	
	@Override
	public void delete(Roles roles) {
		rolesDao.delete(roles);
	}
	
}
