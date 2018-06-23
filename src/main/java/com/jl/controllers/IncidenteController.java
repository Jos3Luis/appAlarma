package com.jl.controllers;

import java.util.Date;
import java.util.List;







import org.bson.types.ObjectId;

import com.jl.entities.Incidente;
import com.jl.models.IncidenteModel;
import com.opensymphony.xwork2.ActionSupport;

public class IncidenteController extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private String _id;
	private String idProducto;
	private Date fecha;
	private Date hora;
	private String detalles;
	private int estado;
	
	private String txtDetalles;
	
	private String msg;
	private List<Incidente> incidentes;
	
	private IncidenteModel modelo;
	
	public IncidenteController() {
		modelo= new IncidenteModel();
		msg="";
	}

	public String consultarIncidentes(){
		//msg=""; 
		incidentes=modelo.listar();	
		/*
		if (!modelo.getError().equals("")) {
			//msg=modelo.getError();
		}*/
		return SUCCESS;
	}
	
	public String registrarIncidente(){
		Incidente ic= new Incidente();
		ic.setIdProducto(idProducto);
		ic.setFecha(new Date());
		ic.setHora(new Date());
		ic.setDetalles("Se registro actividad de Incendio");
		ic.setEstado(1);
		modelo.insertar(ic);
		return SUCCESS;
	}
	public String cancelarIncidente(){ 
		msg="";
		Incidente x=modelo.buscar(new ObjectId(_id)); 
		idProducto=x.getIdProducto();
		fecha=x.getFecha();
		hora=x.getHora();
		detalles=x.getDetalles();
		estado=x.getEstado();
		return SUCCESS;
	}
	public String cancelarIncidentePost(){ 
		Incidente x=modelo.buscar(new ObjectId(_id)); 
		x.setDetalles(txtDetalles);
		x.setEstado(Incidente.ABORTADO);
		int n=modelo.actualizar(x);
		consultarIncidentes();
		if (n==1) {
			msg="Se ha Cancelado Correctamente el Incidente";
		}else{
			msg="Error al Actualizar el Incidente: "+modelo.getError();
		}
		return SUCCESS;
	}
	
	
	public List<Incidente> getIncidentes() {
		return incidentes;
	}

	public void setIncidentes(List<Incidente> incidentes) {
		this.incidentes = incidentes;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getTxtDetalles() {
		return txtDetalles;
	}

	public void setTxtDetalles(String txtDetalles) {
		this.txtDetalles = txtDetalles;
	}
	
	

}
