package dev.collegue.service;

import java.time.LocalDate;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import dev.collegue.entite.Collegue;
import dev.collegue.exception.CollegueInvalideException;

@RunWith(SpringRunner.class )
@SpringBootTest
public class CollegueServiceTest {
	
	private static final Logger LOG = LoggerFactory.getLogger(CollegueService.class);
	
	@Autowired
	private CollegueService service;

	@Test(expected = CollegueInvalideException.class)
	public void testSauvegarderCollegueWithShorterNom() {
		
		LOG.info("Etant donné un nouvel objet Collegue initié avec un nom d'un seul caractère");
		Collegue collegue = new Collegue("m", "Nicolas", LocalDate.of(1987, 3, 31), "https://www.petite-entreprise.net/donnees/cms/originales/deception-salarie.jpg", "marty@societe.com");
		
		LOG.info("Lorsqu'on sauvegarde ce collègue");
		LOG.info("Alors une exception de type CollegueInvalidException est lancée");
		service.sauvegardeCollegue(collegue);
		
	}
	
	@Test(expected = CollegueInvalideException.class)
	public void testSauvegarderCollegueWithShorterPrenom() {
		
		LOG.info("Etant donné un nouvel objet Collegue initié avec un prénom d'un seul caractère");
		Collegue collegue = new Collegue("Marty", "n", LocalDate.of(1987, 3, 31), "https://www.petite-entreprise.net/donnees/cms/originales/deception-salarie.jpg", "marty@societe.com");
		
		LOG.info("Lorsqu'on sauvegarde ce collègue");
		LOG.info("Alors une exception de type CollegueInvalidException est lancée");
		service.sauvegardeCollegue(collegue);
		
	}
	
	@Test(expected = CollegueInvalideException.class)
	public void testSauvegarderCollegueWithInvalidEmail() {
		
		LOG.info("Etant donné un nouvel objet Collegue initié avec un email ne contenant pas d'@");
		Collegue collegue = new Collegue("Marty", "Nicolas", LocalDate.of(1987, 3, 31), "https://www.petite-entreprise.net/donnees/cms/originales/deception-salarie.jpg", "marty.societe.com");
		
		LOG.info("Lorsqu'on sauvegarde ce collègue");
		LOG.info("Alors une exception de type CollegueInvalidException est lancée");
		service.sauvegardeCollegue(collegue);
		
	}
	
	@Test(expected = CollegueInvalideException.class)
	public void testSauvegarderCollegueWithShorterEmail() {
		
		LOG.info("Etant donné un nouvel objet Collegue initié avec un email d'un seul caractère");
		Collegue collegue = new Collegue("Marty", "Nicolas", LocalDate.of(1987, 3, 31), "https://www.petite-entreprise.net/donnees/cms/originales/deception-salarie.jpg", "@");
		
		LOG.info("Lorsqu'on sauvegarde ce collègue");
		LOG.info("Alors une exception de type CollegueInvalidException est lancée");
		service.sauvegardeCollegue(collegue);
		
	}
	
	@Test(expected = CollegueInvalideException.class)
	public void testSauvegarderCollegueWithInvalidImgUrl() {
		
		LOG.info("Etant donné un nouvel objet Collegue initié avec une url d'image ne contenant pas http");
		Collegue collegue = new Collegue("Marty", "Nicolas", LocalDate.of(1987, 3, 31), "s://www.petite-entreprise.net/donnees/cms/originales/deception-salarie.jpg", "marty@societe.com");
		
		LOG.info("Lorsqu'on sauvegarde ce collègue");
		LOG.info("Alors une exception de type CollegueInvalidException est lancée");
		service.sauvegardeCollegue(collegue);
		
	}
	
	@Test(expected = CollegueInvalideException.class)
	public void testSauvegarderCollegueWithInvalidAge() {
		
		LOG.info("Etant donné un nouvel objet Collegue initié avec un age inférieur à 18 ans");
		Collegue collegue = new Collegue("Marty", "Nicolas", LocalDate.of(2018, 3, 31), "https://www.petite-entreprise.net/donnees/cms/originales/deception-salarie.jpg", "marty@societe.com");
		
		LOG.info("Lorsqu'on sauvegarde ce collègue");
		LOG.info("Alors une exception de type CollegueInvalidException est lancée");
		service.sauvegardeCollegue(collegue);
		
	}
	
	@Test(expected = CollegueInvalideException.class)
	public void testModifierCollegueWithInvalidEmail() {
		
		LOG.info("Etant donné un nouvel objet Collegue initié et sauvegardé");
		Collegue collegue = new Collegue("Marty", "Nicolas", LocalDate.of(1987, 3, 31), "https://www.petite-entreprise.net/donnees/cms/originales/deception-salarie.jpg", "marty@societe.com");
		collegue.setMatricule(UUID.randomUUID().toString());
		
		service.sauvegardeCollegue(collegue);
		
		LOG.info("Lorsqu'on modifie ce collègue avec un email ne contenant pas d'@");
		LOG.info("Alors une exception de type CollegueInvalidException est lancée");
		service.modifierEmail(collegue.getMatricule(), "marty.nicolas");
		
	}
	
	@Test(expected = CollegueInvalideException.class)
	public void testModifierCollegueWithShorterEmail() {
		
		LOG.info("Etant donné un nouvel objet Collegue initié et sauvegardé");
		Collegue collegue = new Collegue("Marty", "Nicolas", LocalDate.of(1987, 3, 31), "https://www.petite-entreprise.net/donnees/cms/originales/deception-salarie.jpg", "nico@mail.fr");
		collegue.setMatricule(UUID.randomUUID().toString());
		
		service.sauvegardeCollegue(collegue);
		
		LOG.info("Lorsqu'on modifie ce collègue avec avec un email d'un seul caractère");
		LOG.info("Alors une exception de type CollegueInvalidException est lancée");
		service.modifierEmail(collegue.getMatricule(), "@");
		
	}
	
	@Test(expected = CollegueInvalideException.class)
	public void testModifierCollegueWithInvalidImgUrl() {
		
		LOG.info("Etant donné un nouvel objet Collegue initié et sauvegardé");
		Collegue collegue = new Collegue("Marty", "Nicolas", LocalDate.of(1987, 3, 31), "https://www.petite-entreprise.net/donnees/cms/originales/deception-salarie.jpg", "marty@societe.com");
		collegue.setMatricule(UUID.randomUUID().toString());
		
		service.sauvegardeCollegue(collegue);
		
		LOG.info("Lorsqu'on sauvegarde ce collègue avec une url d'image ne contenant pas http");
		LOG.info("Alors une exception de type CollegueInvalidException est lancée");
		service.modifierPhotoUrl(collegue.getMatricule(), "ttp://www.img.com");
		
	}
	
}
