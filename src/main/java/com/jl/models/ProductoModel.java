package com.jl.models;

import java.util.List;

import org.bson.types.ObjectId;

import com.jl.dao.DAOFactory;
import com.jl.dao.EntityDAO;
import com.jl.entities.Producto;

public class ProductoModel {
	private int Factoria;
	private String error;

	public ProductoModel() {
		Factoria = DAOFactory.MONGODB;
		error = "";
	}

	public int insertar(Producto obj) {
		int r = 0;
		try {
			error = "";
			DAOFactory subFabrica = DAOFactory.getSubFabrica(Factoria);
			EntityDAO<Producto> dao = subFabrica.getProducto();
			r = dao.insertar(obj);
		} catch (Exception e) {
			error = e.getMessage();
		}

		return r;
	}

	public int eliminar(ObjectId id) {
		int r = 0;
		try {
			error = "";
			DAOFactory subFabrica = DAOFactory.getSubFabrica(Factoria);
			EntityDAO<Producto> dao = subFabrica.getProducto();
			r = dao.eliminar(id);
		} catch (Exception e) {
			error = e.getMessage();
		}
		return r;
	}

	public Producto buscar(ObjectId id) {
		Producto x = null;
		try {
			error = "";
			DAOFactory subFabrica = DAOFactory.getSubFabrica(Factoria);
			EntityDAO<Producto> dao = subFabrica.getProducto();
			x = dao.buscar(id);
		} catch (Exception e) {
			error = e.getMessage();
		}
		return x;
	}

	public List<Producto> listar() {
		List<Producto> L = null;
		try {
			error = "";
			DAOFactory subFabrica = DAOFactory.getSubFabrica(Factoria);
			EntityDAO<Producto> dao = subFabrica.getProducto();
			L = dao.listar();
		} catch (Exception e) {
			error = e.getMessage();
		}

		return L;
	}

	public int actualizar(Producto x) {
		int r = 0;
		try {
			error = "";
			DAOFactory subFabrica = DAOFactory.getSubFabrica(Factoria);
			EntityDAO<Producto> dao = subFabrica.getProducto();
			r = dao.actualizar(x);
		} catch (Exception e) {
			error = e.getMessage();
		}
		return r;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
