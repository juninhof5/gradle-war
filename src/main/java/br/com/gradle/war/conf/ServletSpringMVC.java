package br.com.gradle.war.conf;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 
 * Classe de configuração. Configuramos o SpringMVC para atender as requisições que chegam para nossa aplicação.
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
		 * um array de classes de configurações.
		 * 
		 * Com esta configuração estamos definindo que a classe AppWebConfiguration será usada como classe de configuração do servlet do SpringMVC.
		 */
		return new Class[] {AppWebConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		/*
		 * um array com os mapeamentos que queremos que nosso servlet atenda.
		 * 
		 * Com esta configuração estamos definindo que o servlet do SpringMVC atenderá as requisições a partir da raiz do nosso projeto (/).
		 * 
		 * Erro 404 Porque? O que aconteceu? Nossas configurações estão todas certas e aparentemente o projeto não funcionou! Acontece que o SpringMVC
		 * está com um conflito de recursos, nós mapeamos a rota "/", mas o servidor por padrão, quando recebe uma requisição para o "/" ele retorna o
		 * index que estiver naquele endereço!Para resolvermos isso, basta deletar o arquivo index.html
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
