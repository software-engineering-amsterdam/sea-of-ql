module template::PHP

import IO;
import syntax::AbstractSyntax;
import template::PHPHelper;
import Prelude;

// ADD server side validation
// OUTLINE !!!


/** Method to create a code snippet in PHP to create a variable and get the value of the form
* @param formId the name of the questionaire
* @varName the name of the question
* @author Philipp
*/
public void createPostValuePHP(str formId, str varName){
	str result = "$<varName> = $_POST[\'<varName>\'];";
	appendToPHPFile(formId, result);	
}

/** Method to generate the database and the table
* @param formId the name of the questionaire
* @author Philipp
*/
public void generateDatabaseCode(str formId){
	createDataBaseCode(formId);						// create the code for the database 
	createTableCode(formId);						// create the code for the database table
}

/** Method to generate the PHP code to create the database
* @param formId the name of the questionaire
* @author Philipp
*/
void createDataBaseCode(str formId){
	str result = getDataBaseString(formId);			// get the code for the database as a string
	appendToPHPFile(formId, result);
}

/** Method to generate the PHP code to create the database table
* @param formId the name of the questionaire
* @author Philipp
*/
void createTableCode(str formId){
	str result = getTableString(formId);			// get the code for the table as a string
	appendToPHPFile(formId, result);
}

/** Method generate PHP code to create a colum in a database table
* @param formId the name of the questionaire
* @param id the name of the question
* @param tp the type of the question
* @author Philipp
*/
public void createColumnInTable(str formId, str id, Type tp){
	str result = "";
	if(tp == money()){
		result = "$insert<id> = \'ALTER TABLE <formId> ADD <id> REAL\';
				'	mysql_query( $insert<id>, $conn ); ";
	}else if(tp == integer()){
		result = "$insert<id> = \'ALTER TABLE <formId> ADD <id> INT\';
				'	mysql_query( $insert<id>, $conn ); ";
	}else if(tp == boolean()){
		result = "$insert<id> = \'ALTER TABLE <formId> ADD <id> BOOL\';
				'	mysql_query( $insert<id>, $conn ); ";
	}
	appendToPHPFile(formId, result);
}

/** Method to generate PHP to insert the form values in the database table
* @param formId the name of the questionaire
* @param body
* @author Philipp
*/
public void insertValueInDatabase(str formId,  list[Body] body){  
	list[tuple[str id,value typ]] idAndType = [];
	for(s <- body){
		visit(s){
			case Question e : {
				list[value] temp = getChildren(e);
				idAndType += [<toString(temp[0]),temp[2]>];
			}
		}
	}
	println("idsAndType : <idAndType>");
	validation = addServerSideValidation(formId, idAndType);
	str result = getValueInDatabaseString(validation, formId,idAndType);		// get the insert code as a string
	appendToPHPFile(formId,result);
}

list[str] addServerSideValidation(str formId, list[tuple[str id,value typ]] idsAndType){
	list[str] result = [];
	for(i <- idsAndType){						// run through the list
		if(i.typ == boolean()){					// check on the type
			addBoolValidation(formId, i.id);
			result += "is_bool($<i.id>)"; 
		}else if(i.typ == string()){
			result += "is_string($<i.id>)";
		}else{
			result += "is_numeric($<i.id>)";
		}
	}
	return result;								// return a list with PHP code
}

/** Method to add server side boolean validation
* @param formId
* @param varName
* @author Philipp
*/
void addBoolValidation(str formId, str varName){
	str result = getBoolValidationString(varName);		// get the code for bool validation as a string
	appendToPHPFile(formId,result);
}

/** Method to append PHP code to a PHP file
* @param formId the name of the JavaScript file
* @param text the PHP code to append
* @author Philipp
*/
public void appendToPHPFile(str formId, str text){
	l = |file:///wamp/www/<formId>/<formId>.php|;		// location of the PHP File
	appendToFile(l, "\n <text>");						// append code to the PHP File
}
