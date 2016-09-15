package br.com.faculdadeDelta.bean;

import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.faculdadeDelta.dao.IncluirBebidaDao;
import br.com.zmap.modelo.Bebida;
import br.com.zmap.modelo.Pedido;

@ManagedBean
@SessionScoped
public class IncluirBebidaBean {
	
	private Pedido pedido;
	private IncluirBebidaDao dao;
	private int objBebida;
	private int objMesa;
	
	
	
	public IncluirBebidaBean() {
	
		 pedido = new Pedido();
		 dao = new IncluirBebidaDao();
		 objBebida = 0;
		 objMesa = 0;
		 
	}



	public Pedido getPedido() {
		return pedido;
	}



	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	

	public int getObjMesa() {
		return objMesa;
	}



	public void setObjMesa(int objMesa) {
		this.objMesa = objMesa;
	}



	public int getObjBebida() {
		return objBebida;
	}



	public void setObjBebida(int objBebida) {
		this.objBebida = objBebida;
	}
	public void limparCampos(){
		pedido = new Pedido();
		objBebida = 0;
		objMesa = 0;
	}
	public String incluirBebida(Bebida bebida) {
		
		try {
			bebida.setCoMesa(objMesa);
			bebida.setQuantidade(objBebida);
			dao.incluirBebida(bebida);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ok",  "Seu Pedido Foi Enviado !") );
			limparCampos();
		} catch (ClassNotFoundException e) {
			FacesMessage messagem = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, messagem);
			e.printStackTrace();
		} catch (SQLException e) {
			FacesMessage messagem = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, messagem);
			e.printStackTrace();
		}
		return "IncluirBebida.xhtml";
	}
	
}
