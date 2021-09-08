package br.com.academy.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;



public class AutorizadorInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object UsuarioController) throws Exception{
		
		
		String uri = request.getRequestURI();
		System.out.println("---------------");
		System.out.println(request.getSession().getAttribute("usuarioLogado"));
		
		//Casp o usuario não esteja logado, ou seja, null
		if (request.getSession().getAttribute("usuarioLogado") == null ) {
			System.out.println("Aqui 3?  uri:"+uri);
			
			//Libero cadastro, pagina de login e estilizantes para realizar visualização
			if (uri.endsWith("cadastro") || uri.endsWith("/salvarUsuario")  ||   uri.endsWith("login") || uri.contains("AlunoController") || uri.endsWith("/")  || uri.endsWith(".js") || uri.endsWith(".html")|| uri.endsWith(".png") || uri.endsWith(".jpg") ||  uri.endsWith(".css")) {
				System.out.println("Aqui 4?  uri:"+uri);
				
				return true;
			
			}
				// caso não seja nenhuma dessas paginas, ou seja, index, inserirAlunos, etc, ira redirecionar para o login
				response.sendRedirect("/");
				return false;
			
			
			
		}
		
		if (uri.endsWith("/error") ) {
			System.out.println("Aqui 2?  uri:"+uri);
			
			//caso não esteja logado, redireciona para o login e retorna false.
			response.sendRedirect("/logout");
			return false;
		}
		
		
		
		System.out.println("Aqui 1?  uri:"+uri);
		return true;
	}
}
