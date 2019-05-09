package dev.collegue.service;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dev.collegue.dao.UtilisateurRepository;
import dev.collegue.entite.Utilisateur;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	private UtilisateurRepository utilisateurRepository;

	public UserDetailServiceImpl(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Utilisateur utilisateurTrouve = this.utilisateurRepository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));

		return new User(utilisateurTrouve.getEmail(), utilisateurTrouve.getMotDePasse(),
				utilisateurTrouve.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));

	}

}
