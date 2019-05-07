package dev.collegue.entite;

import java.time.LocalDateTime;

public class CommentaireDTO {
	
	/**
	 * Identifiant du commentaire
	 */
	private Integer id;

	/**
	 * Contenu du commentaire
	 */
	private String contenu;
	
	/**
	 * Date de création du commentaire
	 */
	private LocalDateTime creationDate;

	public CommentaireDTO() {

	}

	public CommentaireDTO(Integer id, String contenu, LocalDateTime dateCreation) {
		this.id = id;
		this.contenu = contenu;
		this.creationDate = dateCreation;
	}

	/**
	 * @return the contenu
	 */
	public String getContenu() {
		return contenu;
	}

	/**
	 * @param contenu
	 *            the contenu to set
	 */
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the creationDate
	 */
	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

}
