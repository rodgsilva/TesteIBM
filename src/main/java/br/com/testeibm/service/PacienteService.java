package br.com.testeibm.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.testeibm.domain.Paciente;
import br.com.testeibm.domain.dto.PacienteDTO;
import br.com.testeibm.repositories.PacienteRepository;

@Service
public class PacienteService {
	
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
		return pacienteRepository.findOne(id);
		
	}

}
