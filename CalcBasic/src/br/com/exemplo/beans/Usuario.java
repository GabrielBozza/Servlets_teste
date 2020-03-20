package br.com.exemplo.beans;

//CLASSE QUE REPRESENTA UMA TABELA(OBJ DO BD) 
public class Usuario {
	
	private Integer idusuario;
	private String nome;
	private Integer idade;

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

}
