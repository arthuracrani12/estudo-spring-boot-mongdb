package com.arthuracrani.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arthuracrani.domain.User;
import com.arthuracrani.services.UserService;


//para mostrar que sera um recurso rest
@RestController
//mostrar caminho do endpoint:
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;

	//retorna lista de usuarios
	@RequestMapping(method=RequestMethod.GET)
 	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}