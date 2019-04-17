package dev.collegue.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import dev.collegue.entite.Collegue;
import dev.collegue.exception.CollegueNonTrouveException;

public class CollegueService {

	private Map<String, Collegue> data = new HashMap<>();

	public CollegueService() {
		
		this.sauvegardeCollegue(new Collegue(UUID.randomUUID().toString(), "Marty", "Nicolas", LocalDate.of(1987, 3, 31), "https://www.petite-entreprise.net/donnees/cms/originales/deception-salarie.jpg", "marty@societe.com"));
		this.sauvegardeCollegue(new Collegue(UUID.randomUUID().toString(), "Paul", "Gurpratap", LocalDate.of(1987, 3, 31), "https://www.petite-entreprise.net/donnees/cms/originales/deception-salarie.jpg", "paul@societe.com"));
		this.sauvegardeCollegue(new Collegue(UUID.randomUUID().toString(), "Macron", "Emmanuel", LocalDate.of(1970, 3, 31), "https://www.petite-entreprise.net/donnees/cms/originales/deception-salarie.jpg", "macron@societe.com"));
		this.sauvegardeCollegue(new Collegue(UUID.randomUUID().toString(), "Phillipe", "Edouard", LocalDate.of(1960, 3, 31), "https://www.petite-entreprise.net/donnees/cms/originales/deception-salarie.jpg", "phillipe@societe.com"));
		this.sauvegardeCollegue(new Collegue(UUID.randomUUID().toString(), "Sarkosy", "Nicolas", LocalDate.of(1953, 3, 31), "https://www.petite-entreprise.net/donnees/cms/originales/deception-salarie.jpg", "sarkosy@societe.com"));

	}

	public void sauvegardeCollegue(Collegue collegue) throws CollegueInvalideException {
		
		if (collegue.getNom().length() >= 2 &&
				collegue.getPrenoms().length() >=2 &&
				collegue.getEmail().contains("@") &&
				collegue.getEmail().length() >= 3 &&
				collegue.getPhotoUrl().contains("http") &&
				(collegue.getDateDeNaissance().getYear() - LocalDate.now().getYear()) > 18) {
			
			this.data.put(collegue.getMatricule(), collegue);
		}
				
	}
	

        // TODO Vérifier que le nom et les prenoms ont chacun au moins 2 caractères
        // TODO Vérifier que l'email a au moins 3 caractères et contient `@`
        // TODO Vérifier que la photoUrl commence bien par `http`
        // TODO Vérifier que la date de naissance correspond à un age >= 18
        // TODO Si une des règles ci-dessus n'est pas valide, générer une exception :
        // `CollegueInvalideException`.


        // TODO générer un matricule pour ce collègue (`UUID.randomUUID().toString()`)

        // TODO Sauvegarder le collègue

	
	public List<Collegue> rechercherParNom(String nomRecherche) {
        
		return this.data.values().stream().filter(col -> col.getNom().equals(nomRecherche)).collect(Collectors.toList());
		
    }
	
	public Collegue rechercherParMatricule(String matriculeRecherche) throws CollegueNonTrouveException {

		return data.get(matriculeRecherche);
		
    }

}
