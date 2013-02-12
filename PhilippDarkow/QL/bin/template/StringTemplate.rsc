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

private str generateLabel(str id, str label){
	//value ll = toValue(id);
	println("LLLLLL : <id>");
	return "var <id>Label = document.createElement(\'label\');
	 <id>Label.htmlFor = <id>;
	 <id>Label.innerHTML = <label>; ";
}

private str specifyAttributes(str id){
	return "<id>.setAttribute(\'type\',\"checkbox\");
		<id>.setAttribute(\'id\',<id>)
		<id>.setAttribute(\'name\',<id>)
		<id>.setAttribute(\'value\',<id>) ";
}


/** Method to generate Question
*/
private str generateQuestion(str formId, question:easyQuestion(str id, str labelQuestion, Type tp)){
	println("in generate Question <question>");
	
	if(tp == boolean()){
		str label = generateLabel(id, labelQuestion);
		str attributes = specifyAttributes(id);
		//println("LABEL : <label>");
		return "var <id> = document.createElement(\"input\");
		<attributes>
		<label>
		<formId>.appendChild(<id>Label); 
		<formId>.appendChild(<id>); 
		 ";
	}else if(tp == money()){
		return "<labelQuestion> \<input type=\"checkbox\" id=<id> \> Yes";
	}else if(tp == string()){
		return "<labelQuestion> \<input type=\"checkbox\" id=<id> \> Yes";
	}
	
}

private str generateQuestion(str formId, question:computedQuestion(str id, str labelQuestion, Type tp, Expression exp)){
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

private str generateBody(str id, Body body){
	println("in generate Body <body>");
	for(s <- body){
		visit(s){
			case Question q : {
				return "<generateQuestion(id, q)> 
				document.write(\"\\n\");";
			}
			case Statement s : {
				return generateStatement(s);
			}
		}
	}	
}

public str generateJavaScriptForm(Program P){
	if(program(str id, list[Body] Body) := P){
		println("in generate JavaScriptForm");
		str res = "\<!DOCTYPE html\>
		\<html\>
		\<head\>
		\<script\>
		function createForm(){
			var <id> = document.createElement(\"form\");
			<id>.setAttribute(\'method\',\"post\");
			<id>.setAttribute(\'action\',\"submit.php\");
			<id>.setAttribute(\'name\',<id>);
			<for (s <- Body) { >
			<generateBody(id,s)> 
			
			< } >
			document.getElementsByTagName(\'body\')[0].appendChild(<id>);		
		}
		\</script\>
		\</head\>
		\<body\>
		\<script\>
			createForm();
		\</script\>
		\</body\>
		\</html\>";
		generateJavaScript(id,res);
		return res;
	}else{
		return "not possible to generate java script code";
	}
}

public str generateJavaScriptFormMoreHTML(Program P){
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


//function yesno(thecheckbox, thelabel) {
    	//var checkboxvar = document.getElementById(thecheckbox);
    	//var labelvar = document.getElementById(thelabel);
    	//	if (!checkboxvar.checked) {
        //		labelvar.innerHTML = \"Noddddddddddd\";
    	//	}
    	//	else {
        //		labelvar.innerHTML = \"Yesaaaaaaaaaa\";
    	//	}
		//}