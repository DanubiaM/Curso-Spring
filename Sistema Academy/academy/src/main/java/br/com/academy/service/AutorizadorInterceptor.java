package br.com.academy.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;



public class AutorizadorInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object UsuarioController) throws Exception{
		
		
		String uri = request.getRequestURI();
		//paginas permitidas
		if(uri.endsWith("cadastro") || uri.endsWith("/salvarUsuario") ||  uri.endsWith("/") ||   uri.endsWith("login") || uri.contains("AlunoController")  || uri.contains("/")  ) {
			
			return true;
		}
		
		//caso o usuario logado não seja nulo retorna verdadeiro
		if(request.getSession().getAttribute("usuarioLogado") != null) {
			return true;
		}
		
		//caso não esteja logado, redireciona para o login e retorna false.
		response.sendRedirect("/logout");
		return false;
	}
}
