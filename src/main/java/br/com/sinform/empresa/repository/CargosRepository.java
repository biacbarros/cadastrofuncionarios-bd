package br.com.sinform.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sinform.empresa.model.Cargo;

public interface CargosRepository extends JpaRepository<Cargo, Long>{

}
