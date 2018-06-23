package com.jl.dao;
 
import com.jl.dao.mongo.MongoDBClienteDAO;
import com.jl.dao.mongo.MongoDBIncidenteDAO;
import com.jl.dao.mongo.MongoDBProductoDAO;
import com.jl.entities.Cliente; 
import com.jl.entities.Incidente;
import com.jl.entities.Producto;

//Esta es un fabrica de objeto daos
//El dao alumno , el dao curso, etc
public class SubFabricaMongoDB extends DAOFactory{

	@Override
	public EntityDAO<Cliente> getCliente() { 
		return new MongoDBClienteDAO();
	}

	@Override
	public EntityDAO<Incidente> getIncidente() { 
		return new MongoDBIncidenteDAO();
	}

	@Override
	public EntityDAO<Producto> getProducto() { 
		return new MongoDBProductoDAO();
	}

 

}
