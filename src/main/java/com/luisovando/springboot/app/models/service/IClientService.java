package com.luisovando.springboot.app.models.service;

import java.util.List;

import com.luisovando.springboot.app.models.entity.Client;

public interface IClientService {
	public List<Client> findAll();
	
	public void save(Client client);
	
	public Client findOne(Long clientId);
	
	public void delete(Long clientId);
}
