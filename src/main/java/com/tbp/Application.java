package com.tbp;


import com.tbp.visao.Janela;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application  {
   

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(
				Application.class).headless(false).run(args);
        
        Janela appFrame = context.getBean(Janela.class);
	appFrame.setVisible(true);
    }

   
}
