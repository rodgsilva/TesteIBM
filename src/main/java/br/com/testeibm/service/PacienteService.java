package br.com.testeibm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.testeibm.domain.Paciente;
import br.com.testeibm.domain.dto.PacienteDTO;
import br.com.testeibm.domain.enums.Perfil;
import br.com.testeibm.repositories.PacienteRepository;
import br.com.testeibm.security.UserSS;
import br.com.testeibm.service.exception.AuthorizationException;

@Service
public class PacienteService {
	
	
	@Autowired
	private  BCryptPasswordEncoder pe;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private Relatorio rel;

	
	
	public List<PacienteDTO> getPaciente() {
		
		
		
		List<PacienteDTO> objDTO = new ArrayList<>() ;
		
		
		return objDTO = rel.getPaciente();
	
	}
	
	public List<Paciente> findAll() {
		return pacienteRepository.findAll();
		
	}
	public Paciente post(Paciente paciente) {
		return pacienteRepository.save(paciente);
		
	}
	public Paciente find(Integer id) {
		
		UserSS user = UserService.authenticated();
		if(user==null ||!user.hasRole(Perfil.ADMIN)&& !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso Negado");
		}
		return pacienteRepository.findOne(id);
		
	}

}
