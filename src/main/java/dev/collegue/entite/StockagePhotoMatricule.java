package dev.collegue.entite;

public class StockagePhotoMatricule {
	
	private String matricule;
	
	private String photoUrl;	

	public StockagePhotoMatricule(String matricule, String photoUrl) {
		this.matricule = matricule;
		this.photoUrl = photoUrl;
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

}
