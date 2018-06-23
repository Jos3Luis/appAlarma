package com.jl.entities;

import org.bson.types.ObjectId;

public class Producto {
	private int idProducto;
	private ObjectId _id;
	private String mac;
	private String latitud;
	private String longitud;
	private boolean activarCorreo;
	private boolean activarSirena;
	private int duracion;
	private ObjectId idCliente;
	private int radioCliente;
	private int radioAdmin;
	private int estado;
	
	
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	} 
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public boolean isActivarCorreo() {
		return activarCorreo;
	}
	public void setActivarCorreo(boolean activarCorreo) {
		this.activarCorreo = activarCorreo;
	}
	public boolean isActivarSirena() {
		return activarSirena;
	}
	public void setActivarSirena(boolean activarSirena) {
		this.activarSirena = activarSirena;
	}
	public ObjectId getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(ObjectId idCliente) {
		this.idCliente = idCliente;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	public int getRadioCliente() {
		return radioCliente;
	}
	public void setRadioCliente(int radioCliente) {
		this.radioCliente = radioCliente;
	}
	public int getRadioAdmin() {
		return radioAdmin;
	}
	public void setRadioAdmin(int radioAdmin) {
		this.radioAdmin = radioAdmin;
	}

	public static final int ACTIVADO=1;
	public static final int DESACTIVADO=2;
	

}
