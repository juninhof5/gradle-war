package br.com.gradle.war.conf;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 
 * Classe de configura��o. Configuramos o SpringMVC para atender as requisi��es que chegam para nossa aplica��o.
 * 
 */
public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		/*
		 * um array de classes de configura��es.
		 * 
		 * Com esta configura��o estamos definindo que a classe AppWebConfiguration ser� usada como classe de configura��o do servlet do SpringMVC.
		 */
		return new Class[] {AppWebConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		/*
		 * um array com os mapeamentos que queremos que nosso servlet atenda.
		 * 
		 * Com esta configura��o estamos definindo que o servlet do SpringMVC atender� as requisi��es a partir da raiz do nosso projeto (/).
		 * 
		 * Erro 404 Porque? O que aconteceu? Nossas configura��es est�o todas certas e aparentemente o projeto n�o funcionou! Acontece que o SpringMVC
		 * est� com um conflito de recursos, n�s mapeamos a rota "/", mas o servidor por padr�o, quando recebe uma requisi��o para o "/" ele retorna o
		 * index que estiver naquele endere�o!Para resolvermos isso, basta deletar o arquivo index.html
		 */
		return new String[] {"/"};
	}
	
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		return new Filter[] {characterEncodingFilter};
	}

}
