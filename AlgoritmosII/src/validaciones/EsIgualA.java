package validaciones;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import app.Aplication;

public class EsIgualA implements ValidarInterface{

	
	public int validar(Aplication application, String param, String arg) {
		// TODO Auto-generated method stub
		if (arg != null) {
			if (param != null) {
				//busco el elemento a validar
				try {
					Object obj = getElementoXParam(application, param);
					if (obj instanceof JTextField) {
						JTextField text = (JTextField) obj ;
						if (Integer.parseInt(text.getText()) == Integer.parseInt(arg)) {
							return 1;
						};
					} else if (obj instanceof JComboBox) {
						JComboBox combo = (JComboBox) obj ;
						if (Integer.parseInt(combo.getSelectedItem().toString()) == Integer.parseInt(arg)) {
							return 1;
						};
					}
				} catch (NoSuchMethodException | SecurityException
						| IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return 0;
	}
	
	private Object getElementoXParam(Aplication application, String name) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		//deberia buscar el componente que se correponde con el parametro para armar la ejecucion
		for (Object objGrafico : application.getObjetosGraficos()) {
    		if (objGrafico != null) { 
    	        Method lMethod = objGrafico.getClass().getMethod("getName",null);
    	        Object returnValue = lMethod.invoke(objGrafico, lMethod.getParameterTypes());
    	        if (returnValue.toString().equals(name)) { //si es el objeto obtengo el valor
    	        	return objGrafico;
    	        }
    		} 
    	}
		return null;
	}

}