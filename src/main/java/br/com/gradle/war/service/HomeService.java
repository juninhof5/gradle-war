package br.com.gradle.war.service;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class HomeService implements Serializable {

	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "Entrando tela inicial - HomeController.index";
	}

}