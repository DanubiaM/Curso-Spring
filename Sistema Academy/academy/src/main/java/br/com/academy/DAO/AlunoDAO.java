package br.com.academy.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.academy.model.Aluno;

public interface AlunoDAO extends JpaRepository<Aluno, Integer> {

}
