package br.com.academy.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academy.DAO.UsuarioDAO;
import br.com.academy.exceptions.CriptoExistException;
import br.com.academy.exceptions.EmailExistsException;
import br.com.academy.model.Usuario;
import br.com.util.Util;

@Service	
public class ServiceUsuario {

	@Autowired
	private UsuarioDAO repositoriousuario;
	
	public void salvarUsuario(Usuario user) throws Exception {
		try {
			if( repositoriousuario.findByEmail(user.getEmail()) != null){
				throw new EmailExistsException("Já existe um email cadastrado para: "+ user.getEmail());
			
			}
			user.setSenha(Util.md5(user.getSenha()));
		}catch (NoSuchAlgorithmException ex) {
			throw new CriptoExistException("Erro na criptografia da senha");

		}
		repositoriousuario.save(user);

	}
	
	public Usuario longinUser(String user, String senha) throws serviceException{
		Usuario userLogin = repositoriousuario.buscarLogin(user, senha);
		
		return userLogin;
		
	}

}
