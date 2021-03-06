package br.com.loopback.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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
		System.out.println("Chamando m�todo GET");

		String acao= request.getParameter("acao");
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = new Usuario();
		
		if(acao!=null && acao.equals("exc")){			
			
			int id= Integer.parseInt(request.getParameter("id"));			
			usuario.setId(id);		
			
			usuarioDAO.excluir(usuario);
			
			
		}
		
		if(acao!=null && acao.equals("alt")  ) {
			String id2= request.getParameter("id");
			usuario = usuarioDAO.buscaPorId(Integer.parseInt(id2));
			
			request.setAttribute("usuario",usuario);
			
			RequestDispatcher saida =request.getRequestDispatcher("frmusuario.jsp");
			saida.forward(request, response);
		}
		else {
			ArrayList<Usuario> listausuario;
			listausuario = usuarioDAO.BuscarTodos();
//				PrintWriter saida =response.getWriter();
			
			
			
			//Atribuir no request a lista
			request.setAttribute("lista", listausuario);

			
			//Encaminhamento ao listausuarios.JSP
			
			RequestDispatcher saida =request.getRequestDispatcher("listausuarios.jsp");
			saida.forward(request, response);	
		}
						
		
			
		
		
			
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//doGet(request, response);
		System.out.println("Chamando m�todo Post");
		
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
