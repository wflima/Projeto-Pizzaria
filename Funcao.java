package br.com.zmap.modelo;

import java.io.Serializable;

public class Funcao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7159305063676196036L;
	private Long idFuncao;
	private String nomeFuncao;
	private String descricaoFuncao;

	public Funcao(Long idFuncao, String nomeFuncao, String descricaoFuncao) {
		super();
		this.idFuncao = idFuncao;
		this.nomeFuncao = nomeFuncao;
		this.descricaoFuncao = descricaoFuncao;
	}

	public Funcao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdFuncao() {
		return idFuncao;
	}

	public void setIdFuncao(Long idFuncao) {
		this.idFuncao = idFuncao;
	}

	public String getNomeFuncao() {
		return nomeFuncao;
	}

	public void setNomeFuncao(String nomeFuncao) {
		this.nomeFuncao = nomeFuncao;
	}

	public String getDescricaoFuncao() {
		return descricaoFuncao;
	}

	public void setDescricaoFuncao(String descricaoFuncao) {
		this.descricaoFuncao = descricaoFuncao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idFuncao == null) ? 0 : idFuncao.hashCode());
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
		Funcao other = (Funcao) obj;
		if (idFuncao == null) {
			if (other.idFuncao != null)
				return false;
		} else if (!idFuncao.equals(other.idFuncao))
			return false;
		return true;
	}

}
