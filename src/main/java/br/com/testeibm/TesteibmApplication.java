package br.com.testeibm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.testeibm.domain.Paciente;
import br.com.testeibm.repositories.PacienteRepository;
import br.com.testeibm.service.PacienteService;

@SpringBootApplication
public class TesteibmApplication implements CommandLineRunner  {

	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private PacienteService pacienteService;
	
	public static void main(String[] args) {
		SpringApplication.run(TesteibmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		List<Paciente> list = new ArrayList<>();
		list.add(new Paciente("Rodrigo", "Masc", 100.00, 35, 1.75));
		list.add(new Paciente("Maria", "Fem", 15.00, 5, 1.10));
		list.add(new Paciente("Cristiane", "Fem", 75.00, 41, 1.55));
		list.add(new Paciente("João", "Masc", 90.00, 75, 1.85));
		list.add(new Paciente("Pedro", "Masc", 85.00, 22, 1.70));
		list.add(new Paciente("Gabi", "Fem", 85.00, 60, 1.65));

		pacienteRepository.save(list);
		
		pacienteService.getPaciente();
		
	}

}
