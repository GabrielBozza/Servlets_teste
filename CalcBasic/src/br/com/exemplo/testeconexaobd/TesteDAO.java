package br.com.exemplo.testeconexaobd;

import java.util.List;

import br.com.exemplo.beans.Usuario;
import br.com.exemplo.jdbc.UsuarioDAO;

public class TesteDAO {

	public static void main(String[] args) {
		//testeCadastro();
		//testeAlterar();
		//testeDeletar();
		testeBuscarTodos();
	}
	
	public static void testeCadastro() {
		Usuario usuario = new Usuario();
		usuario.setNome("Gabriel Bozza");
		usuario.setIdade(21);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.cadastro(usuario);
	}
	
	public static void testeAlterar() {
		Usuario usuario = new Usuario();
		usuario.setNome("Gabriel Bozza");
		usuario.setIdade(22);
		usuario.setId(1);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.alterar(usuario);
	}
	
	public static void testeDeletar() {
		Usuario usuario = new Usuario();
		usuario.setId(2);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.deletar(usuario);
	}
	
	public static void testeBuscarTodos() {
		Usuario usuario = new Usuario();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		List<Usuario> listaResultado = usuarioDAO.buscarTodos(usuario);
		
		for(Usuario u: listaResultado) {
			System.out.println("Id: " + u.getId() + " Nome: " + u.getNome() + " Idade: " + u.getIdade());
		}
		
	}

}
