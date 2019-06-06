package br.com.testeibm.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.testeibm.domain.Usuario;
import br.com.testeibm.repositories.UsuarioRepository;
import br.com.testeibm.service.exception.ObjectNotFoundException;

@Service
public class AuthService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private BCryptPasswordEncoder pe;

	
	private Random rand =new Random();
	
	
	
	public void sendNewPassword(String email){
		 
		 Usuario user= usuarioRepository.findByEmail(email);
		 if(user == null) {
			 throw new ObjectNotFoundException("Email não localizado");
			}
		 String newPass =newPassword();
		 user.setSenha(pe.encode(newPass));
		 
			 
		 usuarioRepository.save(user);
		// emailService.sendNewPasswordEmail(cliente,newPass);
		 
	 }



	private String newPassword() {
		char [] vet =new char[10];
		for(int i=0; i<10;i++) {
			vet[i] =randomChar();
		}
		return new String(vet);
	}


	private char randomChar() {
		int opt = rand.nextInt(3);
		if(opt==0) {
			return (char) (rand.nextInt(10) + 48);
		} else if(opt==1) {
			return (char) (rand.nextInt(26) + 65);
		}else {
			return (char) (rand.nextInt(26) + 97);
		}
	}

}
