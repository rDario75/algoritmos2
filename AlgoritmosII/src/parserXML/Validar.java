package parserXML;

public class Validar {
	
	private String name;
	private String clase;
	private String error;
	private String param;
	private String arg;
	
	public Validar(){
		
		name  = "";
		clase = "";
		error = "";
		param = "";
		arg	  = "";
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	
	
	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String toString(){
		
		String str;
		
		str = name +" "+ clase + " " + error+"\n"; 
		
		return str;
	}

	public String getArg() {
		return arg;
	}

	public void setArg(String arg) {
		this.arg = arg;
	}
	
	
}