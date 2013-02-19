module template::PHP

import IO;
import syntax::AbstractSyntax;
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
	createDataBaseCode(formId);
	createTableCode(formId);
}

/** Method to generate the PHP code to create the database
* @param formId the name of the questionaire
* @author Philipp
*/
void createDataBaseCode(str formId){
	str result = "$dbhost = \'localhost\';
				'	$dbuser = \'root\';
				'	$dbpass = \'\';
				'	$conn = mysql_connect($dbhost, $dbuser, $dbpass);
				'	if(! $conn ) { die(\'Could not connect: \' . mysql_error()); }
				'	echo \'Connected successfully\';
				'	$sqlDatabase = \'CREATE Database <formId>\'; 
				'	$retval = mysql_query( $sqlDatabase, $conn );
				'	if(! $retval ) { echo \'Database <formId> exist already \'; }
				'	echo \"Database <formId> created successfully\";";
	appendToPHPFile(formId, result);
}

/** Method to generate the PHP code to create the database table
* @param formId the name of the questionaire
* @author Philipp
*/
void createTableCode(str formId){
	str result = "$sqlTable = \'CREATE TABLE <formId>( \'.
       	'	\'q_id INT NOT NULL AUTO_INCREMENT, \'.
       	'	\'primary key ( q_id ))\';
		' mysql_select_db(\'<formId>\');
		' $retval = mysql_query( $sqlTable, $conn );
		' if(! $retval ) { echo \"Table <formId> exist already \";  }
		' echo \"Table <formId> created successfully\";  ";
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
				println("temp : <temp>");
				idAndType += [<toString(temp[0]),temp[2]>];
			}
		}
	}
	println("idsAndType : <idAndType>");
	validation = addServerSideValidation(formId, idAndType);
	str result = "if(<for(k <- validation) {> <k> <}>){
				'	$query = \"INSERT INTO <formId> ( q_id, <for(i <- idAndType) { > <i.id>, < }>)
				'	VALUES(\'NULL\', <for(i <- idAndType) { > \'\".$<i.id>.\"\', < }>)\";
				'	mysql_query( $query, $conn ); 
				'}else{
				'	echo \'Validation Error\';	
				'}";
	appendToPHPFile(formId,result);
}

list[str] addServerSideValidation(str formId, list[tuple[str id,value typ]] idsAndType){
	println("in add validation");
	list[str] result = [];
	for(i <- idsAndType){
		if(i.typ == boolean()){
			addBoolValidation(formId, i.id);
			result += "is_bool($<i.id>) &&";  // boolean is saved as tiny int in mysql
		}else if(i.typ == string()){
			result += "is_string($<i.id>) &&";
		}else{
			result += "is_numeric($<i.id>) &&";
		}
	}
	return result;
}

void addBoolValidation(str formId, str varName){
	str result = "if (is_null($_POST[\'<varName>\'])) {
   				'	$<varName> = false;
				'	}else{
				'	$<varName> = true;
				'}";
	appendToPHPFile(formId,result);
}

/** Method to append PHP code to a PHP file
* @param formId the name of the JavaScript file
* @param text the PHP code to append
* @author Philipp
*/
public void appendToPHPFile(str formId, str text){
	l = |file:///wamp/www/<formId>/<formId>.php|;
	appendToFile(l, "\n <text>");
}
