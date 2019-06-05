package br.com.testeibm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.testeibm.domain.Paciente;
@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Integer> {

}
