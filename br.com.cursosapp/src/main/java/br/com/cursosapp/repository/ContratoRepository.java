package br.com.cursosapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cursosapp.model.Aluno;
import br.com.cursosapp.model.Contrato;

public interface ContratoRepository  extends JpaRepository<Contrato, String>{
	Contrato findById(long id);
	Iterable<Contrato> findByAluno(Aluno aluno);

}
