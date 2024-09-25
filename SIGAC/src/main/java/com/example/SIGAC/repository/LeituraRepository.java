package com.example.SIGAC.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SIGAC.models.entities.Leitura;

public interface LeituraRepository extends JpaRepository<Leitura, Long> {

	List<Leitura> findByEquipamentoId(Long equipamentoId);

}
