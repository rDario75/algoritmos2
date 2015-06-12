package parserXML;

import java.util.Enumeration;
import java.util.Hashtable;

public class APPs{
	
	private Hashtable<String, APP> com;
	
	public APPs(){
		
		com = new Hashtable<String, APP>();
	}
	
	public String toString(){
		
		String x="";
		APP aux;
		for(Enumeration<String> e=com.keys(); e.hasMoreElements(); )
		{
			aux = com.get(e.nextElement());
			x+= aux.getCmd() +"\n";
		}
		return x;
	}      

	public Hashtable<String, APP> getCom() {
		return com;
	}

	public void setCom(Hashtable<String, APP> com) {
		this.com = com;
	}
	
	public APP getCommand(APP c){
		
		return com.get(c);
		}
		
	public void addCommand(APP c){
			
		com.put(c.getName() , c);
		
		}
	
}
