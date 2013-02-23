@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module util::Random

import List;
import String;
import util::Math;

public real seed(int val) = 
  arbSeed(val);

public real randomReal() = 
  arbReal();

public real randomReal(int max) = 
  arbReal() * toReal(max);

public real randomReal(num min, num max) = 
  toReal(min) + arbReal() * (toReal(max) - toReal(min));

public int randomInt() = 
  arbInt();

public int randomInt(int max) = 
  arbInt(max + 1);

public int randomInt(int min, int max) = 
  min + arbInt(max - min + 1);

public bool randomBool() = 
  arbInt(2) == 0;

public list[int] randomListInt() = 
  [randomInt() | _ <- [0 .. randomInt(255)]];

public list[int] randomListInt(int n) =
  [randomInt() | _ <- [0 .. n]];

public list[int] randomListInt(int n, int max) =
  [randomInt(max) | _ <- [0 .. n]];

public list[int] randomListInt(int n, int min, int max) =
  [randomInt(min, max) | _ <- [0 .. n]];

public str randomStr() =
  stringChars(randomListInt(randomInt(255), 32, 126));

public str randomStr(int n) =
  stringChars(randomListInt(n, 32, 126));

public str randomWord() =
  randomWord(randomInt(1, 255));

public str randomWord(int length) {
  first = length / 2;
  lower = randomListInt(first, 65, 90);
  upper = randomListInt(length - first, 97, 122);
  return stringChars(mix(lower, upper));
}

public str randomSentence() = 
  randomSentence(randomInt(15), randomInt(8));

public str randomSentence(int numberOfWords, int wordLength) = 
  intercalate(" ", [randomWord(wordLength) | x <- [1 .. numberOfWords]]);

public str randomDateString(int lowerYear, int upperYear) {
  int year = randomInt(lowerYear, upperYear);
  int month = randomInt(1, 12);
  int day = randomInt(1, 31);
  return "$<year>-<right("<month>", 2, "0")>-<right("<day>", 2, "0")>";
}
