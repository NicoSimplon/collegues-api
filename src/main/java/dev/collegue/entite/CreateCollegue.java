package dev.collegue.entite;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CreateCollegue {

	/**
	 * String matricule identifiant le collègue
	 */
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
	 * Mot de passe de l'utilisateur
	 */
	private String MotDePasse;
	
	/**
	 * Liste des roles du nouveau collègues
	 */
	private List<String> roles = new ArrayList<>();
	
	public CreateCollegue() {
		
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
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return MotDePasse;
	}

	/**
	 * @param motDePasse the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		MotDePasse = motDePasse;
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
