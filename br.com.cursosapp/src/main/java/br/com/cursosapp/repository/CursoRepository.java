package br.com.cursosapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cursosapp.model.Aluno;
import br.com.cursosapp.model.Curso;

public interface CursoRepository  extends JpaRepository<Curso, String>{
	Curso findById(long id);
	Iterable<Curso> findByAluno(Aluno aluno);

}
