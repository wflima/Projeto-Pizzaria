package br.com.faculdadeDelta.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.faculdadeDelta.dao.SalvarUsuarioDao;
import br.com.zmap.modelo.Usuario;



@ManagedBean
@SessionScoped
public class SalvarUsuarioBean {
	
	 private Usuario usuario;
	 private SalvarUsuarioDao dao;
	 
	 
	public SalvarUsuarioBean() {
		usuario = new Usuario();
		dao = new SalvarUsuarioDao();
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	 public void limparCampos(){
		 usuario = new Usuario();
	 }
	 
	 
	 public String salvarUsuario() {
		 if (usuario.getId() !=null && usuario.getId() >0) {
			 try {
				dao.alterarUsuario(usuario);
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
				dao.incluirUsuario(usuario);
				FacesMessage mensagem = new FacesMessage("Cadastro Realisado Com sucesso");
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
		return "Usuario.xhtml";
		
	 }
	 public String removerUsuario(Usuario usuario) {
		 try {
			dao.removerUsuario(usuario);
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
		return "Usuario.xhtml";
	 }
	 
	 public String prepararParaEditarUsuario(Usuario usuario) {
		 this.usuario = usuario;
		 return "Usuario.xhtml";
	 }
	 
	 public List<Usuario> getListarTodosUsuarios() {
		 List<Usuario> listaRetorno = new ArrayList<Usuario>();
		 try {
			listaRetorno = dao.ListarTodosUsuarios();
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















