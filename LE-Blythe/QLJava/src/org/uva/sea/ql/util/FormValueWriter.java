package org.uva.sea.ql.util;

import java.io.BufferedWriter;
import java.io.FileWriter;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.eval.value.Value;

public class FormValueWriter implements IWriter {

	Environment<Ident, Value> environment;
	String formName;
	
	public FormValueWriter(String formName, Environment<Ident, Value> environment){
		this.formName = formName;
		this.environment = environment;
	}
	
	
	private void write(BufferedWriter out, String format, Object... args) throws Exception{
		out.write(String.format(format, args));
	}
	
	
	private void print(BufferedWriter out, Environment<Ident, Value> env) throws Exception{
		
		 write(out, "{\n\r");
		 
		 for(Ident i: env.getIdentifiers()){
			  write(out, "%s=%s;\n\r", i.getName(),env.get(i).toString());
		  }
		 
		 for(Environment<Ident, Value> subEnv: env.getBranchedEnvironments()){
			print(out, subEnv);
		 }
		 
		 write(out, "}\n\r");
	}
	
	
	public void write(){
		 try{
			  
			  FileWriter fstream = new FileWriter(formName + ".txt");
			  BufferedWriter out = new BufferedWriter(fstream);
			  
			  print(out, environment);
			  
			  out.close();
		}catch (Exception e){
			  System.err.println("Error: " + e.getMessage());
		}
	}
}
