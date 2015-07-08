package app;

import java.util.ArrayList;
import java.util.Collection;

import parserXML.Param;
import parserXML.Validar;

public class Aplication {
	private String cmd;
	private String name;
	private ArrayList<Param> parametros ;
	private ArrayList<Object> objetosGraficos = new ArrayList<Object>();
	private Collection<Validar> validaciones;

	public Collection<Validar> getValidaciones() {
		return validaciones;
	}

	public void setValidaciones(Collection<Validar> validaciones) {
		this.validaciones = validaciones;
	}

	public ArrayList<Param> getParametros() {
		return parametros;
	}

	public void setParametros(ArrayList<Param> arrayList) {
		this.parametros = arrayList;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Object> getObjetosGraficos() {
		return objetosGraficos;
	}

	public void setObjetosGraficos(ArrayList<Object> objetosGraficos) {
		this.objetosGraficos = objetosGraficos;
	}
	
	

}