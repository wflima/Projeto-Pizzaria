package br.com.faculdadeDelta.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.faculdadeDelta.dao.SalvarFuncionarioDao;
import br.com.zmap.modelo.Funcionario;


@ManagedBean
@SessionScoped
public class SalvarFuncionarioBean {
	
	private Funcionario funcionario;
	private SalvarFuncionarioDao dao;
	
	
	public SalvarFuncionarioBean() {
		funcionario = new Funcionario();
		dao = new SalvarFuncionarioDao();
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


	public void limparCampos() {
		funcionario = new Funcionario();
		
	}
	public String salvarFuncionario() {
		if(funcionario.getId() !=null && funcionario.getId() > 0) {
			try {
			
				dao.alterarFuncionario(funcionario);
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
			
				dao.incluirFuncionario(funcionario);
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
		return "Funcionario.xhtml";
	}
	public String removerFuncionario(Funcionario funcionario) {
		try {
			dao.removerFuncionario(funcionario);
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
		return "Funcionario.xhtml";
	}
	public String prepararParaEditarFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
		return "Funcionario.xhtml";
	}
	public List<Funcionario> getListarTodosFuncionarios() {
		List<Funcionario> listaRetorno = new ArrayList<Funcionario>();
		try {
			listaRetorno = dao.listarTodosFuncionarios();
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
