package dev.collegue.entite;

import java.time.LocalDate;

public class CollegueDTO {

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
	
	public CollegueDTO() {
		
	}
	
	/**
	 * @param matricule
	 * @param nom
	 * @param prenoms
	 * @param dateDeNaissance
	 * @param photoUrl
	 */
	public CollegueDTO(String matricule, String nom, String prenoms, LocalDate dateDeNaissance, String photoUrl, String email) {
		this.matricule = matricule;
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

}
