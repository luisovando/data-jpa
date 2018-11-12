package com.luisovando.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.luisovando.springboot.app.models.entity.Client;

public interface IClientDAO extends CrudRepository<Client, Long> {}
