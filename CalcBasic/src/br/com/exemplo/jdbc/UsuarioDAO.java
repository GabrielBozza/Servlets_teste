package br.com.exemplo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.exemplo.bean.Usuario;

//CADA CLASSE DO BD TEM UM ARQ EM BEANS COM A SUA CLASSE E OUTRO NO JDBC (DAO-DATA ACCESS OBJECT) PARA RECUPERAR DADOS DO BD
public class UsuarioDAO {
	
	private Connection conexao = Conexao_BD.getConnection();
	
	public void cadastro(Usuario usuario) {
		
		String sql = "INSERT INTO USUARIO (nome, idade, email, senha, datainscricao) values (?,?,?,?,?)";
		
		try {
			PreparedStatement preparador = conexao.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());//? 1
			preparador.setInt(2, usuario.getIdade());//? 2
			preparador.setString(3, usuario.getEmail());//? 3
			preparador.setString(4, usuario.getSenha());//? 4
			preparador.setDate(5, usuario.getDatainscricao());//? 5
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Cadastrado com sucesso!");
		}
		catch (SQLException e ){
			System.out.println("Erro - " + e.getMessage());
		}
		
	}
	
	public void alterar(Usuario usuario) {
		
		String sql = "UPDATE USUARIO SET NOME = ?, IDADE = ?, EMAIL = ?, SENHA = ?, DATAINSCRICAO = ?  WHERE IDUSUARIO = ?";
		
		try {
			PreparedStatement preparador = conexao.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());//? 1
			preparador.setInt(2, usuario.getIdade());//? 2
			preparador.setString(3, usuario.getEmail());//? 1
			preparador.setString(4, usuario.getSenha());//? 1
			preparador.setDate(5, usuario.getDatainscricao());//? 1
			preparador.setInt(6, usuario.getId());//? 3
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Alterado com sucesso!");
		}
		catch (SQLException e ){
			System.out.println("Erro - " + e.getMessage());
		}
		
	}
	
	public void deletar(Usuario usuario) {
		
		String sql = "DELETE FROM USUARIO WHERE IDUSUARIO = ?";
		
		try {
			PreparedStatement preparador = conexao.prepareStatement(sql);
			preparador.setInt(1, usuario.getId());//? 1
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Removido com sucesso!");
		}
		catch (SQLException e ){
			System.out.println("Erro - " + e.getMessage());
		}
		
	}
	
	public List<Usuario> buscarTodos(Usuario usuario) {
		
		String sql = "SELECT * FROM USUARIO";
		List<Usuario> lista = new ArrayList<Usuario>();
		
		try {
			PreparedStatement preparador = conexao.prepareStatement(sql);
			ResultSet resultados = preparador.executeQuery();
			
			while(resultados.next()){
				Usuario prox_usuario = new Usuario();
				
				prox_usuario.setId(resultados.getInt("idusuario"));
				prox_usuario.setNome(resultados.getString("nome"));
				prox_usuario.setIdade(resultados.getInt("idade"));
				prox_usuario.setEmail(resultados.getString("email"));
				prox_usuario.setSenha(resultados.getString("senha"));
				prox_usuario.setDatainscricao(resultados.getDate("datainscricao"));
				
				lista.add(prox_usuario);				
			}
		}
		catch (SQLException e ){
			System.out.println("Erro - " + e.getMessage());
		}
		
		return lista;
		
	}
	
	public Usuario buscarporID(Integer id) {
		
		Usuario usuRetorno = null;
		String sql = "SELECT * FROM USUARIO WHERE IDUSUARIO = ?";
		
		try {
			PreparedStatement preparador = conexao.prepareStatement(sql);
			preparador.setInt(1, id);
			
			ResultSet resultado = preparador.executeQuery();
		
			if (resultado.next()) {
				usuRetorno = new Usuario();
				usuRetorno.setId(resultado.getInt("idusuario"));
				usuRetorno.setNome(resultado.getString("nome"));
				usuRetorno.setIdade(resultado.getInt("idade"));
				usuRetorno.setEmail(resultado.getString("email"));
				usuRetorno.setSenha(resultado.getString("senha"));
				usuRetorno.setDatainscricao(resultado.getDate("datainscricao"));
			}
			
			System.out.println("Encontrado com sucesso!");
			
		} catch (SQLException e) {
			System.out.println("Erro de SQL:" + e.getMessage());
		}
		return usuRetorno;
	}
	
	public Usuario autenticacao(Usuario usuario) {
		
		Usuario usuRetorno = null;
		String sql = "SELECT * FROM USUARIO WHERE EMAIL = ? AND SENHA = ? ";
		
		try {
			PreparedStatement preparador = conexao.prepareStatement(sql);
			preparador.setString(1, usuario.getEmail());
			preparador.setString(2, usuario.getSenha());
			
			ResultSet resultado = preparador.executeQuery();
			
			if (resultado.next()) {
				usuRetorno = new Usuario();
				usuRetorno.setId(resultado.getInt("id"));
				usuRetorno.setNome(resultado.getString("nome"));
				usuRetorno.setIdade(resultado.getInt("idade"));
				usuRetorno.setEmail(resultado.getString("email"));
				usuRetorno.setSenha(resultado.getString("senha"));
				usuRetorno.setDatainscricao(resultado.getDate("datainscricao"));
			}
			
			System.out.println("Encontrado com sucesso!");
			
		} catch (SQLException e) {
			System.out.println("Erro de SQL:" + e.getMessage());
		}
		return usuRetorno;
	}
}
