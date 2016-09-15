package br.com.zmap.modelo;

import java.io.Serializable;
import java.util.Date;

public class Funcionario implements Serializable{
	
	
	private static final long serialVersionUID = 860700650335452648L;
	private Long id;
	private String nome;
	private String idade;
	private String rg;
	private String cpf;
	private String endereço;
	private Date dataAdmicao;
	private String sexo;
	
	
	public Funcionario() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Funcionario(Long id, String nome, String idade, String rg,
			String cpf, String endereço, Date dataAdmicao, String sexo) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.rg = rg;
		this.cpf = cpf;
		this.endereço = endereço;
		this.dataAdmicao = dataAdmicao;
		this.sexo = sexo;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getIdade() {
		return idade;
	}


	public void setIdade(String idade) {
		this.idade = idade;
	}


	public String getRg() {
		return rg;
	}


	public void setRg(String rg) {
		this.rg = rg;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getEndereço() {
		return endereço;
	}


	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}


	public Date getDataAdmicao() {
		return dataAdmicao;
	}


	public void setDataAdmicao(Date dataAdmicao) {
		this.dataAdmicao = dataAdmicao;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
