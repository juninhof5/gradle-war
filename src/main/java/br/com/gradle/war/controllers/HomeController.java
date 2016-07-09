package br.com.gradle.war.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gradle.war.service.HomeService;

@Controller // Informa ao SpringMVC que esta classe é um controller
public class HomeController {

	@Autowired
	private HomeService homeService;

	@RequestMapping("/") // tem a função de definir que o metodo atende a um determinado path ou endereço. Neste caso estamos definindo que o metodo index atenderá as requisições que chegarem na raiz do nosso projeto ("/").
	public String index(){
		System.out.println(homeService.getMessage());
		return "home";
	}

}
