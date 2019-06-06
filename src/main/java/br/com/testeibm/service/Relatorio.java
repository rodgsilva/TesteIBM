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
public class Relatorio {

	@Autowired
	private PacienteRepository pacienteRepository;

	public List<PacienteDTO> getPaciente() {

		List<PacienteDTO> objDTO = new ArrayList<>();

		PacienteDTO pacienteDTO = new PacienteDTO();

		List<Paciente> list = new ArrayList<>();
		list = pacienteRepository.findAll();

		pacienteDTO = new PacienteDTO();
		int sum = list.size();

		String sexo = "Masc";
		pacienteDTO.setDescricao("Quantidade de paciente= " + sum);

		objDTO.add(pacienteDTO);

		pacienteDTO = new PacienteDTO();
		Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
		List<String> homeMediaIdade = new ArrayList();

		homeMediaIdade = list.stream().filter(p -> p.getSexo().equals(sexo)).map(p -> p.getNome()).sorted(comp)
				.collect(Collectors.toList());

		pacienteDTO.setDescricao("Homes = " + homeMediaIdade);

		objDTO.add(pacienteDTO);

		pacienteDTO = new PacienteDTO();
		double avg = list.stream().filter(p -> p.getSexo().equals(sexo)).map(p -> p.getIdade()).reduce((int) 0.0,
				(x, y) -> x + y) / list.size();

		pacienteDTO.setDescricao("Idade média dos homens = " + avg);

		objDTO.add(pacienteDTO);

		pacienteDTO = new PacienteDTO();

		List<String> qtdMulher = list.stream().filter(p -> p.getAltura() > 1.60).filter(p -> p.getAltura() < 1.70)
				.filter(p -> p.getPeso() > 70).filter(p -> p.getSexo().equals("Fem")).map(p -> p.getNome()).sorted(comp)
				.collect(Collectors.toList());
		pacienteDTO
				.setDescricao("Nome= " + qtdMulher + " Quantidade de mulher 1.60 e 1.70 / 70kg = " + qtdMulher.size());

		objDTO.add(pacienteDTO);

		pacienteDTO = new PacienteDTO();

		List<String> qtdPessoa18a25 = list.stream().filter(p -> p.getIdade() > 18).filter(p -> p.getIdade() < 25)
				.map(p -> p.getNome()).sorted(comp).collect(Collectors.toList());

		pacienteDTO.setDescricao("Qtd pessoa entre 18 e 25 = " + qtdPessoa18a25.size());

		objDTO.add(pacienteDTO);

		pacienteDTO = new PacienteDTO();

		Comparator<Paciente> comp2 = Comparator.comparing(Paciente::getIdade);
		Paciente pasMaisVelho = list.stream().filter(p -> p.getSexo().equals("Fem")).max(comp2).get();

		pacienteDTO.setDescricao("Pasiente mais velha = " + pasMaisVelho.getNome());

		objDTO.add(pacienteDTO);

		pacienteDTO = new PacienteDTO();

		Comparator<Paciente> comp3 = Comparator.comparing(Paciente::getIdade);
		Paciente pasMaisBaixa = list.stream().filter(p -> p.getSexo().equals("Fem")).min(comp3).get();

		pacienteDTO.setDescricao("Pasiente mais velha = " + pasMaisBaixa.getNome());

		objDTO.add(pacienteDTO);

		return objDTO;

	}

}
