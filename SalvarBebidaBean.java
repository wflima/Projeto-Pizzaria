package br.com.faculdadeDelta.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.faculdadeDelta.dao.SalvarBebidaDao;
import br.com.zmap.modelo.Bebida;


@ManagedBean
@SessionScoped
public class SalvarBebidaBean {
	
	private Bebida bebida;
	private SalvarBebidaDao dao;
	
	
	public SalvarBebidaBean() {
		bebida = new Bebida(null);
		dao = new SalvarBebidaDao();
			
	}


	public Bebida getBebida() {
		return bebida;
	}


	public void setBebida(Bebida bebida) {
		this.bebida = bebida;
	}


	public SalvarBebidaDao getDao() {
		return dao;
	}


	public void setDao(SalvarBebidaDao dao) {
		this.dao = dao;
	}
	public void limparCampos() {
		bebida = new Bebida(null);
	}
	public String salvarBebida(){
		if(bebida.getId() !=null && bebida.getId() > 0){
			try {
				dao.alterarBedida(bebida);
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
				dao.incluirBebidas(bebida);
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
		return "Bebida.xhtml";
	}
	
	public String removerBebida(Bebida bebida) {
		try {
			dao.removerBebida(bebida);
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
		return "Bebida.xhtml";
	}
	public String prepararParaEditar(Bebida bebida) {
		this.bebida = bebida;
		return "Bebida.xhtml";
	}
	public List<Bebida> getListartodasBebidas() {
		List<Bebida> listaRetorno = new ArrayList<Bebida>();
		try {
			listaRetorno = dao.listarTodasBebidas();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaRetorno;
	}
	
}





