package parserXML;

import java.util.ArrayList;

public class APP {

	private String name;
	private String cmd;
	private ArrayList<Param> param;
	private ArrayList<Validar> valid;
	
	public APP(){
		
		name = "";
		cmd = "";
		param = new ArrayList<Param>();
		valid = new ArrayList<Validar>();
	}
	
	

	
	public ArrayList<Validar> getValid() {
		return valid;
	}




	public void setValid(ArrayList<Validar> valid) {
		this.valid = valid;
	}




	public String getCmd() {
		return cmd;
	}


	public void setCmd(String c) {
		this.cmd = c;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Param getParams(int i) {
		return param.get(i) ;
	}

	public void setParams(Param p) {
		this.param.add(p);
	}
	
	public ArrayList<Param> getParametros(){
		
		return param;
	}
	 //imprimo contenido de array de params
	public String toString(){
		
		String x ="";
		
		for(int i=0; i < param.size() ; i++  ){
			
			x += param.get(i) + "\n" ; 
			
		}
		
		return x;
	}
	public Validar getVals(int i) {
		return valid.get(i) ;
	}

	public void setVals(Validar p) {
		this.valid.add(p);
	}
	
}