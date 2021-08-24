package br.com.academy.DAO;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.academy.model.Usuario;


public interface UsuarioDAO extends JpaRepository <Usuario, Long> {

}
