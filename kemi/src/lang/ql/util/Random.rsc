module lang::ql::util::Random

extend util::Random;

// TODO: Beatify
public str randomDataType() { 
  t = takeOneFrom(["boolean", "integer", "money", "date", "string"]);
  return t[0];
}

public str randomOperator() { 
  t = takeOneFrom(["+", "-", "*", "/", "&&", "||"]);
  return t[0];
}
