module lang::ql::util::Random

extend util::Random;

public str randomDataType() = 
  getOneFrom(["boolean", "integer", "money", "date", "string"]);

public str randomOperator() = 
  getOneFrom(["+", "-", "*", "/", "&&", "||"]);

public str randomQuestion() = 
  "\"<randomSentence()>\" <randomDataType()> <randomWord(10)>";

public str randomCalculatedQuestion() = 
  randomQuestion() + " = <randomWord(10)> <randomOperator()> <randomWord(10)>";
  
public str randomStatement(int maxDepth) {
  int choice;
  
  if(maxDepth > 0)
    choice = randInt(0, 2);
  else
    choice = randInt(0, 1);
    
  switch(choice) {
    case 0: return randomQuestion();
    case 1: return randomCalculatedQuestion();
    case 2: return randomConditional(maxDepth - 1);
  }
}

public str randomConditional(int maxDepth) {
  return 
  "if (<randomExpression()>) { <for (n <- [0..randInt(1, 5)]) {>
  '  <randomStatement(maxDepth)><}>
  
  '<for(n <- [0..1]) { ><if(randBool()) {>
  '} else if(<randomExpression()>) { <for (n <- [0..randInt(1, 5)]) {>
  '  <randomStatement(maxDepth)><}><}><}>
  
  '} else { <for (n <- [0..randInt(1, 5)]) {>
  '  <randomStatement(maxDepth)><}>
  '}
  '";
}

public str randomExpression() {
  return "<randomWord(5)> <randomOperator()> <randomWord(5)>";
}

public str randomForm(int numberOfStatements, int maxDepth) {
  return
    "form <randomWord()> { <for (n <- [1..numberOfStatements]) {>
    '  <randomStatement(maxDepth - 1)><}>
    '}
    '";
}
