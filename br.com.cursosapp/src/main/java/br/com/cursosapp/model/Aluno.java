package br.com.cursosapp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Aluno implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(nullable=false, length=100)
	@NotBlank(message="Nome é uma informação obrigatória.")
	private String nome;
	
	@Column(nullable=false, length=100)
	@NotBlank(message="E-mail é uma informação obrigatória.")
	private String email;
	
	@Column(nullable=false, length=100)
	@NotBlank(message="CPF é uma informação obrigatória.")
	private String cpf;
	
	@Column(nullable=false, length=100)
	@NotBlank(message="Telefone é uma informação obrigatória.")
	private String telefone;
	
	@OneToMany
	@JoinColumn(name="cursos")
	private List<Curso> cursos;
	
	@OneToMany
	@JoinColumn(name="contratos")
	private List<Contrato> contratos;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public List<Contrato> getContratos() {
		return contratos;
	}
	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}
	public List<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	
}
