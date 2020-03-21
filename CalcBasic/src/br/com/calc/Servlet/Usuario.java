package br.com.calc.Servlet;

import java.sql.Date;

//CLASSE QUE REPRESENTA UMA TABELA(OBJ DO BD) 
public class Usuario {

	private Integer idusuario;
	private String nome;
	private Integer idade;
	private String email;
	private String senha;
	private Date datainscricao;

	public Integer getId() {
		return idusuario;
	}

	public void setId(Integer id) {
		this.idusuario = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDatainscricao() {
		return datainscricao;
	}

	public void setDatainscricao(Date datainscricao) {
		this.datainscricao = datainscricao;
	}

}
