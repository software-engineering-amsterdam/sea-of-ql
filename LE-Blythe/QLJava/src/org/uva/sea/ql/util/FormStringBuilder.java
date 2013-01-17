package org.uva.sea.ql.util;

public class FormStringBuilder {

	public static String question(String identifier, String expression){
		return String.format("\"question\" %s:%s", identifier, expression);
	}
	
	
	public static String question(String question, String identifier, String expression){
		return String.format("\"%s\" %s:%s", question, identifier, expression);
	}
	
	
	public static String body(String... args){

		String sBody = "";
				
		//insert each element
		for (String arg : args) {
			  sBody += String.format("%s", arg);
		}
		
		return sBody;
	}
	
	
	public static String ifStatement(String condition, String... args){
		return String.format("if(%s){ %s }", condition, body(args));
	}
	
	
	public static String elseStatement(String... args){
		return String.format("else{ %s }", body(args));
	}
	
	
	public static String form(String name, String... args){
		return String.format("form %s{ %s }", name, body(args));
	}
	
}
