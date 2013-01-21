package org.uva.sea.ql.checker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.errors.FormCheckerError;
import org.uva.sea.ql.errors.ParseError;
import org.uva.sea.ql.parser.rats.RatsParser;
import org.uva.sea.ql.util.Stack;

public class FormChecker {

	private PrintStream out;
	
	public FormChecker(){
		this.out = new PrintStream(System.out);
	}
	
	
	private boolean correctNumberOfArgs(String [ ] args){
		return args.length < 2 || args.length > 2;
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
	
	
	private ASTNode parse(String input) throws ParseError{
		return new RatsParser().parse(input); 
	}
	
	
	private void checkForm(ASTNode form) throws Exception{
		form.accept(new VisitorFormChecking(), new Stack() );
	}
	
	
	private void executeValidation(String filename) throws Exception{
		String input = readFile(filename);
		ASTNode form = parse(input);
		
		checkForm(form);
		
		//no exceptions were thrown, so parsing and checking succeeded
		out.printf("Form validation succeeded!\n");
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
			executeValidation(filename);
		}
		catch(FileNotFoundException e){
			out.printf("Cannot open file %s\n", filename);
		}
		catch(ParseError e){
			out.printf("Failed to correctly parse form:\n%s\n", e.getMessage());
		}
		catch(FormCheckerError e){
			out.printf("Form validation failed due to the following:\n%s\n", e.getMessage());
		}
		catch(Exception e){
			out.printf("A miscellaneous error occurred:\n%s\n", e.getMessage());
		}
	}
	
	
	public static void main(String [ ] args){
		new FormChecker().start(args);	
	}
	
}
