package br.com.faculdadeDelta.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.faculdadeDelta.dao.PesquisarPedidosMesaDao;
import br.com.zmap.modelo.Pedido;

@ManagedBean
@SessionScoped
public class PesquisarPedidoMesaBean {
	
	private Pedido pedido;
	private PesquisarPedidosMesaDao dao;
	List<Pedido> listaRetorno;
	
	public PesquisarPedidoMesaBean() {
		pedido = new Pedido();
		dao = new PesquisarPedidosMesaDao();
	}


	public Pedido getPedido() {
		return pedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public void limparCampos() {
		pedido = new Pedido();
		
	}
	public List<Pedido> getListarTodosPedido() {
		
		
		listaRetorno = new ArrayList<Pedido>();
			try {
				listaRetorno = dao.pesquisarPedidosPorMesa(pedido);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			 return listaRetorno;
	}
	public void pesquisarMesas(){
		
		listaRetorno = new ArrayList<Pedido>();
		
		try {
			listaRetorno = dao.pesquisarPedidosPorMesa(pedido);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	public String removerMesa(Pedido pedido){
		try {
			dao.removerMesa(pedido);
			FacesMessage mensagem = new FacesMessage("Conta Encerrada Com Sucesso: *");
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
		
	
	return "ListaDeMesas.xhtml";
	}
}
