package br.com.academy.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;



public class AutorizadorInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object UsuarioController) throws Exception{
		
		//paginas permitidas
		String uri = request.getRequestURI();
		if(uri.endsWith("cadastro") || uri.endsWith("logout") || uri.contains("resources")) {
			System.out.println("Aqui?  uri:"+uri);
			return true;
		}
		
		//caso o usuario logado não seja nulo retorna verdadeiro
		if(request.getSession().getAttribute("usuarioLogado") != null) {
			return true;
		}
		System.out.println("Aqui?  uri:"+uri);
		//caso não esteja logado, redireciona para o login e retorna false.
		response.sendRedirect("/logout");
		return false;
	}
}
