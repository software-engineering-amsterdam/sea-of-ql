module template::StringTemplate

import IO;
import String;
import syntax::AbstractSyntax;
import typeChecker::TypeCheck;
import util::Load;

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
private str generateQuestion(){
	// ToDo
}

private str generateBody(list[Body] body){
	println("in generate Body <body>");
	for(s <- body){
		visit(s){
			case Question q : {
				println("QQQQQ is : <q>");
				generateQuestion(q);
			}
		}
	}
//	\<input type=\"checkbox\" id=\"check1\"\>Do you like summer?
	
}

public str generateJavaScriptForm(Program P){
	if(program(str id, list[Body] Body) := P){
		println("in generate JavaScriptForm");
		return "\<!DOCTYPE html\>
		\<html\>
		\<body\>
		\<form action = \" \" method = \"post\" name=<id>\>
		<generateBody(Body)>
		
		\</form\>
		\</body\>
		\</html\>";
		
	}else{
		return "not possible to generate java script code";
	}
}

//\<select name=\"URL\"
//		onchange=\"javascript:window.location.href=this.form.URL.options
//		[this.form.URL.selectedIndex].value\"\>
//		\<option\>Choose One\</option\>
//		\<option value=\"http://webdesign.about.com/\"\>Web Design Home Page\</option\>
//		\<option value=\"http://webdesign.about.com/library/weekly/mpreviss.htm\"\>Previous Articles\</option\>
//		\<option value=\"http://webdesign.about.com/library/beginning/bl_begin.htm\"\>Beginning HTML\</option\>
//		\</select\>

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