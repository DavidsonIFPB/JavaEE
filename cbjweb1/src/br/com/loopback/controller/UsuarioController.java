package br.com.loopback.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.loopback.entidade.Usuario;
import br.com.loopback.jdbc.UsuarioDAO;


@WebServlet("/usucontroller.do")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UsuarioController() {
        super();
  
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		System.out.println("Chamando método GET");

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		ArrayList<Usuario> listausuario;
		listausuario = usuarioDAO.BuscarTodos();
		PrintWriter saida =response.getWriter();
		
		for (Usuario u : listausuario){
			saida.println("ID: "+u.getId()+" Nome: "+u.getNome()+" Login: "+u.getLogin());			
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//doGet(request, response);
		System.out.println("Chamando método Post");
		
		String id = request.getParameter("txtid");
		String nome=request.getParameter("txtnome");
		String login=request.getParameter("txtlogin");
		String senha=request.getParameter("txtsenha");
		
		Usuario usuario = new Usuario();
		PrintWriter saida =response.getWriter();
		
		usuario.setLogin(login);
		usuario.setNome(nome);
		usuario.setSenha(senha);
		
		
		if(id!=null && id!="" && id!="0") {
			usuario.setId(Integer.parseInt(id));
			saida.println("Alterado");			
		}
		else {
			saida.println("Cadastrado");	
		}
		
		
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		usuarioDAO.salvar(usuario);
		
		
		
	}

}
