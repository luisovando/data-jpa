package com.luisovando.springboot.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.luisovando.springboot.app.models.dao.IClientDAO;
import com.luisovando.springboot.app.models.entity.Client;

@Controller
@SessionAttributes("client")
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
	
	@RequestMapping(value="/form/{id}")
	public String edit(@PathVariable(value="id") Long clientId, Map<String, Object> model) {
		if (clientId <= 0) {
			return "redirect:list";
		}
		Client client = clientRepository.findOne(clientId);
		model.put("title", "Editar de cliente");
		model.put("client", client);
		return "form";
	}
	
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String store(@Valid Client client, BindingResult result, Map<String, Object> model, SessionStatus status) {
		if (result.hasErrors()) {
			model.put("title", "Formulario de cliente");
			return "form";
		}
		clientRepository.save(client);
		status.setComplete();
		return "redirect:list";
	}
	
	@RequestMapping(value="/delete/{id}")
	public String destroy(@PathVariable(value="id") Long clientId, Map<String, Object> model) {
		if (clientId > 0) {
			clientRepository.delete(clientId);
		}
		return "redirect:/list";
	}
}
