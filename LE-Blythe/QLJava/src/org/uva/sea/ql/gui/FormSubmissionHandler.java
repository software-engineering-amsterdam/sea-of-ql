package org.uva.sea.ql.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.util.Environment;
import org.uva.sea.ql.util.VisitorExprPrint;

public class FormSubmissionHandler implements ActionListener{

	Environment environment;
	String 		formName;
	
	public FormSubmissionHandler(String formName, Environment environment){
		this.formName = formName;
		this.environment = environment;
	}
	
	
	private void write(BufferedWriter out, String format, Object... args) throws Exception{
		out.write(String.format(format, args));
	}
	
	
	private void print(BufferedWriter out, Environment env) throws Exception{
		
		 VisitorExprPrint printer = new VisitorExprPrint();
		 
		 write(out, "{\n\r");
		 
		 for(Ident i: env.getIdentifiers()){
			  write(out, "%s=%s;\n\r", i.getName(),env.getValue(i).accept(printer));
		  }
		 
		 for(Environment subEnv: env.getBranchedEnvironments()){
			print(out, subEnv);
		 }
		 
		 write(out, "}\n\r");
	}
	
	
	private void writeToFile(){
		 try{
			  
			  FileWriter fstream = new FileWriter(formName + ".txt");
			  BufferedWriter out = new BufferedWriter(fstream);
			  
			  print(out, environment);
			  
			  out.close();
		}catch (Exception e){
			  System.err.println("Error: " + e.getMessage());
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		writeToFile();
	}

}
