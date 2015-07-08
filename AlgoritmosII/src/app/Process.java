package app;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Process {
	private ProcessBuilder p;

	public ProcessBuilder getP() {
		return p;
	}

	public void setP(ProcessBuilder p) {
		this.p = p;
	}
	
	public StringBuffer ejecutar(String comando, ArrayList<String> listProcess) {
		StringBuffer sbufferResultados = new StringBuffer();
		//this.setP(new ProcessBuilder(comando, sbuffer.toString()));

		this.setP(new ProcessBuilder(listProcess)); 
		try {
			
			//java.lang.Process p2 = this.getP().start();
			//InputStream consola = p2.getInputStream();

			//int result = commandExecutor.executeCommand();
			//consola.read();

			System.out.println("Run echo command");
			sbufferResultados.append("Comenzando ejecucion \n");
			java.lang.Process process = this.getP().start();
			int errCode = process.waitFor();
			String resultados = output(process.getErrorStream());
			if (errCode==0) {
				sbufferResultados.append("App ejecutada correctamente \n");
				sbufferResultados.append("┌─┐　─┐☆ \n");
				sbufferResultados.append("│▒│ /▒/	\n");	
				sbufferResultados.append("│▒│/▒/    \n");
				sbufferResultados.append("│▒ /▒/─┬─┐\n");
				sbufferResultados.append("│▒│▒|▒│▒│ \n");
				sbufferResultados.append("┌┴─┴─┐-┘─┘\n");
				sbufferResultados.append("│▒┌──┘▒▒▒│\n");
				sbufferResultados.append("└┐▒▒▒▒▒▒┌┘\n");
				sbufferResultados.append("└┐▒▒▒▒┌	\n");
				System.out.println("Echo error:\n" + resultados);
			} else {
				sbufferResultados.append("App ejecutada con ERROR \n");
				sbufferResultados.append(resultados);	
			}
			
			if (resultados != null && !resultados.isEmpty()) {
				sbufferResultados.append("Salida Proceso: \n");
				sbufferResultados.append(resultados);
				System.out.println("Echo Output:\n" + resultados);	
				sbufferResultados.append("Fin Salida Proceso \n");
				sbufferResultados.append("---------------------------------------------------------------------- \n");
			}
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sbufferResultados;
		
	}
	
	 private static String output(InputStream inputStream) throws IOException {
		
		 	        StringBuilder sb = new StringBuilder();
		 	        BufferedReader br = null;
		 
		 	        try {		 
		 	            br = new BufferedReader(new InputStreamReader(inputStream));		 
		 	            String line = null;
		 
		 	            while ((line = br.readLine()) != null) {		 
		 	                sb.append(line + System.getProperty("line.separator"));		 
		 	            }
		 
		 	        } finally {		 
		 	            br.close();
		 	        }
		 	        return sb.toString();
		 
		 	    }

}