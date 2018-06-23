package com.jl.controllers;
 
import java.util.ArrayList;
import java.util.List;











import org.bson.types.ObjectId;
 


import com.jl.entities.Producto;
import com.jl.models.ProductoModel;
import com.opensymphony.xwork2.ActionSupport;

public class ProductoController extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private String _id;
	private String mac;
	private String latitud;
	private String longitud;
	private String activarCorreo;
	private String activarSirena;
	private String duracion;
	private String idCliente; 
	private int estado;
	
	private List<Producto> productos;
	
	private ProductoModel modelo;
	private String msg;
	
	public ProductoController() {
		modelo= new ProductoModel();
		msg="";
	}

	public String listarProductos(){ 
		productos=modelo.listar();
		List<Producto> L= new ArrayList<Producto>();
		for (Producto x: productos) {			
			if (x.getIdCliente().toString().equals(new ObjectId(idCliente).toString())) {
				L.add(x);
			}
		}
		productos=L;
		return SUCCESS;
	}
	
	public String desactivarProducto(){
		Producto x=modelo.buscar(new ObjectId(_id));
		x.setEstado(Producto.DESACTIVADO);
		int n=modelo.actualizar(x);
		listarProductos();
		if (n==1) {
			msg="Se ha Desactivado exitosamente el Producto";
		}else {
			msg="Error al desactivar el Producto: "+modelo.getError();
		}
		return SUCCESS;
	}
	
	public String grabarProducto(){
		Producto p= new Producto();
		p.setMac(mac);
		p.setLatitud(latitud);
		p.setLongitud(longitud);
		p.setActivarCorreo(Boolean.parseBoolean(activarCorreo));
		p.setActivarSirena(Boolean.parseBoolean(activarSirena));
		p.setDuracion(Integer.parseInt(duracion));
		p.setIdCliente(new ObjectId(idCliente));
		p.setEstado(Producto.ACTIVADO);
		int n=modelo.insertar(p);
		listarProductos();
		if (n==1) {
			msg="Se ha grabado exitosamente el Producto";
		}else {
			msg="Error al grabar el Producto: "+modelo.getError();
		}
		return SUCCESS;
	}
	public String actualizarProducto(){
		Producto p= modelo.buscar(new ObjectId(_id));
		mac=p.getMac();
		latitud=p.getLatitud();
		longitud=p.getLongitud();
		activarCorreo=p.isActivarCorreo()+"";
		activarSirena=p.isActivarSirena()+"";
		duracion=p.getDuracion()+"";
		idCliente=p.getIdCliente()+""; 
		estado=p.getEstado();
		int n=modelo.insertar(p);
		listarProductos();
		if (n==1) {
			msg="Se ha actualizado exitosamente el Producto";
		}else {
			msg="Error al actualizar el Producto: "+modelo.getError();
		}
		return SUCCESS;
	}
	public String actualizarProductoPost(){
		Producto p= new Producto();
		p.set_id(new ObjectId(_id));
		p.setMac(mac);
		p.setLatitud(latitud);
		p.setLongitud(longitud);
		p.setActivarCorreo(Boolean.parseBoolean(activarCorreo));
		p.setActivarSirena(Boolean.parseBoolean(activarSirena));
		p.setDuracion(Integer.parseInt(duracion));
		p.setIdCliente(new ObjectId(idCliente));
		p.setEstado(Producto.ACTIVADO);
		int n=modelo.actualizar(p);
		listarProductos();
		if (n==1) {
			msg="Se ha actualizado exitosamente el Producto";
		}else {
			msg="Error al actualizar el Producto: "+modelo.getError();
		}
		return SUCCESS;
	}
	
	public String eliminarProducto(){ 
		int n=modelo.eliminar(new ObjectId(_id));
		listarProductos();
		if (n==1) {
			msg="Se ha eliminado con exito";
		}else {
			msg="Error al eliminar: "+modelo.getError();
		}
		return SUCCESS;
	}
	 
	 
	
	 
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
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

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
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

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getActivarCorreo() {
		return activarCorreo;
	}

	public void setActivarCorreo(String activarCorreo) {
		this.activarCorreo = activarCorreo;
	}

	public String getActivarSirena() {
		return activarSirena;
	}

	public void setActivarSirena(String activarSirena) {
		this.activarSirena = activarSirena;
	}

	 
 

}
