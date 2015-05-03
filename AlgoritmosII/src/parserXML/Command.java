package parserXML;

import java.util.ArrayList;

public class Command {

	private String name;
	private ArrayList<Option> ops;
	
	public Command(){
		
		name = "";
		ops = new ArrayList<Option>();
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Option getOps(int i) {
		return ops.get(i) ;
	}

	public void setOps(Option op) {
		this.ops.add(op);
	}
	 //imprimo contenido de array de opciones
	public String toString(){
		
		String x ="";
		
		for(int i=0; i < ops.size() ; i++  ){
			
			x = x + ops.get(i); 
			
		}
		
		return x;
	}
	
}
