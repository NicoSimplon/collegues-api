package dev.collegue.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.collegue.entite.Commentaire;

/**
 * Repository spécifique aux commentaires mettant à disposition un CRUD basique avec JPA, plus les méthodes suivantes 
 * 
 * @author Nicolas
 *
 */
public interface CommentaireRepository extends JpaRepository<Commentaire, Integer>  {
	
	@Query("select c from Commentaire c where c.collegue.matricule = :matricule")
	List<Commentaire> findAllByMatricule(@Param("matricule") String matricule);
	
}
