package edu.itesm.mx.aop.mvc;


import java.io.IOException;

import com.fourspaces.couchdb.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.itesm.mx.aop.mvc.JsonFromUrl;

@Controller
public class ProyectoController {
	
	@RequestMapping(value="/", method= RequestMethod.GET) 
	public String abrirProyecto() throws IOException, Exception{	
		Session s = new Session("localhost", 5984);
		String dbname = "earthquakes";
		s.deleteDatabase(dbname);
		s.createDatabase(dbname);
		Database db = s.getDatabase(dbname);
		Document doc = new Document();
		String UrlExterna = "http://www.corsproxy.com/earthquake.usgs.gov/earthquakes/feed/geojson/2.5/day";
		String PruebaString = JsonFromUrl.readJsonFromUrl(UrlExterna);
		Object obj = PruebaString;
		doc.put("temblores", obj);
		db.saveDocument(doc, "7a88dd85d6318226761985d863001035");
		return "proyecto";
	}

	@RequestMapping(value="/jsonpage", method= RequestMethod.GET)
	@ResponseBody
	public String jsonpage(){
		Session s = new Session("localhost", 5984);
		String dbname = "earthquakes";
		Database db = s.getDatabase(dbname);
		Document doc1 = new Document();
		doc1 = db.getDocument("7a88dd85d6318226761985d863001035");
		return doc1.toString();
	}
	
}
