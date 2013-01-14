module lang::ql::util::Random

extend util::Random;

public str randomDataType() = 
  getOneFrom(["boolean", "integer", "money", "date", "string"]);

public str randomOperator() = 
  getOneFrom(["+", "-", "*", "/", "&&", "||"]);

/*
 * The domain [1000, 2999] according to the grammar in QL.rsc 
 */ 
public str randomDateString() = 
  randomDateString(1000, 2999);
