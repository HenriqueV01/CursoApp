package br.com.cursosapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cursosapp.model.Aluno;

public interface AlunoRepository  extends JpaRepository<Aluno, String>{
	Aluno findById(long id);

}
