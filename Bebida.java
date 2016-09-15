package br.com.zmap.modelo;

import java.io.Serializable;

public class Bebida implements Serializable{
	
	
	private static final long serialVersionUID = 2420481537779582215L;
	private Long id;
	private String descricao;
	private String tipoBebida;
	private Double preco;
	private int quantidade;
	private Pedido objPedido;
	private int coMesa;
	
	public Bebida(Pedido objPedido) {
		
		this.objPedido = objPedido;
	}

	
	public Bebida(Long id, String descricao, String tipoBebida, Double preco,
			int quantidade, Pedido objPedido, int coMesa) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.tipoBebida = tipoBebida;
		this.preco = preco;
		this.quantidade = quantidade;
		this.objPedido = objPedido;
		this.coMesa = coMesa;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getTipoBebida() {
		return tipoBebida;
	}

	public void setTipoBebida(String tipoBebida) {
		this.tipoBebida = tipoBebida;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public Pedido getObjPedido() {
		return objPedido;
	}


	public void setObjPedido(Pedido objPedido) {
		this.objPedido = objPedido;
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
		Bebida other = (Bebida) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
