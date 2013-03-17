module template::PHPHelper

import Prelude;

public str getDataBaseString(str formId){
	return "$dbhost = \'localhost\';
				'	$dbuser = \'root\';
				'	$dbpass = \'\';
				'	$conn = mysql_connect($dbhost, $dbuser, $dbpass);
				'	if(! $conn ) { die(\'Could not connect: \' . mysql_error()); }
				'	echo \'Connected successfully\';
				'	$sqlDatabase = \'CREATE Database <formId>\'; 
				'	$retval = mysql_query( $sqlDatabase, $conn );
				'	if(! $retval ) { echo \'Database <formId> exist already \'; }
				'	echo \"Database <formId> created successfully\";";
}

public str getTableString(str formId){
	return "$sqlTable = \'CREATE TABLE <formId>( \'.
       	'	\'q_id INT NOT NULL AUTO_INCREMENT, \'.
       	'	\'primary key ( q_id ))\';
		' mysql_select_db(\'<formId>\');
		' $retval = mysql_query( $sqlTable, $conn );
		' if(! $retval ) { echo \"Table <formId> exist already \";  }
		' echo \"Table <formId> created successfully\";";
}

public str getValueInDatabaseString(list[str] validation, str formId,list[tuple[str id,value typ]] idAndType){
	return "if(<for(k <- prefix(validation)) {> <k> && <}> <last(validation)>){
				'	$query = \"INSERT INTO <formId> ( q_id, <for(i <- prefix(idAndType)) { > <i.id>, < }> <last(idAndType).id>)
				'	VALUES(\'NULL\', <for(i <- prefix(idAndType)) { > \'\".$<i.id>.\"\', < }> \'\".$<last(idAndType).id>.\"\')\";
				'	mysql_query( $query, $conn ); 
				'}else{
				'	echo \'Validation Error\';	
				'}";
}

public str getBoolValidationString(str varName){
	return "if (isset($_POST[\'<varName>\'])) {
   				'	$<varName> = true;
				'	}else{
				'	$<varName> = false;
				'}";
}