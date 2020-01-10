package dev.fringe.app;

import java.util.Collections;
import java.util.Set;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
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
	public static void main(String[] args){
		new AnnotationConfigApplicationContext(Application.class).getBean(Application.class).run(args);
	}

	@Bean
	public Undertow server() throws ServletException {
		String webPort = System.getenv("PORT");
		if (webPort == null || webPort.isEmpty()) {
			webPort = "8080";
		}
		Set set = Collections.singleton(WebApplicationInit.class);
		ServletContainerInitializerInfo servletContainerInitializerInfo = new ServletContainerInitializerInfo(
				SpringServletContainerInitializer.class, set);
		DeploymentInfo servletBuilder = Servlets.deployment().setClassLoader(Application.class.getClassLoader())
				.setContextPath("/").setDeploymentName("dev-fringe.war")
				.addServletContainerInitializer(servletContainerInitializerInfo);
		DeploymentManager manager = Servlets.defaultContainer().addDeployment(servletBuilder);
		manager.deploy();
		PathHandler path = Handlers.path(Handlers.redirect("/")).addPrefixPath("/", manager.start());
		return Undertow.builder().addHttpListener(Integer.valueOf(webPort), "0.0.0.0").setHandler(path).build();
	}

	public void run(String[] args) {
		undertow.start();
	}

}
