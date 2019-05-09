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
public class UserDetailServiceImpl implements UserDetailsService {

	private CollegueRepository collegueRepository;

	public UserDetailServiceImpl(CollegueRepository colRepo) {
		this.collegueRepository = colRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Collegue collegueTrouve = this.collegueRepository.findCollegueEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));

		return new User(collegueTrouve.getEmail(), collegueTrouve.getMotDePasse(),
				collegueTrouve.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));

	}

}
