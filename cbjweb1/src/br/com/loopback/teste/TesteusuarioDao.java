package br.com.loopback.teste;

import java.awt.List;
import java.util.ArrayList;

import com.sun.glass.ui.CommonDialogs.Type;

import br.com.loopback.entidade.Usuario;
import br.com.loopback.jdbc.UsuarioDAO;

public class TesteusuarioDao {
	
	

	public static void main(String[] args) {
		//testCadastrar();
		//testAlterar();
		//testExcluir();
		//testBuscarTodos();
		//testBuscarporID(4);
		
		
		
		testAutenticar();
		
	

	}

	private static void testCadastrar() {
		Usuario usu = new Usuario();
		
		usu.setNome("Doublas");
		usu.setLogin("teste");
		usu.setSenha("doublas@123");
		
		UsuarioDAO c = new UsuarioDAO();
		c.cadastrar(usu);
	}
	
	private static void testAlterar() {
		
		Usuario usu = new Usuario();
		
		usu.setId(2);
		usu.setNome("joafdjs");
		usu.setLogin("ajdhf");
		usu.setSenha("asdfpj");
		
		UsuarioDAO c = new UsuarioDAO();
		c.alterar(usu);
		
		
		
	}
	private static void testExcluir() {
			
			Usuario usu = new Usuario();
			
			usu.setId(2);
			
			UsuarioDAO c = new UsuarioDAO();
			c.excluir(usu);		
			
		}
	
	private static void testBuscarTodos() {
		UsuarioDAO a = new UsuarioDAO();
		ArrayList<Usuario> lista = a.BuscarTodos();
		
		for(Usuario u: lista) {
			System.out.println(u.getId()+" "+ u.getNome()+" "+ u.getLogin()+ " "+ u.getSenha());
		}
		
		
	
	}
	private static void testBuscarporID(Integer id) {
		UsuarioDAO a = new UsuarioDAO();
		Usuario u;
		
		u=a.buscaPorId(id);
		if(u!=null) {
			System.out.println(u.getId()+" "+ u.getNome()+" "+ u.getLogin()+ " "+ u.getSenha());		
		}
		

		
	}
	private static void testAutenticar() {
		UsuarioDAO a = new UsuarioDAO();
		Usuario usu = new Usuario();
		
		usu.setLogin("teste");
		usu.setSenha("teste1235");

		
		usu=a.autenticar(usu);
		if(usu!=null) {
			System.out.println(usu.getId()+" "+ usu.getNome()+" "+ usu.getLogin());		
		}
		

		
	}

}
