package dev.collegue.service;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dev.collegue.dao.CollegueRepository;
import dev.collegue.entite.Collegue;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private CollegueRepository utilisateurRepository;

	public UserDetailsServiceImpl(CollegueRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Collegue utilisateurTrouve = this.utilisateurRepository
				.findCollegueEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));

		return new User(
					utilisateurTrouve.getEmail(), 
					utilisateurTrouve.getMotDePasse(),
					utilisateurTrouve.getRoles()
						.stream()
						.map(SimpleGrantedAuthority::new)
						.collect(Collectors.toList()));

	}

}
