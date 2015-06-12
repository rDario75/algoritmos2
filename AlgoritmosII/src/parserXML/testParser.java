package parserXML;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;


public class testParser {

	private static Hashtable<String,APP> comandos;
	//private static ArrayList<Param> params;
	
	public static void main(String[] args) {
		
		//creo instancia del handler		
		XMLHandler xh = XMLHandler.getInstancia();
		comandos = xh.getComandos();
		
		Set<String> set = comandos.keySet();
		String str;
	    Iterator<String> itr = set.iterator();
	    while (itr.hasNext()) {
	      str = itr.next();
	      System.out.println(str + ": \n" + comandos.get(str).toString() + " " + "\n");
	      
	      //x="";
	      //x = comandos.get(str).toString();
	      
	      //System.out.println(x);
	    }
		
	}
		   
}
