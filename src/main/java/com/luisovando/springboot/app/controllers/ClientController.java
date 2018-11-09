package com.luisovando.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luisovando.springboot.app.models.dao.IClientDAO;

@Controller
public class ClientController {
	
	@Autowired
	@Qualifier("ClientJPARepository")
	private IClientDAO clientRepository;
	
	@RequestMapping(method=RequestMethod.GET, value="/list")
	public String getClients(Model model) {
		model.addAttribute("title", "Client's List");
		model.addAttribute("clients", clientRepository.findAll());
		return "clientList";
	}
}
