@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::ql::util::FormGenerator

import lang::ql::util::Random;

public str randomForm(int numberOfStatements, int maxDepth) =
  "form <randomWord()> { <for (_ <- [1..numberOfStatements]) {>
  '  <randomStatement(maxDepth - 1)><}>
  '}
  '";

public str randomStatement(int maxDepth) {
  int choice;
  
  if(maxDepth > 0)
    choice = randomInt(0, 2);
  else
    choice = randomInt(0, 1);
    
  switch(choice) {
    case 0: return randomQuestion();
    case 1: return randomCalculatedQuestion();
    case 2: return randomConditional(maxDepth - 1);
  }
}

public str randomQuestion() = 
  "\"<randomSentence()>\" <randomDataType()> <randomWord(10)>";

public str randomCalculatedQuestion() = 
  randomQuestion() + " = <randomWord(10)> <randomOperator()> <randomWord(10)>";
  
public str randomConditional(int maxDepth) =
  "if (<randomExpression()>) { <for (_ <- [0..randomInt(1, 5)]) {>
  '  <randomStatement(maxDepth)><}>
  
  '<for(_ <- [0..1]) { ><if(randomBool()) {>
  '} else if(<randomExpression()>) { <for (_ <- [0..randomInt(1, 5)]) {>
  '  <randomStatement(maxDepth)><}><}><}>
  
  '} else { <for (_ <- [0..randomInt(1, 5)]) {>
  '  <randomStatement(maxDepth)><}>
  '}
  '";

public str randomExpression() =
  "<randomWord(5)> <randomOperator()> <randomWord(5)>";
