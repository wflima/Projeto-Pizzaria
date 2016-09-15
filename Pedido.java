package br.com.zmap.modelo;

public class Pedido {
	private Long id;
	private Long tipoProduto;
	private Long coProduto;
	private Long qtdeProduto;
	private Long coMesa;
	private Long status;
	private String descricao;
	
	private Bebida objBebida;
	private Pizza  objPizza;
	
	
	
	public Pedido(Bebida objBebida, Pizza objPizza) {
		super();
		this.objBebida = objBebida;
		this.objPizza = objPizza;
		
	}
	public Pizza getObjPizza() {
		return objPizza;
	}
	public void setObjPizza(Pizza objPizza) {
		this.objPizza = objPizza;
	}
	public Bebida getObjBebida() {
		return objBebida;
	}
	public void setObjBebida(Bebida objBebida) {
		this.objBebida = objBebida;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTipoProduto() {
		return tipoProduto;
	}
	public void setTipoProduto(Long tipoProduto) {
		this.tipoProduto = tipoProduto;
	}
	public Long getCoProduto() {
		return coProduto;
	}
	public void setCoProduto(Long coProduto) {
		this.coProduto = coProduto;
	}
	public Long getQtdeProduto() {
		return qtdeProduto;
	}
	public void setQtdeProduto(Long qtdeProduto) {
		this.qtdeProduto = qtdeProduto;
	}
	public Long getCoMesa() {
		return coMesa;
	}
	public void setCoMesa(Long coMesa) {
		this.coMesa = coMesa;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pedido(Long id, Long tipoProduto, Long coProduto, Long qtdeProduto,
			Long coMesa, Long status, String descricao) {
		super();
		this.id = id;
		this.tipoProduto = tipoProduto;
		this.coProduto = coProduto;
		this.qtdeProduto = qtdeProduto;
		this.coMesa = coMesa;
		this.status = status;
		this.descricao = descricao;
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
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	


}
