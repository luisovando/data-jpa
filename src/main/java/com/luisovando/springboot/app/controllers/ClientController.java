package com.luisovando.springboot.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luisovando.springboot.app.models.dao.IClientDAO;
import com.luisovando.springboot.app.models.entity.Client;

@Controller
public class ClientController {
	
	@Autowired
	@Qualifier("ClientJPARepository")
	private IClientDAO clientRepository;
	
	@RequestMapping(method=RequestMethod.GET, value="/list")
	public String index(Model model) {
		model.addAttribute("title", "Client's List");
		model.addAttribute("clients", clientRepository.findAll());
		return "clientList";
	}
	
	@RequestMapping(value="/form")
	public String create(Map<String, Object> model) {
		Client client = new Client();
		model.put("title", "Formulario de cliente");
		model.put("client", client);
		return "form";
	}
	
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String store(Client client) {
		clientRepository.save(client);
		return "redirect:list";
	}
}
