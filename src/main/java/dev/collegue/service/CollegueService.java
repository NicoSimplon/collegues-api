package dev.collegue.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.collegue.dao.CollegueRepository;
import dev.collegue.entite.Collegue;
import dev.collegue.exception.CollegueInvalideException;
import dev.collegue.exception.CollegueNonTrouveException;

@Service
public class CollegueService {
	
	@Autowired CollegueRepository colRepo;

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

		Period period = Period.between(collegue.getDateDeNaissance(), LocalDate.now());

		if (period.getYears() < 18)
			throw new CollegueInvalideException("Un nouveau collègue doit avoir 18 ans au moins");

		collegue.setMatricule(UUID.randomUUID().toString());

		colRepo.save(collegue);

		return collegue;

	}

	public Collegue modifierEmail(String matricule, String email) {

		Collegue collegueRecherche = this.rechercherParMatricule(matricule);

		if (!email.contains("@"))
			throw new CollegueInvalideException(
					"L'adresse mail est mal formée, elle doit être de la forme suivante: exemple@exemple.com");
		
		if (email.length() < 3)
			throw new CollegueInvalideException("L'email doit comporter au moins trois caractères");

		collegueRecherche.setEmail(email);
		colRepo.save(collegueRecherche);

		return collegueRecherche;
	}

	public Collegue modifierPhotoUrl(String matricule, String photoUrl) {

		Collegue collegueRecherche = this.rechercherParMatricule(matricule);

		if (!photoUrl.startsWith("http"))
			throw new CollegueInvalideException("L'URL de la photo doit commencer par http");
		
		collegueRecherche.setPhotoUrl(photoUrl);
		colRepo.save(collegueRecherche);

		return collegueRecherche;
	}

	public List<Collegue> rechercherParNom(String nomRecherche) {
		
		if (!colRepo.findDistinctPeopleByNom(nomRecherche).isEmpty()) {
			
			return colRepo.findDistinctPeopleByNom(nomRecherche);
			
		} else {
			
			throw new CollegueNonTrouveException("Le nom renseigné est inconnu");			
			
		}

	}

	public Collegue rechercherParMatricule(String matriculeRecherche) {

		Optional<Collegue> collegueRecherche = colRepo.findById(matriculeRecherche);

		if (collegueRecherche.isPresent()) {

			return collegueRecherche.get();

		} else {

			throw new CollegueNonTrouveException("Le matricule renseigné est inconnu");

		}

	}

}
