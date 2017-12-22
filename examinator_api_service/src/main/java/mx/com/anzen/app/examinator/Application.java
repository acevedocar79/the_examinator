/*
 * Copyright (c) 2017 Anzen Soluciones S.A. de C.V.
 * Mexico D.F.
 * All rights reserved.
 *
 * THIS SOFTWARE IS  CONFIDENTIAL INFORMATION PROPIETARY OF ANZEN SOLUCIONES.
 * THIS INFORMATION SHOULD NOT BE DISCLOSED AND MAY ONLY BE USED IN ACCORDANCE THE TERMS DETERMINED BY THE COMPANY ITSELF.
 */
package mx.com.anzen.app.examinator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import mx.com.anzen.app.examinator.bean.repositories.OptionQuestionRepository;

/**
 * <p></p>
 * 
 * @author Marco Acevedo {@literal <marcoacevedo@anzen.com.mx>}
 * @version examinator-api-service
 * @since examinator-api-service
 * @category
 */
@Configuration
@ComponentScan({
	"mx.com.anzen.app.examinator", 
	"mx.com.anzen.app.examinator.bean.repositories", 
	"mx.com.anzen.app.examinator.bean.jpa"
	})
@EnableJpaRepositories("mx.com.anzen.app.examinator.bean.repositories")
@EntityScan("mx.com.anzen.app.examinator.bean.jpa")
@EnableAutoConfiguration(exclude = {MongoAutoConfiguration.class})
public class Application {

	public static void main(String[] args) {
		
		ApplicationContext foo = SpringApplication.run(Application.class, args);
		foo.getBean(OptionQuestionRepository.class);
	}
}
