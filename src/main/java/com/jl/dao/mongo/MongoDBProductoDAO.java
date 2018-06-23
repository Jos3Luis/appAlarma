package com.jl.dao.mongo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.jl.connections.MongoDBConnection;
import com.jl.dao.EntityDAO;
import com.jl.entities.Producto; 
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.eq;

public class MongoDBProductoDAO implements EntityDAO<Producto> {

	public int insertar(Producto obj) throws Exception {
		MongoDatabase db = MongoDBConnection.getConexion();
		MongoCollection<Document> tabla = db.getCollection("productos"); 
		Document m= new Document(); 
		m.append("mac",obj.getMac());
        m.append("latitud",obj.getLatitud());
        m.append("longitud",obj.getLongitud());
        m.append("activarCorreo",obj.isActivarCorreo());
        m.append("activarSirena",obj.isActivarSirena());
        m.append("duracion", obj.getDuracion());
        m.append("idCliente",obj.getIdCliente());
        m.append("estado",1);  
        tabla.insertOne(m); 
		return 1;
	}

	public int actualizar(Producto obj) throws Exception {
		MongoDatabase db = MongoDBConnection.getConexion();
		MongoCollection<Document> tabla = db.getCollection("productos"); 
		Document updateQuery = new Document("_id", obj.get_id());
		tabla.updateOne(updateQuery, new Document("$set", new Document("mac", obj.getMac())));
		tabla.updateOne(updateQuery, new Document("$set", new Document("latitud", obj.getLatitud())));
		tabla.updateOne(updateQuery, new Document("$set", new Document("longitud", obj.getLongitud())));
		tabla.updateOne(updateQuery, new Document("$set", new Document("activarCorreo", obj.isActivarCorreo())));
		tabla.updateOne(updateQuery, new Document("$set", new Document("activarSirena", obj.isActivarSirena())));
		tabla.updateOne(updateQuery, new Document("$set", new Document("duracion", obj.getDuracion())));
		tabla.updateOne(updateQuery, new Document("$set", new Document("idCliente", obj.getIdCliente())));
		tabla.updateOne(updateQuery, new Document("$set", new Document("estado", obj.getEstado())));
		
		return 1;
	}

	public int eliminar(ObjectId id) throws Exception {
		MongoDatabase db = MongoDBConnection.getConexion();
		MongoCollection<Document> tabla = db.getCollection("productos");
		tabla.findOneAndDelete(eq("_id", id));
		return 1;
	}

	public Producto buscar(ObjectId id) throws Exception {
		MongoDatabase db = MongoDBConnection.getConexion();
		MongoCollection<Document> tabla = db.getCollection("productos");
		
		Producto obj = null;
		Document document = tabla.find(eq("_id", id)).first();
		if (document!=null) {
			obj = new Producto();
			obj.set_id(document.getObjectId("_id"));
			obj.setMac(document.getString("mac"));
			obj.setLatitud(document.getString("latitud"));
			obj.setLongitud(document.getString("longitud"));
			obj.setActivarCorreo(document.getBoolean("activarCorreo"));
			obj.setActivarSirena(document.getBoolean("activarSirena"));
			obj.setDuracion(document.getInteger("duracion"));
			obj.setIdCliente(document.getObjectId("idCliente"));
			obj.setEstado(document.getInteger("estado"));
		}
		return obj;
	}

	public List<Producto> listar() throws Exception {
		List<Producto> data = new ArrayList<Producto>();

		MongoDatabase db = MongoDBConnection.getConexion();
		MongoCollection<Document> tabla = db.getCollection("productos");

		Producto obj = null;
		List<Document> documents = (List<Document>) tabla.find().into(new ArrayList<Document>());
		for (Document document : documents) {
			obj = new Producto();
			obj.set_id(document.getObjectId("_id"));
			obj.setMac(document.getString("mac"));
			obj.setLatitud(document.getString("latitud"));
			obj.setLongitud(document.getString("longitud"));
			obj.setActivarCorreo(document.getBoolean("activarCorreo"));
			obj.setActivarSirena(document.getBoolean("activarSirena"));
			obj.setDuracion(document.getInteger("duracion"));
			obj.setIdCliente(document.getObjectId("idCliente"));
			obj.setEstado(document.getInteger("estado"));
			data.add(obj);
		} 
		return data;
	}
 

}
