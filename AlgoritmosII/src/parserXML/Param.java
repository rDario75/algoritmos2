package parserXML;

//aca almaceno cada opcion del comando
public class Param {
	
	private String name;
	private String op;
	private String req;
	private String value;
	private String setControl;
	private String label;
	
	

	public Param(){
		name = "";
		op   = "";
		req = "";
		value   = "";
		setControl = "";
		label = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public String getReq() {
		return req;
	}

	public void setReq(String req) {
		this.req = req;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String v) {
		this.value = v;
	}
	
	public String getSetControl() {
		return setControl;
	}

	public void setSetControl(String setControl) {
		this.setControl = setControl;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	public String toString(){
			
			String str;
			
			str = name +" "+ op + " " + req + " " + value + " " + setControl+ " "+ label + "\n";
			
			return str;
	}
	

}
