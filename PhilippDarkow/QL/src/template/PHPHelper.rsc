module template::PHPHelper

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