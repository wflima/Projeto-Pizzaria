package br.com.faculdadeDelta.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.faculdadeDelta.dao.SalvarPizzaDao;
import br.com.zmap.modelo.Pizza;

@ManagedBean
@SessionScoped
public class SalvarPizzaBen {

	 private Pizza pizza;
	 private SalvarPizzaDao dao;
	
	 
	 
	public SalvarPizzaBen() {
		pizza = new Pizza();
		dao = new SalvarPizzaDao();
	}


	public Pizza getPizza() {
		return pizza;
	}


	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	 public void limparCampos(){
		 pizza = new Pizza();
	 }
	 
	 public String salvarPizza() {
		 if(pizza.getId() !=null && pizza.getId() >0) {
			 try {
				dao.alterarPizza(pizza);
				FacesMessage mensagem = new FacesMessage("Alteração realizada com Sucesso");
				FacesContext.getCurrentInstance().addMessage(null, mensagem);
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
		 }else{
			try {
				dao.incluirPizza(pizza);
				FacesMessage mensagem = new FacesMessage("Inclusão realizada com Sucesso");
				FacesContext.getCurrentInstance().addMessage(null, mensagem);
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
			
		 }
		 return "Pizza.xhtml";
	 }
	 public String removerPizza(Pizza pizza) {
		 try {
			dao.removerPizza(pizza);
			FacesMessage mensagem = new FacesMessage("Exclusão realizada com Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
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
		 return "Pizza.xhtml";
	 }
	 public String prepararParaEditarPizza(Pizza pizza){
		 this.pizza = pizza;
		 return "Pizza.xhtml";
		 
	 }
	 public List<Pizza> getListarTodasPizzas() {
		 List<Pizza> listaRetorno = new ArrayList<Pizza>();
		 try {
			listaRetorno = dao.listarTodasPizzas();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return listaRetorno;
	 }
}






