module template::PHP

import IO;
import syntax::AbstractSyntax;

public void createPostValuePHP(str formId, str varName){
	// $$query<varName> = \'INSERT INTO <formId> ()
	str result = "$<varName> = $_POST[\'<varName>\'];
	if(isset($<varName>)){	
	echo \'{ \"message\": \"\' . $_POST[\'<varName>\'] . \'\" }\';
	};";
	appendToPHPFile(formId, result);
}



public void generateDatabaseCode(str formId){
	createDataBaseCode(formId);
	createTableCode(formId);
}

void createDataBaseCode(str formId){
	str result = "$dbhost = \'localhost\'; $dbuser = \'root\'; $dbpass = \'\'; $conn = mysql_connect($dbhost, $dbuser, $dbpass);
		if(! $conn ) { die(\'Could not connect: \' . mysql_error()); }
		echo \'Connected successfully\';
		$sqlDatabase = \'CREATE Database <formId>\'; $retval = mysql_query( $sqlDatabase, $conn );
		if(! $retval ) { die(\'Could not create database: \' . mysql_error()); }
		echo \"Database <formId> created successfully\n\"; ";
	appendToPHPFile(formId, result);
}

void createTableCode(str formId){
	str result = "$sqlTable = \'CREATE TABLE <formId>( \'.
       \'emp_id INT NOT NULL AUTO_INCREMENT, \'.
       \'primary key ( emp_id ))\';

mysql_select_db(\'<formId>\');
$retval = mysql_query( $sqlTable, $conn );
if(! $retval )
{
  die(\'Could not create table: \' . mysql_error());
}
echo \"Table <formId> created successfully\n\";  ";
	appendToPHPFile(formId, result);
}

public void createColumnInTable(str formId, str id, Type tp){
	str result = "";
	if(tp == money()){
		println("in create column");
		result = "$insert<id> = \'ALTER TABLE <formId> ADD <id> REAL\';
		$retval = mysql_query( $insert<id>, $conn ); ";
	}else if(tp == integer()){
		println("in create column");
		result = "$insert<id> = \'ALTER TABLE <formId> ADD <id> INT\';
		$retval = mysql_query( $insert<id>, $conn ); ";
	}else if(tp == boolean()){
		println("in create column");
		result = "$insert<id> = \'ALTER TABLE <formId> ADD <id> BOOL\';
		$retval = mysql_query( $insert<id>, $conn ); ";
	}
	println("append to php now");
	appendToPHPFile(formId, result);
}

void insertValueInDatabase(str formId, list[str] ids, list[Body] body){   // i need to get the id of all questions
	//bottom-up visit(
	str result = "$query<varName> = \'INSERT INTO <formId> (<for(i <- ids) { > <i>, < }>)
	VALUES(<for(i <- ids) { > \'\".$<i>.\", < }>)";
	appendToPHP(formId,result);
}

public void appendToPHPFile(str formId, str text){
	l = |file:///wamp/www/<formId>|;
	l += "<formId>.php";
	appendToFile(l, "\n <text>");
}
