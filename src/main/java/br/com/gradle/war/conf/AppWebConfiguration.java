package br.com.gradle.war.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.gradle.war.controllers.HomeController;
import br.com.gradle.war.service.HomeService;

@EnableWebMvc // recurso de Web MVC do SpringMVC.
@ComponentScan(basePackageClasses={HomeController.class, HomeService.class}) // configura o caminho (pacote) onde o SpringMVC irá encontrar os controllers e componentes
public class AppWebConfiguration {

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){
		/*
		 * Nosso próximo passo é configurar nosso projeto para que o SpringMVC consiga encontrar nossas views. Essa configuração é feita na nossa
		 * classe de configuração AppWebConfiguration. Criaremos um novo metodo que ajudará o SpringMVC a encontrar nossas views.
		 * 
		 * A anotação @Bean é para que o retorno da chamada deste metódo possa ser gerenciada pelo SpringMVC, sem ela nossa configuração não funciona.
		 * 
		 * Outra observação válida é que já estámos colocando o sufixo de nosso arquivos (.jsp). Desta forma, não precisamos colocar a extenção dos
		 * arquivos de view em nossos controllers. Sendo assim, modifique o HomeController para retornar apenas "home" em vez de "home.jsp"
		 */
	    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	    resolver.setPrefix("/WEB-INF/views/"); // define o caminho onde estão nossas views.
	    resolver.setSuffix(".jsp"); // adiciona a extenção dos arquivos de view
	    return resolver;
	}
	
}
