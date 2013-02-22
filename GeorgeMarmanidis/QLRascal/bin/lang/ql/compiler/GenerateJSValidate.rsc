@contributor{George Marmanidis -geo.marmani@gmail.com}
module lang::ql::compiler::GenerateJSValidate

import lang::ql::ast::AST;
import lang::ql::compiler::ExtractDependencies;

public str generateJSValidateFunctions(list[FormBodyItem] bodyItems){
	str code="";
	str formValCode="function formValidate(form){\n\tvar isValid=true;";
	//2. changed by tijs--save/accept the changes, and find other relevant stuff
	return "<for (/Question q := bodyItems) {>
           '  <generateVarValidate(q.id, q.questionType, q.label)>;
           '  if (!<q.id>Validate()) { return false; }	       
	       '<}>";
	
	visit(bodyItems){
		case q:simpleQuestion(str questionId,str label,Type questionType) : {
			code+=generateVarValidate(questionId,questionType,label);
			formValCode+="\tisValid=<questionId>Validate();\n";
			formValCode+="\tif(!isValid) {return false;}\n";
			}
		case q:computedQuestion(str questionId,str label,Type questionType,_) : {
			code+=generateVarValidate(questionId,questionType,label);
			formValCode+="\tisValid=<questionId>Validate();\n";
			formValCode+="\tif(!isValid) {return false;}\n";
			}
	}
	formValCode+="\texportToCsv(form);\n";
	formValCode+="}\n";
	code+=generateStringValidFun();
	code+=generateIntegerValidFun();
	code+=generateBooleanValidFun();
	code+=generateDateValidFun();
	code+=generateMoneyValidFun();
	code+=generateFloatValidFun();
	code+=generateDownloadFun();
	
	return formValCode+code;
}
//3. output source Code as writen bellow
str generateVarValidate(str questionId,Type questionType,str questionLabel){
	return "function <questionId>Validate(){
		   '  if(<generateTypeValidation(questionId,questionType)>){
		   '    alert(\"Failed on <questionId>\");
		   '    return(false);
		   '  }
		   '  else {return true;}
		   '}
		   ";
}


//4. Change switch to Functions - not open for extensions
str generateTypeValidation(str questionId, Type questionType){
	str code="";
	
	 switch(questionType){
		case integer() : return  "!validInteger(document.getElementById(\"<questionId>\").value)";
		case string()  : code= "!validString(document.getElementById(\"<questionId>\").value)";
		case boolean() : code= "!validBoolean(\"<questionId>\")";
		case date()	   : code= "!validDate(document.getElementById(\"<questionId>\").value)";
		case money()   : code= "!validMoney(document.getElementById(\"<questionId>\").value)";
		case float()   : code= "!validFloat(parseFloat(document.getElementById(\"<questionId>\").value))";
	}
	
	return code;
}
//5. Remove stuff from here..External JS that provide these functions
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
		return /^-{0,1}\\d+[,]?\\d{0,2}$/.test(inpt);}\n\n";
}

str generateFloatValidFun(){
	return "function validFloat(input){
		if(input==\"\"){return true;}
		return /^-{0,1}\\d+[.]?\\d{0,2}$/.test(inpt);}\n\n";
}
//6. Check for boolean output
str generateDownloadFun(){
	return "function exportToCsv(form) {
            '\tvar myCsv = \"\";
			'\tfor(i=0; i\<form.elements.length-1; i++)
			'\tif(form.elements[i].getAttribute(\"type\")!=\"radio\"){
			'\tmyCsv+=form.elements[i].name +\" : \" +form.elements[i].value + \";\\n\" ;
			'}
			'else {
			'if(form.elements[i].checked) myCsv+=form.elements[i].name + \" : true\\n\" ;
			'}
			'\twindow.open(\'data:text/csv;charset=utf-8,\' + escape(myCsv));
        	'}";
	
}
