package com.springSecurity.backEnd.app.web.model.services;

import org.springframework.data.repository.CrudRepository;

import com.springSecurity.backEnd.app.web.model.entity.UserData;

public interface UserDataServiceDao extends CrudRepository<UserData, Integer>{

}
