package dev.collegue.controler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.collegue.dao.CollegueRepository;
import dev.collegue.entite.Collegue;
import dev.collegue.entite.InfosAuthentification;
import dev.collegue.entite.UtilisateurConnecte;
import dev.collegue.exception.CollegueNonTrouveException;
import io.jsonwebtoken.Jwts;

@RestController
public class AuthentificationCtrl {

	@Value("${jwt.expires_in}")
	private Integer EXPIRES_IN;

	@Value("${jwt.cookie}")
	private String TOKEN_COOKIE;

	@Value("${jwt.secret}")
	private String SECRET;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CollegueRepository service;
	
	private String email;

	@PostMapping(value = "/auth")
	public ResponseEntity authenticate(@RequestBody InfosAuthentification authenticationRequest,
			HttpServletResponse response) {

		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				authenticationRequest.getEmail(), authenticationRequest.getMotDePasse());

		Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

		User user = (User) authentication.getPrincipal();

		String rolesList = user.getAuthorities().stream().map(a -> a.getAuthority()).collect(Collectors.joining(","));

		Map<String, Object> infosSupplementaireToken = new HashMap<>();
		infosSupplementaireToken.put("roles", rolesList);
		
		this.email = authenticationRequest.getEmail();

		String jetonJWT = Jwts.builder().setSubject(user.getUsername()).addClaims(infosSupplementaireToken)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRES_IN * 1000))
				.signWith(io.jsonwebtoken.SignatureAlgorithm.HS512, SECRET).compact();

		Cookie authCookie = new Cookie(TOKEN_COOKIE, jetonJWT);
		authCookie.setHttpOnly(true);
		authCookie.setMaxAge(EXPIRES_IN * 1000);
		authCookie.setPath("/");
		response.addCookie(authCookie);

		return ResponseEntity.ok().build();

	}
	
	@GetMapping(value = "/me")
	@Secured("ROLE_USER")
	public UtilisateurConnecte getUserIdentity() {
		
		UtilisateurConnecte user = new UtilisateurConnecte();
		
		Collegue collegueConnecte = this.service.findCollegueEmail(this.email).orElseThrow(CollegueNonTrouveException::new);
		
		user.setMatricule(collegueConnecte.getMatricule());
		user.setNom(collegueConnecte.getNom());
		user.setPrenoms(collegueConnecte.getPrenoms());
		user.setRoles(collegueConnecte.getRoles());
		
		return user;
		
	}

	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity mauvaiseInfosConnexion(BadCredentialsException e) {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}

}
