package org.uva.sea.ql.checker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.checker.errors.Error;
import org.uva.sea.ql.parser.rats.ParseError;
import org.uva.sea.ql.parser.rats.RatsParser;

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
		
		VisitorChecker visitor = new VisitorChecker();
		form.accept(visitor);
		
		if(visitor.getErrors().size() == 0){
			out.printf("Form validation succeeded!\n");
		}
		else{
			out.printf("Validation failed due to the following reasons:\n");
			
			for(Error e: visitor.getErrors())
				out.printf("%s", e.getMessage());
		}
		
	}
	
	
	private void executeValidation(String filename) throws Exception{
		String input = readFile(filename);
		ASTNode form = parse(input);
		
		checkForm(form);
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
		catch(Exception e){
			out.printf("A miscellaneous error occurred:\n%s\n", e.getMessage());
		}
	}
	
	
	public static void main(String [ ] args){
		new FormChecker().start(args);	
	}
	
}
