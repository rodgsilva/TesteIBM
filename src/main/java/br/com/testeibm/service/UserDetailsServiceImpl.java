package br.com.testeibm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.testeibm.domain.Usuario;
import br.com.testeibm.repositories.UsuarioRepository;
import br.com.testeibm.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario user =repo.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException(email);
		}
		
		return new UserSS(user.getIdUsuario(),user.getEmail(),user.getSenha(),user.getPerfis());
	}

}
