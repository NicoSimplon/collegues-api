package dev.collegue.controler;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.collegue.entite.Collegue;
import dev.collegue.service.CollegueService;

@RestController
@RequestMapping("/collegues")
public class CollegueController {

	@GetMapping
    public List<Collegue> trouverCollegueParNom(@RequestParam("nom") String nomRecherche) {

        // La méthode retourne une liste d'objets Java
        // qui sera transformée automatiquement en JSON
		CollegueService service = new CollegueService();
		
        return service.rechercherParNom(nomRecherche);
    }
	
}
