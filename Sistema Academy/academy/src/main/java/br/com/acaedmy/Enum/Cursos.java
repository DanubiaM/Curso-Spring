package br.com.acaedmy.Enum;

public enum Cursos {
	
	ADMINISTRACAO("Administracao"),
	INFORMATICA("Informatica"),
	CONTABILIDADE("Contabilidade"),
	PROGRAMACAO("Programacao"),
	ENFERMAGEM("Enfermagem");
	
	private String cursos;
	
	private Cursos(String cursos) {
		this.cursos = cursos;
	}
}
