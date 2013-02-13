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

private str generateQuestionLabel(str id, str label){
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

private str createEndingLabel(str id){
	return "var <id>EndLabel = document.createElement(\'label\');
	 <id>EndLabel.htmlFor = <id>;
	 <id>EndLabel.innerHTML = \"Yes\"; 
	 <id>EndLabel.class = \"<id>EndClass\" ";
}

str generateParagraph(str id, str att, str lab, str endlab){
	str p = "var <id>Paragraph = document.createElement(\'p\');
	<id>Paragraph.appendChild(<id>Label);
	<id>Paragraph.appendChild(<id>);
	<id>Paragraph.appendChild(<id>EndLabel);
	";
	
	return p;
}

/** Method to generate Question 
*/
private str generateQuestion(str formId, question:easyQuestion(str id, str labelQuestion, Type tp)){
	println("in generate Question <question>");
	// document.write(\"\<p\>  \</p\>\");
	if(tp == boolean()){	
		str label = generateQuestionLabel(id, labelQuestion);
		str attributes = specifyAttributes(id);
		str check = createEndingLabel(id);
		str paragraph = generateParagraph(id, label, attributes, check);
		println("paragraph : <paragraph>");
		return "var <id> = document.createElement(\"input\");
		<attributes> 
		<label>
		<check>
		<paragraph>
		<formId>.appendChild(<id>Paragraph);	
		 ";
	}else if(tp == money()){
		println();
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

public str generateBody(str id, Body body){
	println("in generate Body <body>");
	for(s <- body){
		visit(s){
			case Question q : {
				return generateQuestion(id, q);
			}
			case Statement s : {
				return generateStatement(s);
			}
		}
	}	
}

public str generateQLForm(Program P){
	if(program(str id, list[Body] Body) := P){
		println("in generate JavaScriptForm");
		str res = "\<!DOCTYPE html\>
		\<html\>
		\<head\>
		\<script src=\"<id>.js\"\>
		\</script\>
		\<link href=\"<id>.css\" rel=\"stylesheet\" type=\"text/css\"\>
		\</head\>
		\<body\>
		\<script\>
			createForm();
		\</script\>
		\</body\>
		\</html\>";	
		str functions = javaScriptCreateForm(id, Body);
		generateQLProgram(id,res,functions);
		return res;
	}else{
		return "not possible to generate java script code";
	}
}

public str generateQLForm(str txt) = generateQLForm(load(txt));


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