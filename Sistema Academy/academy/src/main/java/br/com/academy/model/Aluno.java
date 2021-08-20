package br.com.academy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.acaedmy.Enum.Cursos;
import br.com.acaedmy.Enum.Status;

@Entity
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "nome")
	@Size(min = 5, max = 35, message = "O nome deve conter no mínimo 5 caracteres")
	@NotBlank(message = "O nome não pode ser vazio.")
	private String nome;
	
	
	@Column(name = "curso")
	@Enumerated(EnumType.STRING)
	@NotBlank(message = "O curso não pode ser vazio.")
	private Cursos curso;
	
	@Column(name="matricula")
	@NotNull(message = "Clique no botão gerar!")
	private String matricula;
	
	@Column(name="status")
	@NotBlank(message = "O status não pode ser vazio.")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name = "turno")
	@NotBlank(message = "O turno não pode ser vazio.")
	@Size(min = 4, max = 35, message = "O nome deve conter no mínimo 4 caracteres")
	private String turno;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cursos getCurso() {
		return curso;
	}

	public void setCurso(Cursos curso) {
		this.curso = curso;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	
}
