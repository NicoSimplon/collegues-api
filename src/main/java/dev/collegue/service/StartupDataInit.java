package dev.collegue.service;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.collegue.entite.Collegue;

/**
 * Données initialisées au démarrage de l'application
 * 
 * @author Nicolas
 *
 */
@Component
public class StartupDataInit {

	@Autowired
	private CollegueService service;

    @EventListener(ContextRefreshedEvent.class)
    public void init() {

    	service.sauvegardeCollegue( new Collegue(
    			"Marty", 
    			"Nicolas", 
    			LocalDate.of(1987, 3, 31),
				"https://www.petite-entreprise.net/donnees/cms/originales/deception-salarie.jpg", 
				"marty@societe.com",
				"pass1",
				Arrays.asList("ROLE_ADMIN", "ROLE_USER")));
    	
    	service.sauvegardeCollegue( new Collegue(
    			"Marty", 
    			"Pascal", 
    			LocalDate.of(1990, 4, 8),
				"https://www.petite-entreprise.net/donnees/cms/originales/deception-salarie.jpg", 
				"marty2@societe.com",
				"pass2",
				Arrays.asList("ROLE_USER")));
    	
    	service.sauvegardeCollegue( new Collegue(
    			"Paul", 
    			"Gurpratap Singh", 
    			LocalDate.of(1987, 12, 18),
				"https://www.petite-entreprise.net/donnees/cms/originales/deception-salarie.jpg", 
				"paul@societe.com",
				"pass3",
				Arrays.asList("ROLE_USER")));
    	
    	service.sauvegardeCollegue( new Collegue(
    			"Biraben", 
    			"Hugo", 
    			LocalDate.of(2000, 7, 14),
				"https://www.petite-entreprise.net/donnees/cms/originales/deception-salarie.jpg", 
				"biraben@societe.com",
				"pass4",
				Arrays.asList("ROLE_USER")));
    	
    	service.sauvegardeCollegue( new Collegue(
    			"Vianay", 
    			"Remy", 
    			LocalDate.of(1992, 5, 18),
				"https://www.petite-entreprise.net/donnees/cms/originales/deception-salarie.jpg", 
				"vianay@societe.com",
				"pass5",
				Arrays.asList("ROLE_USER")));
    	
    }
}