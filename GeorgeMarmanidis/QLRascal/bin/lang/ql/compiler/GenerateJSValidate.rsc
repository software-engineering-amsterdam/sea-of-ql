@contributor{George Marmanidis -geo.marmani@gmail.com}
module lang::ql::compiler::GenerateJSValidate

import lang::ql::ast::AST;
import lang::ql::compiler::ExtractDependencies;

public str generateJSValidateFunctions(list[FormBodyItem] bodyItems){
	str code="";
	str formValCode="function formValidate(form){\n\tvar isValid=true;\n";
	
	for(/Question q := bodyItems){
		code+=generateVarValidate(q.questionId,  q.questionType,q.questionLabel);
		formValCode+="\tisValid=<q.questionId>Validate();
					 '\tif(!isValid) {return false;}\n";
	}
	
	formValCode+="\texportToCsv(form);
	             '}
				 ";	
	return formValCode+code;
}
//3. output source Code as writen bellow
str generateVarValidate(str questionId,Type questionType,str questionLabel){
	return "function <questionId>Validate(){
		   '  if(<generateTypeValidation(questionId,questionType)>){
		   '     alert(\"Failed on <questionId>\");
		   '     return(false);
		   '  }
		   '  else {return true;}
		   '}
		   '
";
}

str generateTypeValidation(str questionId, integer())="!validInteger(document.getElementById(\"<questionId>\").value)";
str generateTypeValidation(str questionId, /string())="!validString(document.getElementById(\"<questionId>\").value)";
str generateTypeValidation(str questionId, /boolean())="!validBoolean(\"<questionId>\")";
str generateTypeValidation(str questionId, /date())="!validDate(document.getElementById(\"<questionId>\").value)";
str generateTypeValidation(str questionId, /money())="!validMoney(document.getElementById(\"<questionId>\").value)";
str generateTypeValidation(str questionId, /float())="!validFloat(parseFloat(document.getElementById(\"<questionId>\").value))";

