package com.sdze.sprjs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.sdze.sprjs.entite.Etudiant;

public interface RepoEtudiant extends JpaRepository<Etudiant,Long> {
	
	@Transactional
	@Modifying
	@Query("update Etudiant u set u.login = ?2, u.password = ?3, u.email = ?4 where u.id = ?1")
	void setStudentInfo(Long id, String login, String password, String email);

}
