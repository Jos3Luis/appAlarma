package com.jl.entities;

import java.util.Date;

import org.bson.types.ObjectId;

public class Incidente {
	private int idincidente;
	private ObjectId _id;
	private String idProducto;
	private Date fecha;
	private Date hora;
	private String detalles;
	private int estado;

	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	} 
	public String getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}
	public int getIdincidente() {
		return idincidente;
	}

	public void setIdincidente(int idincidente) {
		this.idincidente = idincidente;
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
	public static final int REGISTRADO=1;
	public static final int ABORTADO=2;
}
