package edu.itesm.mx.aop.mvc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;

import com.fourspaces.couchdb.*;

import org.json.simple.JSONValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProyectoController {
	
	// se llamar‡ a proyecto.jsp al correr la aplicaci—n, el cual carga app.js y style.css
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/", method= RequestMethod.GET) 
	public String abrirProyecto() throws IOException	{
		//crea una sesi—n couchdb
		Session dbSession = new Session("localhost", 5984);
		String dbname = "earthquakes";
		dbSession.createDatabase(dbname);
		Database db = dbSession.getDatabase(dbname);
		Document doc0 = new Document();
		doc0 = db.getDocument("7a88dd85d6318226761985d863001035");
		db.deleteDocument(doc0);
		
		//importando informaci—n actualizada de temblores de hoy, y creando map
		String jsonString = "";
		jsonString = readJsonFromUrl("http://www.corsproxy.com/earthquake.usgs.gov/earthquakes/feed/geojson/2.5/day");
		Map<String, Object> jsonMap;
		jsonMap = (Map<String, Object>) JSONValue.parse(jsonString);	

		//creando documento y entregando map
		System.out.println(jsonMap.toString());
		Document doc1 = new Document();
		doc1.putAll(jsonMap);
		
		//salvando doc en la base de datos de couchdb
		db.saveDocument(doc1, "7a88dd85d6318226761985d863001035");
		return "index";
	}
	
	private String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }

	//leyendo contenido de la URL
	public String readJsonFromUrl(String url) throws IOException {
	    InputStream is = new URL(url).openStream();
	    try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      String jsonText = readAll(rd);
	      return jsonText;
	    } finally {
	      is.close();
	    }
	}

	// jsonpage se llamar‡ desde el javascript app.js
	@RequestMapping(value="/jsonpage", method= RequestMethod.GET)
	@ResponseBody
	public String jsonpage(){
		//crea una sesi—n couchdb
		Session dbSession = new Session("localhost", 5984);
		//obtiene el documento con id indicado de la base de datos indicada
		String dbname = "earthquakes";
		Database db = dbSession.getDatabase(dbname);
		Document doc = db.getDocument("7a88dd85d6318226761985d863001035");
		String json = doc.toString();
		return json;
	}
}
