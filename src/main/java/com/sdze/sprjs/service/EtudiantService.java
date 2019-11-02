package com.sdze.sprjs.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sdze.sprjs.entite.Etudiant;
import com.sdze.sprjs.repository.RepoEtudiant;

@RestController
@RequestMapping("/lycee")
public class EtudiantService {
	
	@Autowired
	private RepoEtudiant repo;
	
	
	@GetMapping("/all")
	public List<Etudiant> getAllEtudiant(){
		List<Etudiant> list = repo.findAll();
		return list;
			
	}
	
	@GetMapping("/all/{ide}")
	public Optional<Etudiant> getStudent(@PathVariable("ide") Long id) {
		
		return repo.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean deleteUser(@PathVariable("id") Long id) {
		repo.deleteById(id);
		System.out.println("supression effectuer avec success");
		return true;
	}
	
	@PostMapping("/save/user")
	public boolean saveUser(@RequestParam String login,@RequestParam String password,@RequestParam String email) {
		Etudiant e = new Etudiant();
		e.setLogin(login);e.setPassword(password);e.setEmail(email);
		repo.save(e);
		
		return true;
	}
	
	@GetMapping("/update/student")
	public boolean updateUser(@RequestParam Long id,@RequestParam String login,@RequestParam String password,@RequestParam String email) {
		
		repo.setStudentInfo(id, login, password, email);
		return true;
	}
	
	
	
	

}
