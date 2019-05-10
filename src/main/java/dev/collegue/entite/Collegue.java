package dev.collegue.entite;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "collegue")
public class Collegue {

	/**
	 * String matricule identifiant le collègue
	 */
	@Id
	@Column(name = "matricule")
	private String matricule;

	/**
	 * String Nom du collègue
	 */
	private String nom;

	/**
	 * String Prénom du collègue
	 */
	private String prenoms;

	/**
	 * String Date de naissance du collègue
	 */
	private LocalDate dateDeNaissance;

	/**
	 * String url de la photo du collègue
	 */
	private String photoUrl;

	/**
	 * String email pro
	 */
	private String email;
	
	/**
	 * String mot de passe utilisateur
	 */
	private String motDePasse;

	@OneToMany(mappedBy = "collegue")
	private List<Commentaire> commentaires;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles = new ArrayList<>();

	public Collegue() {
		/**
		 * Constructeur par défaut
		 */
	}

	/**
	 * @param matricule
	 * @param nom
	 * @param prenoms
	 * @param dateDeNaissance
	 * @param photoUrl
	 */
	public Collegue(String nom, String prenoms, LocalDate dateDeNaissance, String photoUrl, String email, String password, List<String> roles) {
		this.nom = nom;
		this.prenoms = prenoms;
		this.dateDeNaissance = dateDeNaissance;
		this.photoUrl = photoUrl;
		this.email = email;
		this.motDePasse = password;
		this.roles = roles;
	}
	
	/**
	 * @param matricule
	 * @param nom
	 * @param prenoms
	 * @param dateDeNaissance
	 * @param photoUrl
	 */
	public Collegue(String nom, String prenoms, LocalDate dateDeNaissance, String photoUrl, String email, String password) {
		this.nom = nom;
		this.prenoms = prenoms;
		this.dateDeNaissance = dateDeNaissance;
		this.photoUrl = photoUrl;
		this.email = email;
		this.motDePasse = password;
	}
	
	/**
	 * @param nom
	 * @param prenoms
	 * @param dateDeNaissance
	 * @param photoUrl
	 * @param email
	 */
	public Collegue(String nom, String prenoms, LocalDate dateDeNaissance, String photoUrl, String email) {
		this.nom = nom;
		this.prenoms = prenoms;
		this.dateDeNaissance = dateDeNaissance;
		this.photoUrl = photoUrl;
		this.email = email;
	}

	/**
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * @param matricule
	 *            the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenoms
	 */
	public String getPrenoms() {
		return prenoms;
	}

	/**
	 * @param prenoms
	 *            the prenoms to set
	 */
	public void setPrenoms(String prenoms) {
		this.prenoms = prenoms;
	}

	/**
	 * @return the dateDeNaissance
	 */
	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}

	/**
	 * @param dateDeNaissance
	 *            the dateDeNaissance to set
	 */
	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	/**
	 * @return the photoUrl
	 */
	public String getPhotoUrl() {
		return photoUrl;
	}

	/**
	 * @param photoUrl
	 *            the photoUrl to set
	 */
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the commentaires
	 */
	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	/**
	 * @param commentaires
	 *            the commentaires to set
	 */
	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	/**
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}

	/**
	 * @param motDePasse the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	/**
	 * @return the roles
	 */
	public List<String> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

}
