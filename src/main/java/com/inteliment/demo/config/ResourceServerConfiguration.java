/*package com.inteliment.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

// -------------------------- Oauth 2 configurations ---------------------------

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		// @formatter:off
		resources.resourceId("oauth2-resource");
		// @formatter:on
	}

	
	  @Override public void configure(HttpSecurity http) throws Exception {
	   @formatter:off http .authorizeRequests()
	  .antMatchers("/users").hasRole("ADMIN")
	  .antMatchers("/greeting").authenticated(); @formatter:on }
	 
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/api/v1/**").authenticated();
	}

}
*/