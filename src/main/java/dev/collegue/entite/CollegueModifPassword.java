package dev.collegue.entite;

/**
 * Classe DTO pour la modification du mot de passe de l'utilisateur connecté
 * 
 * @author Nicolas
 *
 */
public class CollegueModifPassword {
	
	/**
	 * Nouveau mot de passe
	 */
	private String motDePasse;
	
	public CollegueModifPassword() {
		/** Default Constructor */
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

	
}
