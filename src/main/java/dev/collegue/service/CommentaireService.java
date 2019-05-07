package dev.collegue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.collegue.dao.CollegueRepository;
import dev.collegue.dao.CommentaireRepository;
import dev.collegue.entite.Collegue;
import dev.collegue.entite.Commentaire;
import dev.collegue.entite.CommentaireDTO;
import dev.collegue.exception.CollegueNonTrouveException;
import dev.collegue.exception.CommentaireInvalideException;
import dev.collegue.utils.DtoUtils;

@Service
public class CommentaireService {
	
	@Autowired
	CommentaireRepository comRepo;
	
	@Autowired
	CollegueRepository colRepo;

	/**
	 * @param comRepo the comRepo to set
	 */
	public void setComRepo(CommentaireRepository comRepo) {
		this.comRepo = comRepo;
	}
	
	/**
	 * Sauvegarde un nouveau commentaire puis de le retourner
	 * 
	 * @param commentaire
	 * @return Commentaire
	 */
	public CommentaireDTO sauvegarderCommentaire(String matricule, CommentaireDTO commentaire) {
		
		if (commentaire == null) {
			throw new CommentaireInvalideException("Le commentaire envoyé est invalide");
		}
		if (commentaire.getContenu().length() < 5) {
			throw new CommentaireInvalideException("Le commentaire envoyé est invalide: taille minimale de 5 caractères");
		}
		
		Commentaire com = DtoUtils.toCommentaire(commentaire);
		
		Collegue collegue = this.colRepo.findById(matricule).orElseThrow(CollegueNonTrouveException::new);
		com.setCollegue(collegue);
		
		this.comRepo.save(com);
		
		return DtoUtils.toCommentaireDTO(com);
	}
	
	/**
	 * Récupère tous les commentaires relatifs à un collègue via son matricule
	 * 
	 * @param matricule
	 * @return List<Commentaire>
	 */
	public List<Commentaire> recupererCommentaireParMatricule(String matricule) {
		
		if (matricule instanceof String) {
			this.colRepo.findById(matricule).orElseThrow(CollegueNonTrouveException::new);
		} else {
			throw new CommentaireInvalideException("Le commentaire envoyé est invalide");
		}
		
		return this.comRepo.findAllByMatricule(matricule);
	}
	
	/**
	 * Supprime un commentaire de la base de données grâce à son id
	 * 
	 * @param id
	 */
	public void supprimerCommentaire(Integer id) {
		
		if (id == null) {
			throw new CommentaireInvalideException("Le commentaire que vous essayez de supprimer n'a pas d'id valide, veuillez contacter un administrateur");
		}
		
		if (this.comRepo.findById(id).isPresent()) {
			this.comRepo.deleteById(id);						
		} else {
			throw new CommentaireInvalideException("L'id du ommentaire que vous tentez de supprimer ne correspond à aucun commentaire, veuillez contacter un administrateur");
		}
		
	}

}
