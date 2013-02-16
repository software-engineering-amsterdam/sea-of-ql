module template::PHP

import IO;

public void createPostValuePHP(str formId, str varName){
	str result = "echo \'{ \"message\": \"\' . $_POST[\'<varName>\'] . \'\" }\';";
	appendToPHPFile(formId, result);
}

public void testPHP(str formId){
	str result = "Thank you for answering the questions \</br\>
	\<?php  echo \'{ \"message\": \"\' . $_POST[\'privateDebt\'] . \'\" }\';  ?\> ";
	appendToPHPFile(formId, result);
}

public void generateDatabaseCode(str formId){
	createDataBaseCode(formId);
	createTableCode(formId);
}

void createDataBaseCode(str formId){
	str result = "$dbhost = \'localhost\';
$dbuser = \'root\';
$dbpass = \'\';
$conn = mysql_connect($dbhost, $dbuser, $dbpass);
if(! $conn )
{
  die(\'Could not connect: \' . mysql_error());
}
echo \'Connected successfully\';
$sqlDatabase = \'CREATE Database <formId>\';
$retval = mysql_query( $sqlDatabase, $conn );
if(! $retval )
{
  die(\'Could not create database: \' . mysql_error());
}
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
echo \"Table <formId> created successfully\n\"; 
mysql_close($conn); ";
	appendToPHPFile(formId, result);
}

public void appendToPHPFile(str formId, str text){
	l = |file:///wamp/www/<formId>|;
	l += "<formId>.php";
	appendToFile(l, "\n <text>");
}
