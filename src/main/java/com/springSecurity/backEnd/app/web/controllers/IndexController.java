package com.springSecurity.backEnd.app.web.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

	@GetMapping("/login")
	public String index(@RequestParam(name = "error", required = false) String error, @RequestParam(name = "logout", required = false) String logout, Principal principal, Model model) {
		if(principal != null) {
			model.addAttribute("mensaje", "¡Ya iniciste sesión!");
			return "pages/index";
		}
		if(error != null) {
			model.addAttribute("mensaje", "La contraseña o el usuario es incorrecto!");
		}
		if(logout != null) {
			model.addAttribute("mensaje", "La sesión fue cerrada con exito!");
		}
		return "index";
	}
	
	@GetMapping("/")
	public String inicio() {
		return "pages/index";
	}
	
}
