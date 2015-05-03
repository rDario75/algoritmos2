package parserXML;


import java.util.Enumeration;
import java.util.Hashtable;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler; 


public class XMLHandler extends DefaultHandler{
	
		private String valor;
		private Option o;
		private Command cmd;
		private Hashtable<String,Command> comandos;
		private static XMLHandler instancia = null;
		
	  public XMLHandler(){
		  
		  comandos = new Hashtable<String,Command>();
		  
	  }
	
	 //proceso etiqueta inicial < >
	  public void startElement(String uri, String localName, String qName, Attributes attr){
		
		   if(qName.equals("Commands")){

		    	instancia = new XMLHandler();
		    }
		
			if( qName.equals("command")){
				
				cmd = new Command();
				
			}

			if (qName.equals("option")){
				
				o = new Option();
			   
			}	
			
		  
	}
	  //proceso el contenido entre etiquetas
	  public void characters(char buf[], int offset, int len){
	      valor = new String(buf, offset, len);
	      valor = valor.trim();
	   
	      
	  }
	  
	  //proceso etiquetas final </ >
	  public void endElement(String uri, String localName, String qName) {
		  
		  if(qName.equals("name")){
			  cmd.setName(valor);
			  
		  }
		  if(qName.equals("option")){
			  
			  o.setStr(valor);
			  cmd.setOps(o);
		  }
		  if(qName.equals("command")){
			  
			  instancia.addOption(cmd);
		  
		  }
	  }
	  
	  public Command getOption(int i){
			
			return comandos.get(i);
	  }
			
	  public void addOption(Command c){
				
			comandos.put(c.getName(), c);
			
	  }
	  
	  public String toString(){
		  
		  String x = "";
		  Enumeration<Command> enumeration = comandos.elements();
		    while (enumeration.hasMoreElements()) {
		    	x = x +""+"hashtable valores: " + enumeration.toString();
		    }
		    
		    return x;
	  }
	  public Hashtable<String,Command> getComandos(){
		  
		  return comandos;
		  
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
