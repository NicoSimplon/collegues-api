package dev.collegue.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import dev.collegue.entite.Collegue;
import dev.collegue.exception.CollegueInvalideException;
import dev.collegue.exception.CollegueNonTrouveException;

public class CollegueService {

	private Map<String, Collegue> data = new HashMap<>();

	public CollegueService() {

		this.sauvegardeCollegue(new Collegue("Marty", "Nicolas", LocalDate.of(1987, 3, 31),
				"https://www.petite-entreprise.net/donnees/cms/originales/deception-salarie.jpg", "marty@societe.com"));
		this.sauvegardeCollegue(new Collegue("Paul", "Gurpratap", LocalDate.of(1987, 3, 31),
				"https://www.petite-entreprise.net/donnees/cms/originales/deception-salarie.jpg", "paul@societe.com"));
		this.sauvegardeCollegue(new Collegue("Macron", "Emmanuel", LocalDate.of(1970, 3, 31),
				"https://www.petite-entreprise.net/donnees/cms/originales/deception-salarie.jpg",
				"macron@societe.com"));
		this.sauvegardeCollegue(new Collegue("Phillipe", "Edouard", LocalDate.of(1960, 3, 31),
				"https://www.petite-entreprise.net/donnees/cms/originales/deception-salarie.jpg",
				"phillipe@societe.com"));
		this.sauvegardeCollegue(new Collegue("Sarkosy", "Nicolas", LocalDate.of(1953, 3, 31),
				"https://www.petite-entreprise.net/donnees/cms/originales/deception-salarie.jpg",
				"sarkosy@societe.com"));

	}

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

		this.data.put(collegue.getMatricule(), collegue);

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
		data.get(matricule).setEmail(email);

		return collegueRecherche;
	}

	public Collegue modifierPhotoUrl(String matricule, String photoUrl) {

		Collegue collegueRecherche = this.rechercherParMatricule(matricule);

		if (!photoUrl.startsWith("http"))
			throw new CollegueInvalideException("L'URL de la photo doit commencer par http");
		
		collegueRecherche.setPhotoUrl(photoUrl);
		data.get(matricule).setPhotoUrl(photoUrl);

		return collegueRecherche;
	}

	public List<Collegue> rechercherParNom(String nomRecherche) {

		List<Collegue> list = this.data.values().stream().filter(col -> col.getNom().equals(nomRecherche))
				.collect(Collectors.toList());

		if (list.get(0) instanceof Collegue) {

			return list;

		} else {

			throw new CollegueNonTrouveException("Le nom renseigné est inconnu");

		}

	}

	public Collegue rechercherParMatricule(String matriculeRecherche) {

		Collegue collegueRecherche = data.get(matriculeRecherche);

		if (collegueRecherche != null) {

			return collegueRecherche;

		} else {

			throw new CollegueNonTrouveException("Le matricule renseigné est inconnu");

		}

	}

}
