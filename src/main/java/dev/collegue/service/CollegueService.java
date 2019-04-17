package dev.collegue.service;

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
		
		this.sauvegardeCollegue(new Collegue(UUID.randomUUID().toString(), "Marty", "Nicolas", "31/03/1987", "img1.jpg"));
		this.sauvegardeCollegue(new Collegue(UUID.randomUUID().toString(), "Paul", "Gurpratap", "18/12/1987", "img2.jpg"));
		this.sauvegardeCollegue(new Collegue(UUID.randomUUID().toString(), "Macron", "Emmanuel", "31/03/1982", "img3.jpg"));
		this.sauvegardeCollegue(new Collegue(UUID.randomUUID().toString(), "Phillipe", "Edouard", "31/03/1960", "img4.jpg"));
		this.sauvegardeCollegue(new Collegue(UUID.randomUUID().toString(), "Sarkosy", "Nicolas", "31/03/1955", "img5.jpg"));

	}

	public void sauvegardeCollegue(Collegue collegue) {
		
		this.data.put(collegue.getMatricule(), collegue);
		
	}
	
	public List<Collegue> rechercherParNom(String nomRecherche) {
        
		return this.data.values().stream().filter(col -> col.getNom().equals(nomRecherche)).collect(Collectors.toList());
		
    }
	
	public Collegue rechercherParMatricule(String matriculeRecherche) {

		Collegue collegue = null;
		
		if (data.get(matriculeRecherche) != null) {
		
			collegue = data.get(matriculeRecherche);
	
		} else {
			
			throw new CollegueNonTrouveException("Aucun collègue ne correspond au matricule renseigné");
			
		}
		
		return collegue;
    }

}
