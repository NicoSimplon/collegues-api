package dev.collegue.entite;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurConnecte {

	/**
	 * String Matricule du collègue connecté
	 */
	private String matricule;

	/**
	 * String Nom du collègue connecté
	 */
	private String nom;

	/**
	 * String Prénom du collègue connecté
	 */
	private String prenoms;
	
	/**
	 * Listes des rôles du collègue connecté
	 */
	private List<String> roles = new ArrayList<>();

	/**
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * @param matricule the matricule to set
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
	 * @param nom the nom to set
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
	 * @param prenoms the prenoms to set
	 */
	public void setPrenoms(String prenoms) {
		this.prenoms = prenoms;
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
