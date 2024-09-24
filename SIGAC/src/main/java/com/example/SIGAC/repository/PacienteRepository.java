package com.example.SIGAC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.SIGAC.models.entities.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
	
	@Query("SELECT COUNT(p) FROM Paciente p WHERE p.idade > :idade")
    Long countPacientesIdadeMaiorQue(@Param("idade") int idade);
	@Query("SELECT COUNT(p) FROM Paciente p WHERE p.idade = :idade")
    Long countPacientesIdadeIgual(@Param("idade") int idade);
	@Query("SELECT COUNT(p) FROM Paciente p WHERE p.idade BETWEEN :minIdade AND :maxIdade")
    Long countPacientesEntreIdade(@Param("minIdade") int minIdade, @Param("maxIdade") int maxIdade);
}
