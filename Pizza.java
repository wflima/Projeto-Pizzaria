package br.com.zmap.modelo;

import java.io.Serializable;

public class Pizza implements Serializable{


	
	private static final long serialVersionUID = -7016862572045616175L;
	private Long id;
	private String nome;
	private String ingre_pizza;
	private int quantidade;
	private int coMesa;
	
	
	
	public Pizza() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pizza(Long id, String nome, String ingre_pizza, int quantidade,
			int coMesa) {
		super();
		this.id = id;
		this.nome = nome;
		this.ingre_pizza = ingre_pizza;
		this.quantidade = quantidade;
		this.coMesa = coMesa;
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
	public String getIngre_pizza() {
		return ingre_pizza;
	}
	public void setIngre_pizza(String ingre_pizza) {
		this.ingre_pizza = ingre_pizza;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getCoMesa() {
		return coMesa;
	}
	public void setCoMesa(int coMesa) {
		this.coMesa = coMesa;
	
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
		Pizza other = (Pizza) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
