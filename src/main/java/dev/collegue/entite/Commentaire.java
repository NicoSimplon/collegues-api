package dev.collegue.entite;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entité représentant un commentaire concernant un collègue
 * 
 * @author Nicolas
 *
 */
@Entity
@Table(name = "commentaire")
public class Commentaire {
	
	/**
	 * Identifiant du commentaire
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	/**
	 * Contenu du commentaire
	 */
	@Column(name = "content", length=5000)
	private String contenu;
	
	/**
	 * Date de création du commentaire
	 */
	@Column(name = "created_at")
	private LocalDateTime creationDate;
	
	/**
	 * Correspond au collègue à propos duquel est fait le commentaire
	 */
	@ManyToOne
	@JoinColumn(name = "collegue_matricule")
	private Collegue collegue;

	public Commentaire() {

	}

	public Commentaire(Integer id, String contenu, LocalDateTime creationDate) {
		this.id = id;
		this.contenu = contenu;
		this.creationDate = creationDate;
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
	 * @return the contenu
	 */
	public String getContenu() {
		return contenu;
	}

	/**
	 * @param contenu the contenu to set
	 */
	public void setContenu(String contenu) {
		this.contenu = contenu;
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

	/**
	 * @return the collegue
	 */
	public Collegue getCollegue() {
		return collegue;
	}

	/**
	 * @param collegue the collegue to set
	 */
	public void setCollegue(Collegue collegue) {
		this.collegue = collegue;
	}

}
