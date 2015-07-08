package app;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import parserXML.Param;
import parserXML.Validar;
import validaciones.ValidarInterface;
import app.Aplication;

public class Pantalla extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String SEPARADOR = " ";
	private AppPrincipal appPrincipal = new AppPrincipal();
	private JComboBox comboBox = new JComboBox(); //combo de aplicaciones
	private JPanel panel_1; //panel de parametros
	private Aplication appSelecionada = null;
	private JScrollPane paneScrool = new JScrollPane();
	private JTextPane textAreaResultados;
	protected static final String FIN_LiNEA = "\n";
	public StyledDocument doc;

	
	public JTextPane getTextAreaResultados() {
		return textAreaResultados;
	}

	public void setTextAreaResultados(JTextPane textAreaResultados) {
		this.textAreaResultados = textAreaResultados;
	}

	public JScrollPane getPaneScrool() {
		return paneScrool;
	}

	public void setPaneScrool(JScrollPane paneScrool) {
		this.paneScrool = paneScrool;
	}

	public AppPrincipal getAppPrincipal() {
		return appPrincipal;
	}

	public void setAppPrincipal(AppPrincipal appPrincipal) {
		this.appPrincipal = appPrincipal;
	}
	

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public JPanel getPanel_1() {
		return panel_1;
	}

	public void setPanel_1(JPanel panel_1) {
		this.panel_1 = panel_1;
	}
	
	

	public Aplication getAppSelecionada() {
		return appSelecionada;
	}

	public void setAppSelecionada(Aplication appSelecionada) {
		this.appSelecionada = appSelecionada;
	}

	public Pantalla() {
		 		
		setTitle("Gestor de aplicaciones");
		getContentPane().setLayout(null);
		this.setSize(1080, 500);
		
		JPanel panel = new JPanel();
		//JPanel panelResultados = new JPanel();
		textAreaResultados = new JTextPane();
		JScrollPane scrollPane = new JScrollPane(textAreaResultados);

		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(550, 15, 500, 410);
		textAreaResultados.setBounds(550, 11, 500, 70);
		textAreaResultados.setMargin(new Insets(5, 5, 5, 5));
		textAreaResultados.setEditable(false);
		Font font = new Font("Verdana", Font.BOLD, 10);
		textAreaResultados.setFont(font);
		textAreaResultados.setForeground(Color.WHITE);
		textAreaResultados.setBackground(Color.BLACK);
		
		doc = textAreaResultados.getStyledDocument();
		
		panel.setBorder(new TitledBorder(null, "Aplicaciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 500, 63);
		
		//panelResultados.setBounds(550, 11, 500, 380);
		//panelResultados.setBorder(new TitledBorder(null, "Resultado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		//panelResultados.add(scrollPane);
		
		getContentPane().add(panel);
		getContentPane().add(scrollPane);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		 comboBox.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                selectItem(evt);
	            }
	        });
		
		panel.add(comboBox);
		
		for (Aplication app : this.getAppPrincipal().getAplicaciones()) {
			comboBox.addItem(app.getName());
			//comboBox.setModel(new DefaultComboBoxModel(new String[] {app.getCmd(), app.getName()}));
		}
		
		comboBox.setEditable(true);
		
		JLabel lblSeleccione = new JLabel("Seleccione App");
		panel.add(lblSeleccione);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(210, 400, 402, 44);
		getContentPane().add(panel_2);
		
		JPanel panel_resultados = new JPanel();
		panel_resultados.setBounds(15, 300, 500, 250);
		
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setName("aceptar");
		btnAceptar.setVerticalAlignment(SwingConstants.TOP);
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	try {
					System.exit(DISPOSE_ON_CLOSE);
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        }
		});
		
		panel_2.add(btnAceptar);
		panel_2.add(btnCancelar);
		
		btnAceptar.addActionListener(this);
		}

			private void ejecutarAplicacion(ActionEvent e) {
				this.appendToPane(this.getTextAreaResultados(),"Aplicacion ejecutada: " + appSelecionada.getName() + FIN_LiNEA, Color.WHITE);
				this.appendToPane(this.getTextAreaResultados(),"----------------------------------------------------------------------" + FIN_LiNEA, Color.WHITE);
				// TODO Auto-generated method stub
	        	for (Validar validacion : appSelecionada.getValidaciones()) {
	        		
	        		if (validacion.getClase() != null) {
		        		Class<?> clase = null ;//= validacion.getClase().class;
		        		try {
							clase = Class.forName(validacion.getClase()); //creamos la clase que viene en el xml
						} catch (ClassNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace(); 
							System.out.println("No exixte la clase: " + validacion.getClase());
						}
	
		        		try {
							Object validar = clase.newInstance(); //instanciamos la clase que debe implementar la interface ValidarInterface
							ValidarInterface valIntf = (ValidarInterface) validar;
							int val = valIntf.validar(getAppSelecionada(), validacion.getParam(), validacion.getArg());
							if (val > 0 ) {
								 //aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Verdana");
								this.appendToPane(this.getTextAreaResultados(),"Validacion: " + validacion.getName() + "--> Param: " + validacion.getParam() + "--> Resultado: OK"  + FIN_LiNEA, Color.GREEN);
								//JOptionPane.showMessageDialog(null, "Validacion: " + validacion.getName(), "Validaciones: ", JOptionPane.INFORMATION_MESSAGE);
								//this.getTextAreaResultados().setText(this.getTextAreaResultados().getText() +"Validacion: " + validacion.getName() + " Resultado: OK"  + FIN_LiNEA );
								System.out.print("Validacion ok");
								//this.getTextAreaResultados().setForeground(Color.WHITE);
							} else {
								this.getTextAreaResultados().setForeground(Color.RED);
								//JOptionPane.showMessageDialog(null, validacion.getError(), "Validaciones: ", JOptionPane.ERROR_MESSAGE);
								this.getTextAreaResultados().setText(this.getTextAreaResultados().getText() +"Validacion: " + validacion.getName() + " --> Resultado: ERROR"  + FIN_LiNEA );
								System.out.print(validacion.getError());
							}
							
						} catch (InstantiationException | IllegalAccessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	        		}
				}
	        	StringBuffer sbuffer = new StringBuffer();
	        	ArrayList<String> listProcess = new ArrayList<String>();
	        	listProcess.add(appSelecionada.getCmd());
	        	for (Param parametro : appSelecionada.getParametros()) {
	        		sbuffer.append(parametro.getOp() + SEPARADOR);
	        		if (!parametro.getOp().equals("")) {
	        			listProcess.add(parametro.getOp());
	        		}
	        		if (parametro.getSetControl() != null) {
	        			try {
	        				sbuffer.append(this.buscarElementoXParam(parametro.getName()) + SEPARADOR);
	        				listProcess.add(this.buscarElementoXParam(parametro.getName()));
						} catch (NoSuchMethodException | SecurityException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IllegalAccessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IllegalArgumentException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (InvocationTargetException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	        		} else {
	        			sbuffer.append(parametro.getValue() + SEPARADOR);
	        			listProcess.add(parametro.getValue());
	        		}
	        	}
	        	this.appendToPane(this.getTextAreaResultados(),"Ruta app: " + appSelecionada.getCmd() + FIN_LiNEA, Color.WHITE);
	        	this.appendToPane(this.getTextAreaResultados(),"Comando ejecutado: " + sbuffer.toString() + FIN_LiNEA, Color.WHITE);
	        	Process proceso = new Process();

	        	this.appendToPane(this.getTextAreaResultados(),proceso.ejecutar(appSelecionada.getCmd(), listProcess) + FIN_LiNEA, Color.WHITE);
	        	System.out.print(sbuffer);
				
			}
			
		  private void appendToPane(JTextPane tp, String msg, Color c)
		    {
		        StyleContext sc = StyleContext.getDefaultStyleContext();
		        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

		        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Verdana");
		        //aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);
		        //SimpleAttributeSet keyWord = new SimpleAttributeSet();
		        //StyleConstants.setForeground(keyWord, Color.RED);
		        //StyleConstants.setBackground(keyWord, Color.BLACK);
		        //StyleConstants.setBold(keyWord, true);
		        
		        try {
					doc.insertString(doc.getLength(), msg, aset );
					//doc.insertString(doc.getLength(), "\nEnd of text", keyWord );
				} catch (BadLocationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		       
		        
		    }

			private String buscarElementoXParam(String name) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
				// TODO Auto-generated method stub
				//deberia buscar el componente que se correponde con el parametro para armar la ejecucion
				for (Object objGrafico : appSelecionada.getObjetosGraficos()) {
	        		if (objGrafico != null) { 
	        	        Method lMethod = objGrafico.getClass().getMethod("getName",null);
	        	        Object returnValue = lMethod.invoke(objGrafico, lMethod.getParameterTypes());
	        	        if (objGrafico instanceof JRadioButton) {
	        	        	if (returnValue.toString().contains(name)) {
	        	        		JRadioButton radioButton = (JRadioButton) objGrafico;
	        	        		if (radioButton.isSelected()) {
	        	        			return radioButton.getText();
	        	        		}
	        	        	}
        	        	} else {
	        	        	if (returnValue.toString().equals(name)) { //si es el objeto obtengo el valor
		        	        	if (objGrafico instanceof JTextField) {
			        	        	//Method lMethod2 = objGrafico.getClass().getMethod("getText",null);
				        	        //Object returnValue2 = lMethod.invoke(objGrafico, lMethod2.getParameterTypes());
		        	        		JTextField text= (JTextField) getElementoXParam(name);
		        	        		return text.getText();
			        	        	//return returnValue2.toString();
		        	        	}
		        	        	if (objGrafico instanceof JComboBox) {
			        	        	//Method lMethod2 = objGrafico.getClass().getMethod("getSelectedItem",null);
				        	        //Object returnValue2 = lMethod.invoke(objGrafico, lMethod2.getParameterTypes());
				        	        JComboBox combo= (JComboBox) getElementoXParam(name);
		        	        		return combo.getSelectedItem().toString();
		        	        	}
		        	        }
        	        	}
	        	        
	        		} 
	        	}
				return null;
			}
	
	
	 protected void selectItem(ActionEvent evt) {
		 Collection<Aplication> aplicaciones;
	        if (comboBox.getSelectedItem() != null) {
	        	aplicaciones = this.getAppPrincipal().getAplicaciones();
	        	for (Aplication app : aplicaciones ) {
	    			if (app.getName().equals(comboBox.getSelectedItem().toString())) {
	    				appSelecionada = app;
	    			}  			
	    		}
	        	if (this.getPanel_1()!= null) {
	        		getContentPane().remove(this.getPanel_1());
	        	}
	        	this.setPanel_1(new JPanel(new GridBagLayout()));
	    		getPanel_1().setBorder(new TitledBorder(null, "Argumentos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	    		getPanel_1().setBounds(10, 85, 500, 200);
	    		
	        	this.generarLayoutGrafico(appSelecionada);	
	        	//getContentPane().add(this.getPanel_1());
	    		this.getPaneScrool().setBounds(10, 90, 500, 300);
	    		this.getPaneScrool() .setViewportView(this.getPanel_1());
	    		this.getPaneScrool() .getViewport().setView(this.getPanel_1());
	    		this.getPaneScrool().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    		this.getPaneScrool().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

	    		//thePane.setLayout(null);
	    		getContentPane().add(this.getPaneScrool());
	        	getContentPane().repaint();
	        	this.getPanel_1().repaint();
	        	getContentPane().revalidate();
	        	
	        }
	    }
	
	private void generarLayoutGrafico(Aplication appSelecionada) {
		// TODO Auto-generated method stub
		int col = 0;
		int fila = 0;
		GridBagConstraints constraints = new GridBagConstraints();
	
		if (appSelecionada != null) {
			for (Param parametro : appSelecionada.getParametros()) {
				//los labels siempre van en la columna 0 salvo radiobutton
				if (parametro.getLabel() != null) {
					if (parametro.getSetControl() != null && parametro.getSetControl().equals("radioButton")) {
						JLabel lblParam = new JLabel(parametro.getLabel());
						
						constraints.gridx = 0 + col; // El �rea de texto empieza en la columna cero.
						constraints.gridy = 0 + fila; // El �rea de texto empieza en la fila cero
						constraints.gridwidth = 3;   //2 columns wide
						lblParam.setAlignmentX(CENTER_ALIGNMENT);
		
						panel_1.add(lblParam,constraints);
						col++;;
					} else {
						JLabel lblParam = new JLabel(parametro.getLabel());
						
						constraints.gridx = 0 + col; // El �rea de texto empieza en la columna cero.
						constraints.gridy = 0 + fila; // El �rea de texto empieza en la fila cero
		
						panel_1.add(lblParam,constraints);
						col++;
					}
				}
				if (parametro.getSetControl() != null) {
					//si es un filechooser lo hago aca porque tiene otros componenes
					if (parametro.getSetControl().equals("filechooser")) {
						JTextField textbox = new JTextField();
						textbox.setText("ruta del archivo..");
						textbox.setName(parametro.getName()); //seteamos el nombre que viene en el xml para despues buscarlo
						
						constraints.gridx = 0 + col; // El �rea de texto empieza en la columna cero.
						constraints.gridy = 0 + fila; // El �rea de texto empieza en la fila cero
						
						panel_1.add((Component) textbox, constraints);
				        
				        JButton 	 botonSelecionar = new JButton("Seleccione Archivo");
				        
				        col++;
				        
						constraints.gridx = 0 + col; // El �rea de texto empieza en la columna cero.
						constraints.gridy = 0 + fila; // El �rea de texto empieza en la fila cero
						
						botonSelecionar.addActionListener(this); 
						botonSelecionar.setName("filechooser" +"-" + parametro.getName()); //ponemos q es un boton de filechooser y el nombre del text al que hace referencia
						panel_1.add((Component) botonSelecionar, constraints);
						
				        	 //chooser = new JFileChooser();
				        	 appSelecionada.getObjetosGraficos().add(textbox);
				        	 //chooser.setName(objecto.getName());
						} else {
							Collection<Object> objectsParam = this.crearComponente(parametro);
							constraints.gridx = 0 + col; // El �rea de texto empieza en la columna cero.
							constraints.gridy = 0 + fila; // El �rea de texto empieza en la fila cero
							for (Object object : objectsParam) {
								if (object instanceof JPanel) {//si es un radio button lo quiero abajo y con otro formato
									fila++;
									constraints.gridx = 0 ; // El �rea de texto empieza en la columna cero.
									constraints.gridy = 0 + fila; // El �rea de texto empieza en la fila cero
									constraints.gridwidth = 3;   //2 columns wide
									constraints.insets = new Insets(0,0,0,0);
								}
								panel_1.add((Component) object, constraints);
							
							}
							
						}

				}
				fila++;
				col = 0;
			}
		}
		
	}

	private Collection<Object> crearComponente(Param objecto) {
		// TODO Auto-generated method stub
		JFileChooser chooser ;
		JTextField textbox;
		JComboBox comboBoxArg;
		JRadioButton radiobutton;
		JButton botonSelecionar;
		Collection<Object> objetos = new ArrayList<Object>();
		
		String[] vecString = objecto.getValue().split(",");
		
		 switch (objecto.getSetControl()) {
	         case "textBox":
	        	   textbox = new JTextField();
	        	   textbox.setText(objecto.getValue());
	        	   //textbox.setSize(1000,10);
	        	   appSelecionada.getObjetosGraficos().add(textbox);
	        	   textbox.setName(objecto.getName());
	        	   objetos.add(textbox);
	        	   break;
	         case "comboBox":
	        	   comboBoxArg = new JComboBox(vecString);
	        	   //textbox.setSize(1000,10);
	        	   appSelecionada.getObjetosGraficos().add(comboBoxArg);
	        	   comboBoxArg.addActionListener(this);
	        	   comboBoxArg.setName(objecto.getName());
	        	   objetos.add(comboBoxArg);
	        	   break;
	         case "radioButton":
	        	 ButtonGroup grp = new ButtonGroup();
	        	 JPanel panel = new JPanel(); //panel de parametros
	        	for (int i = 0; i < vecString.length; i++) {
	        		 radiobutton = new JRadioButton(vecString[i]);
	        		 appSelecionada.getObjetosGraficos().add(radiobutton);
		        	 radiobutton.setName(objecto.getName()+i);	
		        	 radiobutton.setText(vecString[i]);
		        	 radiobutton.setSelected(true);
		        	 //radiobutton.setAlignmentY(BOTTOM_ALIGNMENT);;;;
		        	 objetos.add(panel);
		        	 grp.add(radiobutton);
		        	 panel.add(radiobutton);
		        	 panel.setBorder(BorderFactory.createLineBorder(Color.black));
				}
        	   
	        	 break;
	        	
	        // case "checkBox":
	         default :
	        	 break;
		}
		
		return objetos;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla frame = new Pantalla();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private Object getElementoXParam(String name) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		//deberia buscar el componente que se correponde con el parametro para armar la ejecucion
		for (Object objGrafico : appSelecionada.getObjetosGraficos()) {
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		final JFileChooser fc = new JFileChooser();
		if (arg0.getSource() instanceof JButton) {
			if (((JButton) arg0.getSource()).getName().contains("filechooser")) {
				int returnVal = fc.showOpenDialog(this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fc.getSelectedFile();
		            String str = (String) ((JButton) arg0.getSource()).getName().subSequence(12, ((JButton) arg0.getSource()).getName().length());
		            //This is where a real application would open the file.
		            try {
						JTextField text= (JTextField) getElementoXParam(str);
						text.setText( fc.getSelectedFile().toString());
					} catch (NoSuchMethodException | SecurityException
							| IllegalAccessException | IllegalArgumentException
							| InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} //obtengo la caja de texto que se llama igual que el boton
		        }
			} else if (arg0.getSource() instanceof JButton) { //boton aceptar ejecucion de aplicacion
				if (((JButton) arg0.getSource()).getName().contains("aceptar")) {
					ejecutarAplicacion(arg0);
				}
			}	
		} else if (arg0.getSource() instanceof JComboBox) {
			JComboBox combo;
			try {
				combo = (JComboBox) getElementoXParam(((JComboBox) arg0.getSource()).getName());
				combo.setSelectedIndex(((JComboBox) arg0.getSource()).getSelectedIndex());
			} catch (NoSuchMethodException | SecurityException
					| IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		
	}

}