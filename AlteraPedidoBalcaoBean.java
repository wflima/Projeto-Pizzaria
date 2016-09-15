package br.com.faculdadeDelta.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.faculdadeDelta.dao.AlteraPedidoBalcaoDao;
import br.com.zmap.modelo.Pedido;


@ManagedBean
@SessionScoped
public class AlteraPedidoBalcaoBean {
	
	 private Pedido pedido;
	 private AlteraPedidoBalcaoDao dao;
	 
	 
	public AlteraPedidoBalcaoBean() {
		pedido = new Pedido();
		dao = new AlteraPedidoBalcaoDao();
	
	}


	public Pedido getPedido() {
		return pedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}


	public AlteraPedidoBalcaoDao getDao() {
		return dao;
	}


	public void setDao(AlteraPedidoBalcaoDao dao) {
		this.dao = dao;
	}
	 public String alteraPedidoBalcao(Pedido pedido) {
		 if (pedido.getId() !=null && pedido.getId()>0) {
			 try {
				dao.alteraPedioBalcao(pedido);
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
		return "PedidoBalcao.xhtml";
	 }
	 public List<Pedido> getListarTodosPedidosBalcao(){
		 List<Pedido> listaRetorno = new ArrayList<Pedido>();
		 try {
			listaRetorno = dao.listarTodosPedidosBalcao();
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
