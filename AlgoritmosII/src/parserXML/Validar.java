package parserXML;

public class Validar {
	
	private String name;
	private String clase;
	private String error;
	
	public Validar(){
		
		name  = "";
		clase = "";
		error = "";
		
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
	
	public String toString(){
		
		String str;
		
		str = name +" "+ clase + " " + error+"\n"; 
		
		return str;
	}

}
