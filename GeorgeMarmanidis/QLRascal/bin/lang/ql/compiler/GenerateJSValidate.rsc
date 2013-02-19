module lang::ql::compiler::GenerateJSValidate

import lang::ql::ast::AST;
import lang::ql::compiler::ExtractDependencies;

public str generateJSValidateFunctions(list[FormBodyItem] bodyItems){
	str code="";
	str formValCode="function formValidate(){\n";
	
	visit(bodyItems){
		case q:simpleQuestion(str questionId,str label,Type questionType) : {
			code+=generateVarValidate(questionId,questionType,label);
			formValCode+="\t<questionId>Validate();\n";
			}
		case q:computedQuestion(str questionId,str label,Type questionType,_) : {
			code+=generateVarValidate(questionId,questionType,label);
			formValCode+="\t<questionId>Validate();\n";
			}
	}
	
	formValCode+="}\n";
	code+=generateStringValidFun();
	code+=generateIntegerValidFun();
	code+=generateBooleanValidFun();
	code+=generateDateValidFun();
	code+=generateMoneyValidFun();
	code+=generateFloatValidFun();
	
	return formValCode+code;
}

str generateVarValidate(str questionId,Type questionType,str questionLabel){
	return "function <questionId>Validate(){
		 '\tif(<generateTypeValidation(questionId,questionType)>){
		 '\t\talert(\"Failed on <questionId>\");
		 '\t\treturn(false);}
		 '}\n";
}

str generateTypeValidation(str questionId,Type questionType){
	str code="";
	
	switch(questionType){
		case integer() : code= "!validInteger(document.getElementById(\"<questionId>\").value)";
		case string()  : code= "!validString(document.getElementById(\"<questionId>\").value)";
		case boolean() : code= "!validBoolean(\"<questionId>\")";
		case date()	   : code= "!validDate(document.getElementById(\"<questionId>\").value)";
		case money()   : code= "!validMoney(document.getElementById(\"<questionId>\").value)";
		case float()   : code= "!validFloat(parseFloat(document.getElementById(\"<questionId>\").value))";
	}
	
	return code;
}

str generateStringValidFun(){
	return "function validString(input){
    		return !(/[\\\\/&;]/.test(input));}\n\n";
}

str generateIntegerValidFun(){
	return "function validInteger(input){
		if(input==\"\"){return true;}
		return /(^-?\\d\\d*$)/.test(input);}\n\n";
}

str generateBooleanValidFun(){
	return "function validBoolean(input){
		return true;
		}\n\n";
}

str generateDateValidFun(){
	return "function validDate(input){
		if(input==\"\"){return true;}
		return /^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$/.test(input);}\n\n";
}

str generateMoneyValidFun(){
	return "function validMoney(input){
		if(input==\"\"){return true;}
		return true;}\n\n";
}

str generateFloatValidFun(){
	return "function validFloat(input){
		if(input==\"\"){return true;}
		return true;}\n\n";
}
