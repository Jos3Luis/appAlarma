package com.jl.dao.mongo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.jl.connections.MongoDBConnection;
import com.jl.dao.EntityDAO;
import com.jl.entities.Incidente;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.eq;

public class MongoDBIncidenteDAO implements EntityDAO<Incidente> { 
	
	public int insertar(Incidente obj) throws Exception {
		MongoDatabase db = MongoDBConnection.getConexion();
		MongoCollection<Document> tabla = db.getCollection("incidentes"); 
		Document m= new Document(); 
		m.append("idProducto",obj.getIdProducto());
		m.append("fecha",obj.getFecha());
        m.append("hora",obj.getHora());
        m.append("detalles",obj.getDetalles());  
        m.append("estado",1);  
        tabla.insertOne(m); 
		return 1;
	}

	public int actualizar(Incidente obj) throws Exception {
		MongoDatabase db = MongoDBConnection.getConexion();
		MongoCollection<Document> tabla = db.getCollection("incidentes");
		
		Document updateQuery = new Document("_id", obj.get_id());
		tabla.updateOne(updateQuery, new Document("$set", new Document("idProducto", obj.getIdProducto())));
		tabla.updateOne(updateQuery, new Document("$set", new Document("fecha", obj.getFecha())));
		tabla.updateOne(updateQuery, new Document("$set", new Document("hora", obj.getHora())));
		tabla.updateOne(updateQuery, new Document("$set", new Document("detalles", obj.getDetalles())));		
		tabla.updateOne(updateQuery, new Document("$set", new Document("estado", obj.getEstado())));
		
		return 1;
	}

	public int eliminar(ObjectId id) throws Exception {
		MongoDatabase db = MongoDBConnection.getConexion();
		MongoCollection<Document> tabla = db.getCollection("incidentes");
		tabla.findOneAndDelete(eq("_id", id));
		return 1;
	}

	public Incidente buscar(ObjectId id) throws Exception {
		MongoDatabase db = MongoDBConnection.getConexion();
		MongoCollection<Document> tabla = db.getCollection("incidentes");
		
		Incidente obj = null;
		Document document = tabla.find(eq("_id", id)).first();
		if (document!=null) {
			obj = new Incidente();
			obj.set_id(id);
			obj.setIdProducto(document.getString("idProducto"));
			obj.setFecha(document.getDate("fecha"));
			obj.setHora( document.getDate("hora") );
			obj.setDetalles(document.getString("detalles")); 
			obj.setEstado(document.getInteger("estado"));
		}
		return obj;
	}

	public List<Incidente> listar() throws Exception {
		List<Incidente> data = new ArrayList<Incidente>();

		MongoDatabase db = MongoDBConnection.getConexion();
		MongoCollection<Document> tabla = db.getCollection("incidentes");

		Incidente obj = null;
		List<Document> documents = (List<Document>) tabla.find().into(new ArrayList<Document>());
		for (Document document : documents) {
			obj = new Incidente();
			obj.set_id( document.getObjectId("_id"));
			obj.setIdProducto(document.getString("idProducto"));
			obj.setFecha(document.getDate("fecha"));
			obj.setHora(document.getDate("hora"));
			obj.setDetalles(document.getString("detalles")); 
			obj.setEstado(document.getInteger("estado"));
			data.add(obj);
		} 
		return data;
	}
 

}
