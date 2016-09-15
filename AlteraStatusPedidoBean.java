package br.com.faculdadeDelta.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.faculdadeDelta.dao.AlteraStatusPedidoDao;
import br.com.zmap.modelo.Pedido;


@ManagedBean
@SessionScoped
public class AlteraStatusPedidoBean {
	
	private Pedido pedido;
	private AlteraStatusPedidoDao dao;
	
	
	public AlteraStatusPedidoBean() {
		pedido = new Pedido();
		dao = new AlteraStatusPedidoDao();
	}


	public Pedido getPedido() {
		return pedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}


	public AlteraStatusPedidoDao getDao() {
		return dao;
	}


	public void setDao(AlteraStatusPedidoDao dao) {
		this.dao = dao;
	}
	
	public String alterarPedido(Pedido pedido) {
		if(pedido.getId() !=null && pedido.getId() > 0){
			try {
				dao.alterarPedido(pedido);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("","Pedido finalizado com Sucesso !") );
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
		return "Pedidos.xhtml";
	}
	
	
	public List<Pedido> getListarTodosPedidos(){
		List<Pedido> listaRetorno = new ArrayList<Pedido>();
		try {
			listaRetorno = dao.litarTodosPedidos();
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
