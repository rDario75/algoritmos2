package parserXML;


import java.util.Enumeration;
import java.util.Hashtable;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler; 


public class XMLHandler extends DefaultHandler{
	
		private String valor;
		private Param p;
		private APP app;
		private Validar val;
		private Hashtable<String,APP> apps;
		private static XMLHandler instancia = null;
		
	  public XMLHandler(){
		  
		  apps = new Hashtable<String,APP>();
		  
	  }
	
	 //proceso etiqueta inicial < >
	  public void startElement(String uri, String localName, String qName, Attributes attr){
		  
		  String name;
		  
		   if(qName.equals("Aplications")){

		    	instancia = new XMLHandler();
		    }
		
			if( qName.equals("Aplication")){
				
				String cmd;
				
				cmd = attr.getValue("cmd");
				name = attr.getValue("name"); 
				app = new APP();
				app.setCmd(cmd);
				app.setName(name);
				
			}

			if (qName.equals("param")){
				
				String pa;
				String req;
				String sc;
				String label;
				String val;
				name = attr.getValue("name");
				pa = attr.getValue("operacion");
				req = attr.getValue("requiereArg");
				sc = attr.getValue("setControl");
				label = attr.getValue("label");
				val = attr.getValue("value");
				p = new Param();
				p.setName(name);
				p.setOp(pa);
				p.setReq(req);
				p.setSetControl(sc);
				p.setLabel(label);
				p.setValue(val);
				
				app.setParams(p);
			   
			}
			
		//	if(qName.equals("validations")){
				
		//		val = new Validar();
		//	}
			
			if(qName.equals("validation")){
				val = new Validar();
				String clase;
				String error;
				String param;
				String arg;
				name = attr.getValue("name");
				clase = attr.getValue("class");
				error = attr.getValue("onError");
				param = attr.getValue("param");
				arg = attr.getValue("arg");
				val.setClase(clase);
				val.setError(error);
				val.setName(name);
				val.setParam(param);
				val.setArg(arg);
				app.getValid().add(val);
				
			}
			if(qName.equals("Aplication")){
				
				instancia.addOption(app);
				
			}
			
		  
	}
	  //proceso el contenido entre etiquetas
	  public void characters(char buf[], int offset, int len){
	      valor = new String(buf, offset, len);
	      valor = valor.trim();
	   
	      
	  }
	  
	  //proceso etiquetas final </ >
	  public void endElement(String uri, String localName, String qName) {
		  
		 
	  }
	  
	  public APP getOption(int i){
			
			return apps.get(i);
	  }
			
	  public void addOption(APP c){
				
			apps.put(c.getName() , c);
			
	  }
	  
	  public String toString(){
		  
		  String x = "";
		  Enumeration<APP> enumeration = apps.elements();
		    while (enumeration.hasMoreElements()) {
		    	x = x +""+"hashtable valores: " + enumeration.toString();
		    }
		    
		    return x;
	  }
	  public Hashtable<String,APP> getComandos(){
		  
		  return apps;
		  
	  }
	  
	  public static XMLHandler getInstancia(){
		  
		  try
			{
			  if (instancia == null){
					
					SAXParserFactory spf = SAXParserFactory.newInstance();
					SAXParser sp = spf.newSAXParser();
					sp.parse("Algoritmo2.xml", new XMLHandler());
			}
		  		return instancia;
					
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				throw new RuntimeException();
			}
	  }
	  
}