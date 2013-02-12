module template::StringTemplate

import IO;
import String;
import Prelude;
import syntax::AbstractSyntax;
import typeChecker::TypeCheck;
import util::Load;
import template::File;

// Capitalize the first character of a string

public str capitalize(str s) {  
  return toUpperCase(substring(s, 0, 1)) + substring(s, 1);
}

// Helper function to generate a setter
private str genSetter(map[str,str] fields, str x) {
  return "public void set<capitalize(x)>(<fields[x]> <x>) {
         '  this.<x> = <x>;
         '}";
}

// Helper function to generate a getter
private str genGetter(map[str,str] fields, str x) {
  return "public <fields[x]> get<capitalize(x)>() {
         '  return <x>;
         '}";
}

/** Method to generate Question
*/
private str generateQuestion(question:easyQuestion(str id, str labelQuestion, Type tp)){
	println("in generate Question <question>");
	if(tp == boolean()){
		return "<labelQuestion> \<input type=\"checkbox\" id=<id> \> Yes";
	}else if(tp == money()){
		return "<labelQuestion> \<input type=\"checkbox\" id=<id> \> Yes";
	}else if(tp == string()){
		return "<labelQuestion> \<input type=\"checkbox\" id=<id> \> Yes";
	}
	
}

private str generateQuestion(question:computedQuestion(str id, str labelQuestion, Type tp, Expression exp)){
	println("in generate computed Question <question>");
	if(tp == boolean()){
		return "<labelQuestion> \<input type=\"checkbox\" id=<id> \> Yes";
	}
	
}

//private str generateBody(list[Body] body){
//	list[str] ques = [];
//	for(s <- body){
//		visit(s){
//			case Question q : {
//				ques += generateQuestion(q);
//			}
//		}
//	}
//	return ques;	
//}

private str generateBody(Body body){
	println("in generate Body <body>");
	list[str] ques = [];
	for(s <- body){
		visit(s){
			case Question q : {
				//println("QQQQQ is : <q>");
				return generateQuestion(q);
				ques += generateQuestion(q);
			}
			case Statement s : {
				return generateStatement(s);
			}
		}
	}
	println("Ques : <ques>");
	return ques;	
}

public str generateJavaScriptForm(Program P){
	if(program(str id, list[Body] Body) := P){
		println("in generate JavaScriptForm");
		str res = "\<!DOCTYPE html\>
		\<html\>
		\<body\>
		\<form action = \" \" method = \"post\" name=<id>\>
		<for (s <- Body) { >
		<generateBody(s)> \</br\>
		< } >				
		\</form\>
		\</body\>
		\</html\>";
		generateJavaScript(id,res);
		return res;
	}else{
		return "not possible to generate java script code";
	}
}

public str generateJavaScriptForm(str txt) = generateJavaScriptForm(load(txt));

// Generate a class with given name and fields.

public str genClass(str name, map[str,str] fields) { 
  return 
    "public class <name> {
    '  <for (x <- fields) {>
    '  private <fields[x]> <x>;
    '  <genSetter(fields, x)>
    '  <genGetter(fields, x)><}>
    '}";
}