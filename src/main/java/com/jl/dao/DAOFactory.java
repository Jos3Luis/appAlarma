package com.jl.dao;
 
import com.jl.entities.Cliente; 
import com.jl.entities.Incidente;
import com.jl.entities.Producto;

public  abstract class DAOFactory {

	public static final int MYSQL = 1;
	public static final int SQL_SERVER = 2;
	public static final int MONGODB = 3;
	
	//Registran los daos
	public abstract EntityDAO<Cliente> getCliente();
	public abstract EntityDAO<Incidente> getIncidente();
	public abstract EntityDAO<Producto> getProducto();
		
	public static  DAOFactory getSubFabrica(int tipo){
			switch (tipo) {
			case MYSQL:
				return null;
			case SQL_SERVER:
				//Se crea la subfabrica cuando se necesite con SqlServer
				return null;
			case MONGODB:
				return new SubFabricaMongoDB();
			}
		return null;
	}
	
}
