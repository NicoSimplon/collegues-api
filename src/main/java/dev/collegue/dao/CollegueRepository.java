package dev.collegue.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.collegue.entite.Collegue;

/**
 * Repository mettant à disposition un CRUD basique avec JPA, plus les méthodes suivantes
 * 
 * @author Nicolas
 *
 */
public interface CollegueRepository extends JpaRepository<Collegue, String> {
	
	 @Query("select distinct c from Collegue c where c.nom = :nom")
	 List<Collegue> findDistinctPeopleByNom(@Param("nom") String nom);
	 
	 @Query("select c from Collegue c where c.email = :email")
	 Optional<Collegue> findCollegueEmail(@Param("email") String email);
	
}