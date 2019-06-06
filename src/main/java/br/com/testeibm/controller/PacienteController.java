package br.com.testeibm.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.testeibm.domain.Paciente;
import br.com.testeibm.domain.dto.PacienteDTO;
import br.com.testeibm.service.PacienteService;

@Controller
@RequestMapping(value="/paciente")
public class PacienteController {
	
	@Autowired
	private PacienteService pacienteService;
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping(value="/pesquisa")
	public ResponseEntity<List<PacienteDTO>> getPesquisa(){
		
		List<PacienteDTO> list = pacienteService.getPaciente();
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value="/")
	public ResponseEntity<List<Paciente>> findAll(){
		
		List<Paciente> list = pacienteService.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	
	@PostMapping(value="/")
	public ResponseEntity<Void> post(@RequestBody Paciente paciente){
		
		paciente = pacienteService.post(paciente);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(paciente.getIdPaciente()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<Paciente> find(@PathVariable Integer id){
		
		Paciente paciente = pacienteService.find(id);
		
		return ResponseEntity.ok().body(paciente);
		
	}

}
