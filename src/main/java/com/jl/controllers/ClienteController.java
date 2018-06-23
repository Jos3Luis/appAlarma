package com.jl.controllers;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.bson.types.ObjectId; 

import com.jl.entities.Cliente; 
import com.jl.models.ClienteModel;
import com.opensymphony.xwork2.ActionSupport;


public class ClienteController extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String _id;
	private String dni;
	private String clave; 
	private String nombres;
	private String paterno;
	private String materno;
	private String correo;
	private String celular;
	private String telefono;
	
	private List<Cliente> clientes;
	private Map<String, Object> session;
	
	private String msg;

	private ClienteModel modelo;

	public ClienteController() {
		msg="";
		modelo = new ClienteModel(); 
	} 
	public String actualizarCliente() {		
		 Cliente c=modelo.buscar(new ObjectId(_id)); 
		 nombres=c.getNombres();
		 paterno=c.getPaterno();
		 materno=c.getMaterno();
		 dni=c.getDni();
		 correo=c.getDni();
		 celular=c.getCelular();
		 telefono=c.getTelefono();
		 clave=c.getClave(); 
		return SUCCESS;
	}
	public String actualizarClientePost() {		
		Cliente x = new Cliente();
		x.set_id(new ObjectId(_id));
		x.setNombres(nombres);
		x.setPaterno(paterno);
		x.setMaterno(materno);
		x.setDni(dni);
		x.setCorreo(correo);
		x.setCelular(celular);
		x.setTelefono(telefono);
		x.setClave(clave);
		x.setFecha_creacion(new Date());
		x.setEstado(1); 
		int n=modelo.actualizar(x);
		listarClientes();
		if (n==1) {
			msg="Se ha Actualizado con exito";
		}else {
			msg="Error al Actualizar: "+modelo.getError();
		}
		return SUCCESS;
	}
	public String eliminarCliente(){ 
		int n=modelo.eliminar(new ObjectId(_id));
		listarClientes();
		if (n==1) {
			msg="Se ha eliminado con exito";
		}else {
			msg="Error al eliminar: "+modelo.getError();
		}
		return SUCCESS;
	}
	
	public String eliminarClienteAction() {
		return SUCCESS;
	}
	
	public String grabarCliente() {
		Cliente x = new Cliente();		
		x.setNombres(nombres);
		x.setPaterno(paterno);
		x.setMaterno(materno);
		x.setDni(dni);
		x.setCorreo(correo);
		x.setCelular(celular);
		x.setTelefono(telefono);
		x.setClave(clave);
		x.setFecha_creacion(new Date());
		x.setEstado(1); 
		int res=modelo.insertar(x);
		if (res==1) {
			msg="Se ha Guardado con exito";
		}else {
			msg="Error al Guardar: "+modelo.getError();
		}  
		return SUCCESS;
	}
	public String actualizarPerfil(){
		HttpSession session=ServletActionContext.getRequest().getSession(false); 		
		Cliente c=(Cliente)session.getAttribute("Cliente");
		if (c!=null) {
			 nombres=c.getNombres();
			 paterno=c.getPaterno();
			 materno=c.getMaterno();
			 dni=c.getDni();
			 correo=c.getDni();
			 celular=c.getCelular();
			 telefono=c.getTelefono();
			 clave=c.getClave(); 
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String listarClientes(){ 
		clientes=modelo.listar();		
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

	 
	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}	

	public ClienteModel getModelo() {
		return modelo;
	}

	public void setModelo(ClienteModel modelo) {
		this.modelo = modelo;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	/*
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;  
	}*/
	 

}
