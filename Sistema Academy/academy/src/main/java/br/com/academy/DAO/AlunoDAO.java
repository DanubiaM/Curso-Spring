package br.com.academy.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.academy.model.Aluno;

// JpaRepository<Aluno, Integer> 'Aluno' é o nome da classe que sera utilzada para criar um db, e Integer é tipo do atributo identificado
public interface AlunoDAO extends JpaRepository<Aluno, Integer> {

	@Query("Select resultado from Aluno resultado where resultado.status = 'ATIVO' ")
	public List<Aluno> findByStatusAtivos();
	
}
