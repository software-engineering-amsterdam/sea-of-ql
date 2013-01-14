module util::Random

import List;
import String;
import util::Math;

public real seed(int val) = 
  arbSeed(val);

public real random() = 
  arbReal();

public real random(num max) = 
  arbReal() * toReal(max);

public real random(num min, num max) = 
  toReal(min) + arbReal() * (toReal(max) - toReal(min));

public int randInt() = 
  arbInt();

public int randInt(int max) = 
  arbInt(max + 1);

public int randInt(int min, int max) = 
  min + arbInt(max - min + 1);

public bool randBool() = 
  arbInt(2) == 0;

public list[int] randListInt() = 
  [randInt() | i <- [0 .. randInt(255)]];

public list[int] randListInt(int n) =
  [randInt() | i <- [1 .. n]];

public list[int] randListInt(int n, int max) =
  [randInt(max) | i <- [1 .. n]];

public list[int] randListInt(int n, int min, int max) =
  [randInt(min, max) | i <- [1 .. n]];

public str randStr() =
  stringChars(randListInt(randInt(255), 32, 126));

public str randStr(int n) =
  stringChars(randListInt(n, 32, 126));

public str randomWord() =
  randomWord(randInt(255));

public str randomWord(int length) {
  first = length/2;
  lower = randListInt(first, 65, 90);
  upper = randListInt(length-first, 97, 122);
  return stringChars(mix(lower, upper));
}

public str randomSentence() = 
  randomSentence(randInt(15), randInt(8));

public str randomSentence(int numberOfWords, int wordLength) = 
  intercalate(" ", [ randomWord(wordLength) | x <- [1..numberOfWords] ]);

public str randomDateString() = randomDateString(randInt(1000, 2999), randInt(1000, 9999));

public str randomDateString(int lowerYear, int upperYear) {
  int year = randInt(lowerYear, upperYear);
  int month = randInt(12);
  int day = randInt(31);
  str ret = "$<year>";
  
  if(month < 10) {
    ret += "-0<month>";
  } else {
    ret += "-<month>";
  }
  
  if(day < 10) {
    ret += "-0<day>";
  } else {
    ret += "-<day>";
  }
  return ret;
}