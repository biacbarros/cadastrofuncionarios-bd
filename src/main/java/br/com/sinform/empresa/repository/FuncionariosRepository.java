package br.com.sinform.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sinform.empresa.model.Funcionario;

public interface FuncionariosRepository extends JpaRepository<Funcionario, Long> {
	

}
