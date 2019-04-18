package dev.collegue.controler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.collegue.entite.Collegue;
import dev.collegue.service.CollegueService;

@RestController
@RequestMapping("/collegues")
public class CollegueController {

	private CollegueService service = new CollegueService();
	
	/**
	 * Méthode retournant le matricule du collègue recherché
	 * 
	 * @param nomRecherche
	 * @return String matricule
	 */
	@GetMapping
    public List<String> trouverCollegueParNom(@RequestParam("nom") String nomRecherche) {

        return service.rechercherParNom(nomRecherche).stream().map(Collegue::getMatricule).collect(Collectors.toList());
    }
	
	/**
	 * Retourne l'objet Collegue recherché grâce à son matricule
	 * 
	 * @param matriculeRecherche
	 * @return Collegue
	 */
	@GetMapping(value = "/{matriculeRecherche}")
	public Collegue trouverCollegueParMatricule(@PathVariable String matriculeRecherche) {

		return service.rechercherParMatricule(matriculeRecherche);
	
	}
	
	@PostMapping
	public ResponseEntity<String> ajouterCollegue(@RequestBody Collegue collegue) {
		
		service.sauvegardeCollegue(collegue);
		 return ResponseEntity.status(HttpStatus.OK).body("Le nouveau collègue a bien été ajouté");

	}
	
}
