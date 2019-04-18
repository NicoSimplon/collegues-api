package dev.collegue.service;

import java.time.LocalDate;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.collegue.entite.Collegue;
import dev.collegue.exception.CollegueInvalideException;

public class CollegueServiceTest {
	
	private static final Logger LOG = LoggerFactory.getLogger(CollegueService.class);
	
	private CollegueService service;
	
	@Before
	public void init() {
		this.service = new CollegueService();
	}

	@Test(expected = CollegueInvalideException.class)
	public void testSauvegarderCollegueWithShorterNom() {
		
		LOG.info("Etant donné un nouvel objet Collegue initié avec un nom d'un seul caractère");
		Collegue collegue = new Collegue("m", "Nicolas", LocalDate.of(1987, 3, 31), "https://www.petite-entreprise.net/donnees/cms/originales/deception-salarie.jpg", "marty@societe.com");
		collegue.setMatricule(UUID.randomUUID().toString());
		
		LOG.info("Lorsqu'on sauvegarde ce collègue");
		LOG.info("Alors une exception de type CollegueInvalidException est lancée");
		service.sauvegardeCollegue(collegue);
		
	}
	
	@Test(expected = CollegueInvalideException.class)
	public void testSauvegarderCollegueWithShorterPrenom() {
		
		LOG.info("Etant donné un nouvel objet Collegue initié avec un prénom d'un seul caractère");
		Collegue collegue = new Collegue("Marty", "n", LocalDate.of(1987, 3, 31), "https://www.petite-entreprise.net/donnees/cms/originales/deception-salarie.jpg", "marty@societe.com");
		collegue.setMatricule(UUID.randomUUID().toString());
		
		LOG.info("Lorsqu'on sauvegarde ce collègue");
		LOG.info("Alors une exception de type CollegueInvalidException est lancée");
		service.sauvegardeCollegue(collegue);
		
	}
	
	@Test(expected = CollegueInvalideException.class)
	public void testSauvegarderCollegueWithInvalidEmail() {
		
		LOG.info("Etant donné un nouvel objet Collegue initié avec un email ne contenant pas d'@");
		Collegue collegue = new Collegue("Marty", "Nicolas", LocalDate.of(1987, 3, 31), "https://www.petite-entreprise.net/donnees/cms/originales/deception-salarie.jpg", "marty.societe.com");
		collegue.setMatricule(UUID.randomUUID().toString());
		
		LOG.info("Lorsqu'on sauvegarde ce collègue");
		LOG.info("Alors une exception de type CollegueInvalidException est lancée");
		service.sauvegardeCollegue(collegue);
		
	}
	
	@Test(expected = CollegueInvalideException.class)
	public void testSauvegarderCollegueWithShorterEmail() {
		
		LOG.info("Etant donné un nouvel objet Collegue initié avec un email d'un seul caractère");
		Collegue collegue = new Collegue("Marty", "Nicolas", LocalDate.of(1987, 3, 31), "https://www.petite-entreprise.net/donnees/cms/originales/deception-salarie.jpg", "@");
		collegue.setMatricule(UUID.randomUUID().toString());
		
		LOG.info("Lorsqu'on sauvegarde ce collègue");
		LOG.info("Alors une exception de type CollegueInvalidException est lancée");
		service.sauvegardeCollegue(collegue);
		
	}
	
	@Test(expected = CollegueInvalideException.class)
	public void testSauvegarderCollegueWithInvalidImgUrl() {
		
		LOG.info("Etant donné un nouvel objet Collegue initié avec une unrl d'image ne contenant pas http");
		Collegue collegue = new Collegue("Marty", "Nicolas", LocalDate.of(1987, 3, 31), "s://www.petite-entreprise.net/donnees/cms/originales/deception-salarie.jpg", "marty@societe.com");
		collegue.setMatricule(UUID.randomUUID().toString());
		
		LOG.info("Lorsqu'on sauvegarde ce collègue");
		LOG.info("Alors une exception de type CollegueInvalidException est lancée");
		service.sauvegardeCollegue(collegue);
		
	}
	
	@Test(expected = CollegueInvalideException.class)
	public void testSauvegarderCollegueWithInvalidAge() {
		
		LOG.info("Etant donné un nouvel objet Collegue initié avec un age inférieur à 18 ans");
		Collegue collegue = new Collegue("Marty", "Nicolas", LocalDate.of(2018, 3, 31), "https://www.petite-entreprise.net/donnees/cms/originales/deception-salarie.jpg", "marty@societe.com");
		collegue.setMatricule(UUID.randomUUID().toString());
		
		LOG.info("Lorsqu'on sauvegarde ce collègue");
		LOG.info("Alors une exception de type CollegueInvalidException est lancée");
		service.sauvegardeCollegue(collegue);
		
	}
	
}
