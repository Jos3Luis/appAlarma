package com.jl.models;

import java.util.List;

import org.bson.types.ObjectId;

import com.jl.dao.DAOFactory;
import com.jl.dao.EntityDAO;
import com.jl.entities.Cliente;

public class ClienteModel {
	private int Factoria;
	private String error;

	public ClienteModel() {
		Factoria = DAOFactory.MONGODB;
		error = "";
	}

	public int insertar(Cliente obj) {
		int r = 0;
		try {
			error = "";
			DAOFactory subFabrica = DAOFactory.getSubFabrica(Factoria);
			EntityDAO<Cliente> dao = subFabrica.getCliente();
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
			EntityDAO<Cliente> dao = subFabrica.getCliente();
			r = dao.eliminar(id);
		} catch (Exception e) {
			error = e.getMessage();
		}
		return r;
	}

	public Cliente buscar(ObjectId id) {
		Cliente x = null;
		try {
			error = "";
			DAOFactory subFabrica = DAOFactory.getSubFabrica(Factoria);
			EntityDAO<Cliente> dao = subFabrica.getCliente();
			x = dao.buscar(id);
		} catch (Exception e) {
			error = e.getMessage();
		}
		return x;
	}

	public List<Cliente> listar() {
		List<Cliente> L = null;
		try {
			error = "";
			DAOFactory subFabrica = DAOFactory.getSubFabrica(Factoria);
			EntityDAO<Cliente> dao = subFabrica.getCliente();
			L = dao.listar();
		} catch (Exception e) {
			error = e.getMessage();
		}

		return L;
	}

	public int actualizar(Cliente x) {
		int r = 0;
		try {
			error = "";
			DAOFactory subFabrica = DAOFactory.getSubFabrica(Factoria);
			EntityDAO<Cliente> dao = subFabrica.getCliente();
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
