module lang::ql::util::FormGenerator

import lang::ql::util::Random;

public str randomForm(int numberOfStatements, int maxDepth) {
  return
    "form <randomWord()> { <for (n <- [1..numberOfStatements]) {>
    '  <randomStatement(maxDepth - 1)><}>
    '}
    '";
}

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
  
public str randomConditional(int maxDepth) {
  return 
  "if (<randomExpression()>) { <for (n <- [0..randomInt(1, 5)]) {>
  '  <randomStatement(maxDepth)><}>
  
  '<for(n <- [0..1]) { ><if(randomBool()) {>
  '} else if(<randomExpression()>) { <for (n <- [0..randomInt(1, 5)]) {>
  '  <randomStatement(maxDepth)><}><}><}>
  
  '} else { <for (n <- [0..randomInt(1, 5)]) {>
  '  <randomStatement(maxDepth)><}>
  '}
  '";
}

public str randomExpression() {
  return "<randomWord(5)> <randomOperator()> <randomWord(5)>";
}
