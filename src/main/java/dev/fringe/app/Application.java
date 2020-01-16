package dev.fringe.app;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

import javax.servlet.ServletException;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;
import org.springframework.web.SpringServletContainerInitializer;

import dev.fringe.app.config.WebApplicationInit;
import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.handlers.PathHandler;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;
import io.undertow.servlet.api.ServletContainerInitializerInfo;

public class Application {
	
	@Autowired Undertow undertow;
	
	public static void main(String[] args) throws BeansException, IOException{
		String webPort = System.getenv("PORT");
		if(StringUtils.hasLength(webPort) == false) {
			System.setProperty("port", "8080");
			System.setProperty("spring.profiles.active", "LOC");
		}else {
			System.setProperty("port", System.getenv("PORT"));
			System.setProperty("spring.profiles.active", "DEV");
		}
		new AnnotationConfigApplicationContext(Application.class).getBean(Application.class).run(args);
	}
	
	public void run(String[] args) throws IOException {
		undertow.start();
	}
	
	@Bean
	public Undertow server() throws ServletException {
		Set set = Collections.singleton(WebApplicationInit.class);
		ServletContainerInitializerInfo servletContainerInitializerInfo = new ServletContainerInitializerInfo(SpringServletContainerInitializer.class, set);
		DeploymentInfo servletBuilder = Servlets.deployment().setClassLoader(Application.class.getClassLoader()).setContextPath("/").setDeploymentName("dev-fringe.war").addWelcomePages("index.html","/").addServletContainerInitializer(servletContainerInitializerInfo);
		DeploymentManager manager = Servlets.defaultContainer().addDeployment(servletBuilder);
		manager.deploy();
		PathHandler path = Handlers.path(Handlers.redirect("/")).addPrefixPath("/", manager.start());
		return Undertow.builder().addHttpListener(Integer.valueOf(System.getProperty("port")), "0.0.0.0").setHandler(path).build();
	}
}
