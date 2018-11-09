package com.luisovando.springboot.app.models.dao;

import java.util.List;

import com.luisovando.springboot.app.models.entity.Client;

public interface IClientDAO {
	public List<Client> findAll();
	
	public void save(Client client);
}
