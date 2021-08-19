package br.com.academy.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.academy.model.Aluno;

// JpaRepository<Aluno, Integer> 'Aluno' é o nome da classe que sera utilzada para criar um db, e Integer é tipo do atributo identificado
public interface AlunoDAO extends JpaRepository<Aluno, Integer> {

}
