package com.tbp;

import com.tbp.repository.PersonRepository;
import com.tbp.visao.Janela;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application  {

    @Autowired
    PersonRepository personRepository;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(
				Application.class).headless(false).run(args);
        
        Janela appFrame = context.getBean(Janela.class);
		appFrame.setVisible(true);
    }

   
}
