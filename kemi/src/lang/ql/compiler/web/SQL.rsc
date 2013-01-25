module lang::ql::compiler::web::SQL

import IO;
import String;
import lang::ql::ast::AST; 

public void SQL(Form f, loc dest) {
  dest += "database.sql";
  
  writeFile(dest, "");
    
  str title = "";
  list[Question] questions = [];
  
  top-down visit(f) {
    case form(name, _): title = name;
    case q: question(_, _, _): questions += [q];
    case q: question(_, _, _, _): questions += [q];
  }
  
  createSQL(title, questions, dest);
}

private void createSQL(str title, list[Question] questions, loc dest) {
  html = 
  "CREATE TABLE IF NOT EXISTS `<title>` (
  '  `id` int(255) unsigned NOT NULL AUTO_INCREMENT,
  '<for(q <- questions) {>
  '  <createQuestion(q)>
  '<}>
  '  PRIMARY KEY (`id`)
  ') ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;
  ";
  appendToFile(dest, html);
}

private str createQuestion(Question q: 
  question(questionText, answerDataType, answerIdentifier)) =
    "`<answerIdentifier>` <answerDataType>,
    '";

private str createQuestion(Question q: 
  question(questionText, answerDataType, answerIdentifier, calculatedField)) =
    "`<answerIdentifier>` <answerDataType>,
    '";
