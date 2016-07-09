package br.com.gradle.war.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.gradle.war.controllers.HomeController;
import br.com.gradle.war.service.HomeService;

@EnableWebMvc // recurso de Web MVC do SpringMVC.
@ComponentScan(basePackageClasses={HomeController.class, HomeService.class}) // configura o caminho (pacote) onde o SpringMVC ir� encontrar os controllers e componentes
public class AppWebConfiguration {

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){
		/*
		 * Nosso pr�ximo passo � configurar nosso projeto para que o SpringMVC consiga encontrar nossas views. Essa configura��o � feita na nossa
		 * classe de configura��o AppWebConfiguration. Criaremos um novo metodo que ajudar� o SpringMVC a encontrar nossas views.
		 * 
		 * A anota��o @Bean � para que o retorno da chamada deste met�do possa ser gerenciada pelo SpringMVC, sem ela nossa configura��o n�o funciona.
		 * 
		 * Outra observa��o v�lida � que j� est�mos colocando o sufixo de nosso arquivos (.jsp). Desta forma, n�o precisamos colocar a exten��o dos
		 * arquivos de view em nossos controllers. Sendo assim, modifique o HomeController para retornar apenas "home" em vez de "home.jsp"
		 */
	    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	    resolver.setPrefix("/WEB-INF/views/"); // define o caminho onde est�o nossas views.
	    resolver.setSuffix(".jsp"); // adiciona a exten��o dos arquivos de view
	    return resolver;
	}
	
}
