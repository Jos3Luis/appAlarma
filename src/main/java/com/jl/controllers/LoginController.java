package com.jl.controllers;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.jl.entities.Cliente;
import com.jl.models.ClienteModel;
import com.opensymphony.xwork2.ActionSupport;

public class LoginController extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	private String dni;
	private String clave;
	
	private String msg;
	
	private ClienteModel modelo;
	private Map<String, Object> session;
	public LoginController() {
		 modelo = new ClienteModel();
		 msg="";
	}
	
	
	public String login(){
		msg="";
		List<Cliente> L=modelo.listar();
		Cliente x=null;
		for (Cliente cliente : L) {
			if (cliente.getDni().equals(dni) && cliente.getClave().equals(clave)) {
				x=cliente;//
				break;
			}
		}
		if (x!=null) {
			session.put("cliente",x);
		}else{
			msg="Error, Autentificacion invalida";
			return ERROR;
		}
		return SUCCESS;
	} 

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}



	public void setSession(Map<String, Object> session) {
		this.session = session; 
	}
	 
	
	
	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}
 
}
