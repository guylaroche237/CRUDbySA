package com.sdze.sprjs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sdze.sprjs.entite.Etudiant;
import com.sdze.sprjs.repository.RepoEtudiant;

@SpringBootApplication
public class SpringAngularJsApplication implements CommandLineRunner {
    
	@Autowired
	private RepoEtudiant repo;
	public static void main(String[] args) {
		SpringApplication.run(SpringAngularJsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Etudiant a = new Etudiant("guyzo","guy@gmail.com","guy22");
		Etudiant b = new Etudiant("manuella","manuella@gmail.com","manuella22");
		Etudiant c = new Etudiant("francis","francisse@gmail.com","frank22");
		repo.save(a);repo.save(b);repo.save(c);
		
	}

}
