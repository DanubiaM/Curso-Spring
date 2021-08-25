package br.com.academy.DAO;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.academy.model.Usuario;


public interface UsuarioDAO extends JpaRepository <Usuario, Long> {
	@Query("select resultado from Usuario resultado where resultado.email = :email")
	public Usuario findByEmail(String email);
	
	@Query("select resultado from Usuario resultado where resultado.user = :user and resultado.senha = :senha")
	public Usuario buscarLogin(String user, String senha);
}
