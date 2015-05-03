package parserXML;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;


public class testParser {

	private static Hashtable<String,Command> comandos;
	
	public static void main(String[] args) {
		
				
		XMLHandler xh = XMLHandler.getInstancia();
		comandos = xh.getComandos();
		
		Set<String> set = comandos.keySet();
		String str;
	    Iterator<String> itr = set.iterator();
	    while (itr.hasNext()) {
	      str = itr.next();
	      System.out.println(str + ": " + comandos.get(str));
	    }
		
	}
		   
}
