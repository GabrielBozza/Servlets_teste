package br.com.exemplo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.exemplo.beans.Usuario;

//CADA CLASSE DO BD TEM UM ARQ EM BEANS COM A SUA CLASSE E OUTRO NO JDBC (DAO-DATA ACCESS OBJECT) PARA RECUPERAR DADOS DO BD
public class UsuarioDAO {
	
	private Connection conexao = Conexao_BD.getConnection();
	
	public void cadastro(Usuario usuario) {
		
		String sql = "INSERT INTO USUARIO (nome, idade) values (?,?)";
		
		try {
			PreparedStatement preparador = conexao.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());//? 1
			preparador.setInt(2, usuario.getIdade());//? 2
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Cadastrado com sucesso!");
		}
		catch (SQLException e ){
			System.out.println("Erro - " + e.getMessage());
		}
		
	}
	
	public void alterar(Usuario usuario) {
		
		String sql = "UPDATE USUARIO SET NOME = ?, IDADE = ? WHERE IDUSUARIO = ?";
		
		try {
			PreparedStatement preparador = conexao.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());//? 1
			preparador.setInt(2, usuario.getIdade());//? 2
			preparador.setInt(3, usuario.getId());//? 3
			
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
}
