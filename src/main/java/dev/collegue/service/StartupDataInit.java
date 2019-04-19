package dev.collegue.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.collegue.entite.Collegue;

@Component
public class StartupDataInit {

	@Autowired
	private CollegueService service;

    @EventListener(ContextRefreshedEvent.class)
    public void init() {

    	service.sauvegardeCollegue(new Collegue("Marty", "Nicolas", LocalDate.of(1987, 3, 31),
				"https://www.petite-entreprise.net/donnees/cms/originales/deception-salarie.jpg", "marty@societe.com"));
    	service.sauvegardeCollegue(new Collegue("Paul", "Gurpratap", LocalDate.of(1987, 3, 31),
				"https://www.petite-entreprise.net/donnees/cms/originales/deception-salarie.jpg", "paul@societe.com"));
    	service.sauvegardeCollegue(new Collegue("Macron", "Emmanuel", LocalDate.of(1970, 3, 31),
				"https://www.petite-entreprise.net/donnees/cms/originales/deception-salarie.jpg",
				"macron@societe.com"));
    	service.sauvegardeCollegue(new Collegue("Phillipe", "Edouard", LocalDate.of(1960, 3, 31),
				"https://www.petite-entreprise.net/donnees/cms/originales/deception-salarie.jpg",
				"phillipe@societe.com"));
    	service.sauvegardeCollegue(new Collegue("Sarkosy", "Nicolas", LocalDate.of(1953, 3, 31),
				"https://www.petite-entreprise.net/donnees/cms/originales/deception-salarie.jpg",
				"sarkosy@societe.com"));

    }
}