package parserXML;

import java.util.Enumeration;
import java.util.Hashtable;

public class Commands{
	
	private Hashtable<String, Command> com;
	
	public Commands(){
		
		com = new Hashtable<String, Command>();
	}
	
	public String toString(){
		
		String x="";
		Command aux;
		for(Enumeration<String> e=com.keys(); e.hasMoreElements(); )
		{
			aux = com.get(e.nextElement());
			x+=aux.getName() +"\n";
		}
		return x;
	}      
	
	
	public void endElement(String uri, String localName, String qName)
	{
	}

	public Hashtable<String, Command> getCom() {
		return com;
	}

	public void setCom(Hashtable<String, Command> com) {
		this.com = com;
	}
	
	public Command getCommand(Command c){
		
		return com.get(c);
		}
		
	public void addCommand(Command c){
			
		com.put(c.getName() , c);
		
		}
	
}
