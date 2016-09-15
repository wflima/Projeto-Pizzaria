package br.com.faculdadeDelta.bean;

import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.faculdadeDelta.dao.IncluirPizzaDao;
import br.com.zmap.modelo.Pizza;

@ManagedBean
@SessionScoped
public class IncluirPizzaBean {
	
	private Pizza pizza;
	private IncluirPizzaDao dao;
	private int objPizza;
	private int objMesa;
	
	
	
	
	public IncluirPizzaBean() {
		pizza = new Pizza();
		dao = new IncluirPizzaDao();
		objPizza = 0;
		objMesa = 0;
		
	}

 
	public Pizza getPizza() {
		return pizza;
	}


	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}


	public int getObjPizza() {
		return objPizza;
	}


	public void setObjPizza(int objPizza) {
		this.objPizza = objPizza;
	}

	public IncluirPizzaDao getDao() {
		return dao;
	}
	

	public int getObjMesa() {
		return objMesa;
	}


	public void setObjMesa(int objMesa) {
		this.objMesa = objMesa;
	}


	public void setDao(IncluirPizzaDao dao) {
		this.dao = dao;
	}
	public void limparCampos() {
		objPizza = 0;
		objMesa = 0;
		
	}
	public String incluirPizza(Pizza pizza) {
		try {
			pizza.setCoMesa(objMesa);
			pizza.setQuantidade(objPizza);
			dao.incluirPizza(pizza);
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
		return "IncluirPizza.xhtml";
	}
	

}