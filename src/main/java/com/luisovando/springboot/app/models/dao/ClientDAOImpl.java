package com.luisovando.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luisovando.springboot.app.models.entity.Client;

@Repository("ClientJPARepository")
public class ClientDAOImpl implements IClientDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Client").getResultList();
	}

	@Override
	@Transactional
	public void save(Client client) {
		if (client.getId() != null && client.getId() > 0) {
			em.merge(client);
		} else {
			em.persist(client);
		}
	}

	@Override
	public Client findOne(Long clientId) {
		return em.find(Client.class, clientId);
	}

}
