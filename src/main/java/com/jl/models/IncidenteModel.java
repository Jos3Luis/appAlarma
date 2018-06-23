package com.jl.models;

import java.util.List;

import org.bson.types.ObjectId;

import com.jl.dao.DAOFactory;
import com.jl.dao.EntityDAO;
import com.jl.entities.Incidente;

public class IncidenteModel {
	private int Factoria;
	private String error;

	public IncidenteModel() {
		Factoria = DAOFactory.MONGODB;
		error = "";
	}

	public int insertar(Incidente obj) {
		int r = 0;
		try {
			error = "";
			DAOFactory subFabrica = DAOFactory.getSubFabrica(Factoria);
			EntityDAO<Incidente> dao = subFabrica.getIncidente();
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
			EntityDAO<Incidente> dao = subFabrica.getIncidente();
			r = dao.eliminar(id);
		} catch (Exception e) {
			error = e.getMessage();
		}
		return r;
	}

	public Incidente buscar(ObjectId id) {
		Incidente x = null;
		try {
			error = "";
			DAOFactory subFabrica = DAOFactory.getSubFabrica(Factoria);
			EntityDAO<Incidente> dao = subFabrica.getIncidente();
			x = dao.buscar(id);
		} catch (Exception e) {
			error = e.getMessage();
		}
		return x;
	}

	public List<Incidente> listar() {
		List<Incidente> L = null;
		try {
			error = "";
			DAOFactory subFabrica = DAOFactory.getSubFabrica(Factoria);
			EntityDAO<Incidente> dao = subFabrica.getIncidente();
			L = dao.listar();
		} catch (Exception e) {
			error = e.getMessage();
		}

		return L;
	}

	public int actualizar(Incidente x) {
		int r = 0;
		try {
			error = "";
			DAOFactory subFabrica = DAOFactory.getSubFabrica(Factoria);
			EntityDAO<Incidente> dao = subFabrica.getIncidente();
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
