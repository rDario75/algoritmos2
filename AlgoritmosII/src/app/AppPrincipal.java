package app;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import parserXML.APP;
import parserXML.XMLHandler;

public class AppPrincipal {
	private Collection<Aplication> aplicaciones = new ArrayList();
	private static Hashtable<String,APP> comandos;

	public Collection<Aplication> getAplicaciones() {
		return aplicaciones;
	}

	public void setAplicaciones(Collection<Aplication> aplicaciones) {
		this.aplicaciones = aplicaciones;
	}
	
	public static void main(String[] args) {
		
		//creo instancia del handler		
		XMLHandler xh = XMLHandler.getInstancia();
		comandos = xh.getComandos();
		
		Set<String> set = comandos.keySet();
		String str;
	    Iterator<String> itr = set.iterator();
	    Collection<Aplication> appAux = new ArrayList();
	    while (itr.hasNext()) {
	      str = itr.next();
	      //Creamos las aplicaciones
	      Aplication app = new Aplication();
	      app.setCmd(comandos.get(str).getCmd());
	      app.setName(comandos.get(str).getName());
	      app.setParametros(comandos.get(str).getParametros());
	      appAux.add(app);
	      //getAplicaciones().add(app); 

	    }
	    
	}
	
	public AppPrincipal() {
		//creo instancia del handler		
		XMLHandler xh = XMLHandler.getInstancia();
		comandos = xh.getComandos();
		
		Set<String> set = comandos.keySet();
		String str;
	    Iterator<String> itr = set.iterator();
	    Collection<Aplication> appAux = new ArrayList();
	    while (itr.hasNext()) {
	      str = itr.next();
	      //Creamos las aplicaciones
	      Aplication app = new Aplication();
	      app.setCmd(comandos.get(str).getCmd());
	      app.setName(comandos.get(str).getName());
	      app.setParametros(comandos.get(str).getParametros());
	      app.setValidaciones(comandos.get(str).getValid());
	      appAux.add(app);
	     	
	    }
	    setAplicaciones(appAux);
	} 
	
}