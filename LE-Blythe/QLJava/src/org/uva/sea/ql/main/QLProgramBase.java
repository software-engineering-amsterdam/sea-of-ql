package org.uva.sea.ql.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.parser.rats.ParseError;
import org.uva.sea.ql.parser.rats.RatsParser;

public abstract class QLProgramBase {

	protected PrintStream out;
	
	public QLProgramBase(){
		this.out = new PrintStream(System.out);
	}
	
	
	protected boolean correctNumberOfArgs(String [ ] args){
		return args.length == 1;
	}
		
	
	protected boolean correctFileTypeProvided(String filename){
		return filename.endsWith(".ql");
	}
	
	
	protected String readFile(String filename) throws FileNotFoundException {
		
		Scanner scanner = new Scanner(new File(filename));
		String contents = "";
		
		while(scanner.hasNext()){
			contents += String.format("%s\n", scanner.nextLine());
		}
		
		scanner.close();
		return contents;
	}
	
	
	protected Form parse(String input) throws ParseError{
		return new RatsParser().parse(input); 
	}
	
	
	protected Form readAst(String filename) throws Exception {
			return parse(readFile(filename));
	}
	
	
	public void start(String [ ] args){
		
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
			execute(readAst(filename));
		}
		catch(FileNotFoundException e){
			out.printf("Cannot open file %s\n", filename);
		}
		catch(ParseError e){
			out.printf("Failed to correctly parse form:\n%s\n", e.getMessage());
		}
		catch(Exception e){
			out.printf("An error occurred:\n%s\n", e.getMessage());
		}
		
	}
	
	
	protected abstract void execute(Form form);
	
}
