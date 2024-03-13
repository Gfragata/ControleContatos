package br.com.JavaItau.ControleContatos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.ehmf.App.Contatos.resource", "br.com.ehmf.App.Contatos.service"})
@ComponentScan(basePackages = {"br.com.ehmf.App.Contatos.resource", "br.com.ehmf.App.Contatos.configuration"})
public class ControleContatosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleContatosApplication.class, args);
	}

}
