package dev.collegue.controler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.collegue.entite.Collegue;
import dev.collegue.exception.CollegueNonTrouveException;
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
	@ExceptionHandler(value = { CollegueNonTrouveException.class })
	public ResponseEntity<Object> trouverCollegueParMatricule(@PathVariable String matriculeRecherche) {
		
		Collegue collegueRecherche = service.rechercherParMatricule(matriculeRecherche);
		
		if (collegueRecherche != null) {
			
			return ResponseEntity.status(HttpStatus.OK).body(collegueRecherche);
		
		}
		
		return ResponseEntity.status(404).body("Collegue non trouvé");
	}
	
}
