package com.spacewalrus;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("/")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig(){
		register(HelloController.class);
		register(Questions.class);
		property(ServletProperties.FILTER_FORWARD_ON_404, true);
	}
}
