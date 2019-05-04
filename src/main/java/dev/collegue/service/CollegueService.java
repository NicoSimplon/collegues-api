package dev.collegue.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.collegue.dao.CollegueRepository;
import dev.collegue.entite.Collegue;
import dev.collegue.exception.CollegueInvalideException;
import dev.collegue.exception.CollegueNonTrouveException;

/**
 * Couche service de l'application, c'est ici que le CRUD vers la base de
 * données est appelée
 * 
 * @author Nicolas
 *
 */
@Service
public class CollegueService {

	@Autowired
	CollegueRepository colRepo;

	/**
	 * @param colRepo the repository to set
	 *            
	 */
	public void setColRepo(CollegueRepository colRepo) {
		this.colRepo = colRepo;
	}

	/**
	 * Ajoute un nouveau collègue dans la base de données puis le retourne
	 * 
	 * @param collegue
	 * @return Collegue
	 */
	public Collegue sauvegardeCollegue(Collegue collegue) {

		if (collegue.getNom().length() < 2)
			throw new CollegueInvalideException("Le nom doit comporter au moins deux caractères");

		if (collegue.getPrenoms().length() < 2)
			throw new CollegueInvalideException("Le prénom doit comporter au moins deux caractères");

		if (!collegue.getEmail().contains("@"))
			throw new CollegueInvalideException(
					"L'adresse mail est mal formée, elle doit être de la forme suivante: exemple@exemple.com");

		if (collegue.getEmail().length() < 3)
			throw new CollegueInvalideException("L'email doit comporter au moins trois caractères");

		if (!collegue.getPhotoUrl().startsWith("http"))
			throw new CollegueInvalideException("L'URL de la photo doit commencer par http");
		
		if (collegue.getPhotoUrl().length() > 255)
			throw new CollegueInvalideException("L'URL de la photo ne peut pas contenir plus de 255 caractères");
		
		if (collegue.getPhotoUrl().length() < 7)
			throw new CollegueInvalideException("L'URL de la photo ne peut pas contenir moins de 7 caractères");

		Period period = Period.between(collegue.getDateDeNaissance(), LocalDate.now());

		if (period.getYears() < 18)
			throw new CollegueInvalideException("Un nouveau collègue doit avoir 18 ans au moins");

		collegue.setMatricule(UUID.randomUUID().toString());

		colRepo.save(collegue);

		return collegue;

	}

	/**
	 * Modifie le champ email d'un collègue recherché via son matricule
	 * 
	 * @param matricule
	 * @param email
	 * @return Collegue
	 */
	@Transactional
	public Collegue modifierEmail(String matricule, String email) {

		Collegue collegueRecherche = this.rechercherParMatricule(matricule);

		if (!email.contains("@"))
			throw new CollegueInvalideException(
					"L'adresse mail est mal formée, elle doit être de la forme suivante: exemple@exemple.com");

		if (email.length() < 3)
			throw new CollegueInvalideException("L'email doit comporter au moins trois caractères");

		collegueRecherche.setEmail(email);
		return collegueRecherche;
	}

	/**
	 * Modifie le champ photoUrl d'un collègue recherché via son matricule
	 * 
	 * @param matricule
	 * @param photoUrl
	 * @return
	 */
	@Transactional
	public Collegue modifierPhotoUrl(String matricule, String photoUrl) {

		Collegue collegueRecherche = this.rechercherParMatricule(matricule);

		if (!photoUrl.startsWith("http"))
			throw new CollegueInvalideException("L'URL de la photo doit commencer par http");
		
		if (photoUrl.length() > 255)
			throw new CollegueInvalideException("L'URL de la photo ne peut pas contenir plus de 255 caractères");
		
		if (photoUrl.length() < 7)
			throw new CollegueInvalideException("L'URL de la photo ne peut pas contenir moins de 7 caractères");

		collegueRecherche.setPhotoUrl(photoUrl);
		
		return collegueRecherche;
	}

	/**
	 * Recherche un ou plusieurs collègues dans la base de données via un nom de
	 * famille
	 * 
	 * @param nomRecherche
	 * @return List<Collegue>
	 */
	public List<Collegue> rechercherParNom(String nomRecherche) {
		
		List<Collegue> listeCollegues = colRepo.findDistinctPeopleByNom(nomRecherche);

		if (!listeCollegues.isEmpty()) {

			return listeCollegues;

		} else {

			throw new CollegueNonTrouveException("Le nom renseigné est inconnu");

		}

	}

	/**
	 * Recherche un collègue dans la base de données via son matricule et le
	 * retourne
	 * 
	 * @param matriculeRecherche
	 * @return Collegue
	 */
	public Collegue rechercherParMatricule(String matriculeRecherche) {

		return colRepo.findById(matriculeRecherche).orElseThrow(CollegueNonTrouveException::new);


	}

}
