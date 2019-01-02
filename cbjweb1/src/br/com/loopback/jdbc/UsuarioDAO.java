package br.com.loopback.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import br.com.loopback.entidade.Usuario;

public class UsuarioDAO {
	
	private Connection con = Conexao.getConnection();
	
	public void cadastrar(Usuario usu) {
		
		String sql = "INSERT INTO usuario (nome, login, senha) VALUES (?,?,md5(?))";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1,usu.getNome());
			preparador.setString(2,usu.getLogin());
			preparador.setString(3,usu.getSenha());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Usuario cadastrado com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Falha ao cadastrar");
		}
		
		
	}
	
	public void alterar(Usuario usu) {
			
			String sql = "UPDATE usuario SET nome=?, login=?, senha=md5(?) WHERE id=?";
			
			try {
				PreparedStatement preparador = con.prepareStatement(sql);
				preparador.setString(1,usu.getNome());
				preparador.setString(2,usu.getLogin());
				preparador.setString(3,usu.getSenha());
				preparador.setInt(4,usu.getId());
				
				preparador.execute();
				preparador.close();
				
				System.out.println("Atualizado com sucesso!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Falha ao Atualizar");
			}
			
			
		}
	
	public void excluir(Usuario usu) {
		
		String sql = "DELETE  FROM usuario WHERE id=?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1,usu.getId());
	
			preparador.execute();
			preparador.close();
			
			System.out.println("Excluído com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Falha ao excluir");
		}
		
		
	}
	
	public ArrayList<Usuario> BuscarTodos() {
		
		String sql = "SELECT * FROM usuario ORDER BY ID";
		
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
	
			ResultSet resultado = preparador.executeQuery();
			
			while (resultado.next()) {
				
				Usuario usu = new Usuario();
				usu.setId(resultado.getInt("id"));
				usu.setNome(resultado.getString("nome"));
				usu.setLogin(resultado.getString("login"));
				usu.setSenha(resultado.getString("senha"));
				
				lista.add(usu);
				
			}
			
			preparador.close();
			
			System.out.println("Busca com Sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Falha ao cadastrar");
		}
		
		return lista;
		
	}

	public Usuario buscaPorId(Integer id) {
		String sql = "SELECT * FROM usuario WHERE id=?";
		Usuario usu = null;
		
		
		PreparedStatement preparador;
		try {
			preparador = con.prepareStatement(sql);
			preparador.setInt(1, id);		
			
			
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()) {
				usu = new Usuario();
				usu.setId(id);
				usu.setLogin(resultado.getString("login"));
				usu.setNome(resultado.getString("nome"));
				usu.setSenha(resultado.getString("senha"));			
			}
			else {
				System.out.println("Usuario não existente");
			}
			
			
			
			
			System.out.println("Sucesso ao buscar");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Falha ao buscar");
		
		}
		
		return usu;
		
	}
	public Usuario buscaPorNome(String nome) {
		String sql = "SELECT * FROM usuario WHERE nome like %?%";
		Usuario usu = null;
		
		
		PreparedStatement preparador;
		try {
			preparador = con.prepareStatement(sql);
			preparador.setString(1, nome);		
			
			
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()) {
				usu = new Usuario();
				usu.setId(resultado.getInt("id"));
				usu.setLogin(resultado.getString("login"));
				usu.setNome(resultado.getString("nome"));
				usu.setSenha(resultado.getString("senha"));			
			}
			else {
				System.out.println("Usuario não existente");
			}
			
			
			
			
			System.out.println("Sucesso ao buscar");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Falha ao buscar");
		
		}
		
		return usu;
		
	}
	public Usuario autenticar(Usuario usu) {
		String sql = "SELECT * FROM usuario WHERE login=? AND senha=md5(?)";
		Usuario usuarioRetorno = null;
		
		
		PreparedStatement preparador;
		try {
			preparador = con.prepareStatement(sql);
			preparador.setString(1, usu.getLogin());
			preparador.setString(2,usu.getSenha());
			
			
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()) {
				usuarioRetorno = new Usuario();
				usuarioRetorno.setId(resultado.getInt("id"));
				usuarioRetorno.setLogin(resultado.getString("login"));
				usuarioRetorno.setNome(resultado.getString("nome"));
				usuarioRetorno.setSenha(resultado.getString("senha"));			
			}
			else {
				System.out.println("Usuario não existente");
			}
			
						
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Falha ao buscar");
		
		}
		
		return usuarioRetorno;
		
	}
	public void salvar(Usuario usuario) {
		if(usuario.getId()==null && usuario.getId()==0) {
			cadastrar(usuario);
		}
		else {
			alterar(usuario);
		}
		
	}

}
