package com.project.springboot.signuplogin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class ContextMessage{
	/**
	 * �޼��� �ҽ��� �����Ѵ�.
	 */

	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {

		ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();


		source.setBasename("classpath:/messages/message");

		// �⺻ ���ڵ��� �����Ѵ�.
		source.setDefaultEncoding("UTF-8");

		// ������Ƽ ������ ������ ������ �ð� ������ �����Ѵ�.
		source.setCacheSeconds(60);

		// ���� �޼����� ��� ���ܸ� �߻���Ű�� ��� �ڵ带 �⺻ �޼����� �Ѵ�.
		source.setUseCodeAsDefaultMessage(true);
		return source;

	}

	/**
	 * ����� ��� ������ ����� ������ �����۸� �����Ѵ�.
	 * ���⼭�� ���ǿ� �����ϴ� ����� ����Ѵ�.
	 */

	@Bean
	public SessionLocaleResolver localeResolver() {
		return new SessionLocaleResolver();
	}
}