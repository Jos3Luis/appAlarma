package com.jl.dao.mongo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.jl.connections.MongoDBConnection;
import com.jl.dao.EntityDAO;
import com.jl.entities.Cliente; 
import com.mongodb.DBCursor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.eq;

public class MongoDBClienteDAO implements EntityDAO<Cliente> {

	public int insertar(Cliente obj) throws Exception {
		MongoDatabase db = MongoDBConnection.getConexion();
		MongoCollection<Document> cliente = db.getCollection("clientes"); 
		Document m= new Document();
		m.append("nombres",obj.getNombres());
        m.append("paterno",obj.getPaterno());
        m.append("materno",obj.getMaterno());
        m.append("dni",obj.getDni());
        m.append("correo",obj.getCorreo());
        m.append("celular",obj.getCelular());
        m.append("telefono",obj.getTelefono());
        m.append("clave",obj.getClave());
        m.append("fecha_creacion",new Date()); 
        m.append("estado",1);  
        cliente.insertOne(m); 
		return 1;
	}

	public int actualizar(Cliente obj) throws Exception {
		MongoDatabase db = MongoDBConnection.getConexion();
		MongoCollection<Document> tabla = db.getCollection("clientes");
		
		Document updateQuery = new Document("_id", obj.get_id());
		tabla.updateOne(updateQuery, new Document("$set", new Document("dni", obj.getDni())));
		tabla.updateOne(updateQuery, new Document("$set", new Document("clave", obj.getClave())));
		tabla.updateOne(updateQuery, new Document("$set", new Document("fecha_creacion", obj.getFecha_creacion())));
		tabla.updateOne(updateQuery, new Document("$set", new Document("nombres", obj.getNombres())));
		tabla.updateOne(updateQuery, new Document("$set", new Document("paterno", obj.getPaterno())));
		tabla.updateOne(updateQuery, new Document("$set", new Document("materno", obj.getMaterno())));
		tabla.updateOne(updateQuery, new Document("$set", new Document("celular", obj.getCelular())));
		tabla.updateOne(updateQuery, new Document("$set", new Document("telefono", obj.getTelefono())));
		tabla.updateOne(updateQuery, new Document("$set", new Document("estado", obj.getEstado())));
		
		return 1;
	}

	public int eliminar(ObjectId id) throws Exception {
		MongoDatabase db = MongoDBConnection.getConexion();
		MongoCollection<Document> clientes = db.getCollection("clientes");
		clientes.findOneAndDelete(eq("_id", id));
		return 1;
	}

	public Cliente buscar(ObjectId id) throws Exception {
		MongoDatabase db = MongoDBConnection.getConexion();
		MongoCollection<Document> clientes = db.getCollection("clientes");
		
		Cliente obj = null;
		Document document = clientes.find(eq("_id", id)).first();
		if (document!=null) {
			obj = new Cliente();
			//obj.set_id(document.getString("_id"));
			obj.setNombres(document.getString("nombres"));
			obj.setPaterno(document.getString("paterno"));
			obj.setMaterno(document.getString("materno")) ;
			obj.setDni(document.getString("dni"));
			obj.setCorreo(document.getString("correo"));
			obj.setCelular(document.getString("celular"));
			obj.setTelefono(document.getString("telefono")); 
			obj.setClave(document.getString("clave"));
			obj.setFecha_creacion(document.getDate("fecha_creacion")); 
		}
		return obj;
	}

	public List<Cliente> listar() throws Exception { 
		List<Cliente> data = new ArrayList<Cliente>();

		MongoDatabase db = MongoDBConnection.getConexion();
		MongoCollection<Document> tabla = db.getCollection("clientes"); 
		Cliente obj = null; 
		List<Document> documents = (List<Document>) tabla.find().into(new ArrayList<Document>());		 
		for (Document document : documents) { 
			obj = new Cliente();  
			ObjectId _id=(ObjectId)document.getObjectId("_id");
			obj.set_id(_id); 
			obj.setNombres(document.getString("nombres"));
			obj.setPaterno(document.getString("paterno")); 
			obj.setMaterno(document.getString("materno")) ; 
			obj.setDni(document.getString("dni")); 
			obj.setCorreo(document.getString("correo")); 
			obj.setCelular(document.getString("celular")); 
			obj.setTelefono(document.getString("telefono")); 
			obj.setClave(document.getString("clave")); 
			obj.setFecha_creacion(document.getDate("fecha_creacion"));
			data.add(obj);
			 
		} 
		return data;
	}
 

}
