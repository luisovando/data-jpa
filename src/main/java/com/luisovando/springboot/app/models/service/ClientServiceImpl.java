package com.luisovando.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luisovando.springboot.app.models.dao.IClientDAO;
import com.luisovando.springboot.app.models.entity.Client;

@Service
public class ClientServiceImpl implements IClientService {

	@Autowired
	private IClientDAO clientRepository;
	
	@Override
	@Transactional(readOnly=true)
	public List<Client> findAll() {
		return (List<Client>) clientRepository.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Client findOne(Long clientId) {
		return clientRepository.findById(clientId).orElse(null);
	}

	@Override
	@Transactional
	public void save(Client client) {
		clientRepository.save(client);
	}

	@Override
	@Transactional
	public void delete(Long clientId) {
		clientRepository.deleteById(clientId);
	}
	
}
