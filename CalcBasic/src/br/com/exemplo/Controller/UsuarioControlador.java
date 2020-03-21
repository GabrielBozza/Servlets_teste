package br.com.exemplo.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.exemplo.bean .Usuario;
import br.com.exemplo.jdbc.UsuarioDAO;
/**
 * Servlet implementation class UsuarioControlador
 */
@WebServlet("/UsuarioControlador")
public class UsuarioControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioControlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Usuario usu = new Usuario();
		String acao = request.getParameter("acao");
		UsuarioDAO usuDAO = new UsuarioDAO();
	
		if(acao != null && acao.equals("lis")){
		List<Usuario> lista = usuDAO.buscarTodos(usu);
		request.setAttribute("lista", lista);
		RequestDispatcher saida = request.getRequestDispatcher("listaUsuarios.jsp");
		saida.forward(request, response);

		}else if(acao != null && acao.equals("ex")){
			String id = request.getParameter("id");
			usu.setId(Integer.parseInt(id));
			usuDAO.deletar(usu);
			response.sendRedirect("UsuarioControlador?acao=lis");
			
		}else if(acao != null && acao.equals("alt")){
			String id = request.getParameter("id");
			Usuario usuario = usuDAO.buscarporID(Integer.parseInt(id));
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher("AlterarCadastro.jsp").forward(request,response);
			//AlterarCad.jsp
		
		}else if(acao != null && acao.equals("cad")){
			RequestDispatcher saida = request.getRequestDispatcher("cadastro.jsp");
			saida.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Capturando parametros da tela
		
				String sid = request.getParameter("id");
				String snome = request.getParameter("nome");
				String sidade = request.getParameter("idade");
				String semail = request.getParameter("email");
				String ssenha = request.getParameter("senha");
				String sdata = request.getParameter("data");
				
				try{
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					Date data = new Date(format.parse(sdata).getTime());

				// criando objeto usuario e atribuindo valores da tela
				Usuario usuario = new Usuario();
				usuario.setNome(snome);
				usuario.setIdade(Integer.parseInt(sidade));
				usuario.setEmail(semail);
				usuario.setSenha(ssenha);
				usuario.setDatainscricao(data);
				usuario.setId(Integer.parseInt(sid));

				// criando um usuarioDAO
				UsuarioDAO usuDao = new UsuarioDAO();
				// Salvando no banco de dados
				usuDao.alterar(usuario);
				//PrintWriter out = response.getWriter();
				//out.println("Salvo!");
				response.sendRedirect("UsuarioControlador?acao=lis");
				} catch (java.text.ParseException e) {
					System.out.println("Erro de Data - "+e.getMessage());
				}
	}

}
