package org.uva.sea.ql.gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.parser.rats.ParseError;
import org.uva.sea.ql.parser.rats.RatsParser;

public class QLRenderer {

	private PrintStream out;
	
	public QLRenderer(){
		this.out = new PrintStream(System.out);
	}
	
	
	private boolean correctNumberOfArgs(String [ ] args){
		return args.length == 1;
	}
		
	
	private boolean correctFileTypeProvided(String filename){
		return filename.endsWith(".ql");
	}
	
	
	private String readFile(String filename) throws FileNotFoundException {
		
		Scanner scanner = new Scanner(new File(filename));
		String contents = "";
		
		while(scanner.hasNext()){
			contents += String.format("%s\n", scanner.nextLine());
		}
		
		scanner.close();
		return contents;
	}
	

	private Statement parse(String input) throws ParseError{
		return new RatsParser().parse(input); 
	}
	
	
	
	private void execute(String filename) throws Exception{
		String input = readFile(filename);
		Form form = (Form)parse(input);
		
		VisitorRenderStatement.Render(form);
	}
	
	
	private void start(String[] args){
		
		if(!correctNumberOfArgs(args)){
			out.printf("Usage: FormChecker <ql-file>\n");
			return;
		}
		
		String filename = args[0];
		
		if(!correctFileTypeProvided(filename)){
			out.printf("Provided file must have extension .ql\n");
			return;
		}
		
		try{
			execute(filename);
		}
		catch(FileNotFoundException e){
			out.printf("Cannot open file %s\n", filename);
		}
		catch(Exception e){
			out.printf("Failure to interpret: %s\n", e.getMessage());
		}
	}
	
	
	public static void main(String[] args){
		new QLRenderer().start(args);
	}
}
