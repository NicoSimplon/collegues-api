package dev.collegue.controler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.collegue.entite.Collegue;
import dev.collegue.entite.CollegueDTO;
import dev.collegue.entite.CollegueModifie;
import dev.collegue.entite.CommentaireDTO;
import dev.collegue.entite.CreateCollegue;
import dev.collegue.entite.StockagePhotoMatricule;
import dev.collegue.service.CollegueService;
import dev.collegue.service.CommentaireService;
import dev.collegue.utils.DtoUtils;

/**
 * Couche Controller de l'application, c'est ici que sont gérées les requêtes et réponses HTTP
 * 
 * @author Nicolas
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/collegues")
public class CollegueController {

	@Autowired
	private CollegueService service;
	
	@Autowired
	private CommentaireService serviceCom;
	
	/**
	 * Méthode retournant le matricule du collègue recherché
	 * 
	 * @param nomRecherche
	 * @return String matricule
	 */
	@GetMapping
	@Secured("ROLE_USER")
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
	@Secured("ROLE_USER")
	public CollegueDTO trouverCollegueParMatricule(@PathVariable String matriculeRecherche) {

		return DtoUtils.toCollegueDTO(service.rechercherParMatricule(matriculeRecherche));
	
	}
	
	/**
	 * Retourne l'objet Collegue après l'avoir enregistré
	 * 
	 * @param collegue
	 * @return Collegue
	 */
	@PostMapping
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Object> ajouterCollegue(@RequestBody CreateCollegue collegue) {
		
		CollegueDTO newCollegue = DtoUtils.toCollegueDTO(service.sauvegardeCollegue(DtoUtils.toCollegueFromCreateCollegue(collegue)));
		return ResponseEntity.status(HttpStatus.OK).body(newCollegue);

	}
	
	/**
	 * Retourne un objet collègue après l'avoir modifié
	 * 
	 * @param matricule
	 * @param fieldContainer
	 * @return
	 */
	@PatchMapping(value = "/{matricule}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Object> modifierCollegue(@PathVariable String matricule, @RequestBody CollegueModifie fieldContainer) {
		
		CollegueDTO collegueModifie = null;
		
		if (fieldContainer.getEmail() != null) {
			
			collegueModifie = DtoUtils.toCollegueDTO(service.modifierEmail(matricule, fieldContainer.getEmail()));
		}
		
		if (fieldContainer.getPhotoUrl() != null) {
			
			collegueModifie = DtoUtils.toCollegueDTO(service.modifierPhotoUrl(matricule, fieldContainer.getPhotoUrl()));
			
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(collegueModifie);
	}
	
	/**
	 * Retourne true si l'email dont l'existence est vérifiée existe déjà
	 * 
	 * @param email
	 * @return boolean
	 */
	@GetMapping(value = "/verif")
	@Secured("ROLE_USER")
    public boolean verifierEmailExist(@RequestParam("email") String email) {

        return service.emailAlreadyExist(email);
        
    }
	
	/**
	 * Retourne toutes les photos des collègues assortis de leur matricule
	 * 
	 * @return List<StockagePhotoMatricule>
	 */
	@GetMapping(value = "/photos")
	@Secured("ROLE_USER")
	public List<StockagePhotoMatricule> recupAllPhotos() {
		
		return service.recupPhotos();
		
	}
	
	@GetMapping(value = "/{matricule}/commentaires")
	@Secured("ROLE_USER")
	public List<CommentaireDTO> recupCommentairesByMatricule(@PathVariable String matricule) {
		
		return serviceCom.recupererCommentaireParMatricule(matricule)
				.stream()
				.map(DtoUtils::toCommentaireDTO)
				.collect(Collectors.toList());
		
	}
	
	@PostMapping(value = "/{matricule}/commentaires")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Object> ajouterCommentaire(@PathVariable String matricule, @RequestBody CommentaireDTO commentaire) {
		
		commentaire.setCreationDate(LocalDateTime.now());
		
		CommentaireDTO newCommentaire = serviceCom.sauvegarderCommentaire(matricule, commentaire);
		
		return ResponseEntity.status(HttpStatus.OK).body(newCommentaire);

	}
	
	@DeleteMapping(value = "/{matricule}/commentaires/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Object> supprimerCommentaire(@PathVariable Integer id) {
		serviceCom.supprimerCommentaire(id);
		return ResponseEntity.status(HttpStatus.OK).body("La suppression a été réalisée avec succès");
	}
	
}
