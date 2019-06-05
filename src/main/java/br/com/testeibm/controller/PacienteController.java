package br.com.testeibm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.testeibm.domain.Paciente;
import br.com.testeibm.service.PacienteService;

@Controller
@RequestMapping(value="/paciente")
public class PacienteController {
	
	@Autowired
	private PacienteService pacienteService;
	
	@GetMapping(value="/find")
	public ResponseEntity<List<Paciente>> findAll(){
		
		List<Paciente> list = pacienteService.findAll();
		return ResponseEntity.ok().body(list);
		
	}

}
