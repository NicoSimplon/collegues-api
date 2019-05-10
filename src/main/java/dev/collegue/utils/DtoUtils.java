package dev.collegue.utils;

import dev.collegue.entite.Collegue;
import dev.collegue.entite.CollegueDTO;
import dev.collegue.entite.Commentaire;
import dev.collegue.entite.CommentaireDTO;
import dev.collegue.entite.CreateCollegue;

public interface DtoUtils {

	public static CollegueDTO toCollegueDTO(Collegue col) {

		return new CollegueDTO(col.getMatricule() ,col.getNom(), col.getPrenoms(), col.getDateDeNaissance(), col.getPhotoUrl(),
				col.getEmail());

	}

	public static Collegue toCollegue(CollegueDTO col) {

		return new Collegue(col.getNom(), col.getPrenoms(), col.getDateDeNaissance(), col.getPhotoUrl(),
				col.getEmail());

	}
	
	public static Collegue toCollegueFromCreateCollegue(CreateCollegue col) {
		
		return new Collegue(col.getNom(), col.getPrenoms(), col.getDateDeNaissance(), col.getPhotoUrl(),
				col.getEmail(), col.getMotDePasse(), col.getRoles());
		
	}

	public static CommentaireDTO toCommentaireDTO(Commentaire com) {

		return new CommentaireDTO(com.getId(), com.getContenu(), com.getCreationDate());

	}

	public static Commentaire toCommentaire(CommentaireDTO com) {

		return new Commentaire(com.getId(), com.getContenu(), com.getCreationDate());

	}

}
