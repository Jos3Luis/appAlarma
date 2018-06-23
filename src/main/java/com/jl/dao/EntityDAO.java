package com.jl.dao;

 
import java.util.List;

import org.bson.types.ObjectId;

public interface EntityDAO<T> {
	public int insertar(T obj) throws Exception;
	public int actualizar(T obj) throws Exception;
	public int eliminar(ObjectId id) throws Exception;
	public T buscar(ObjectId id) throws Exception;
	public List<T> listar() throws Exception;

}
