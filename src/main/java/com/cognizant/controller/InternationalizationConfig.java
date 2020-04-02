package com.cognizant.controller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class InternationalizationConfig extends WebMvcConfigurerAdapter {
	/*
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:message");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}*/
	
	// Create a SessionLocaleResolver object and set the default locale to
	// English return the SessionLocaleResolver object
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver r = new SessionLocaleResolver();
		r.setDefaultLocale(Locale.US);
		return r;
	}

	// Create LocaleChangeInterceptor object and set the parameter name as
	// language and return the localeChangeInterceptor
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("language");
		return interceptor;

	}

	// register the LocaleChangeInterceptor
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//LocaleChangeInterceptor interceptor =localeChangeInterceptor();
		registry.addInterceptor(localeChangeInterceptor());
	}
}
