package dev.collegue.entite;

/**
 * Permet de stocker l'email ou l'url de la photo dans le cadre d'une modification d'un collaborateur existant
 * 
 * @author Nicolas
 *
 */
public class CollegueModifie {
	
	private String email;
	
	private String photoUrl;

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the photoUrl
	 */
	public String getPhotoUrl() {
		return photoUrl;
	}

	/**
	 * @param photoUrl the photoUrl to set
	 */
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

}
