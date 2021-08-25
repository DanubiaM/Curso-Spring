package br.com.academy.exceptions;

public class EmailExistsException extends Exception {

	public EmailExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	//definição da definição da classe, se não adicionarmos o proprio eplicse cria.
	private static final Long serialVersionUID = 1L;
}
