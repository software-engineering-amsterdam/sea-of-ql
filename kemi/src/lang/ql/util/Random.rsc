@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::ql::util::Random

extend util::Random;

public str randomDataType() = 
  getOneFrom(["boolean", "integer", "money", "date", "string"]);

public str randomOperator() = 
  getOneFrom(["+", "-", "*", "/", "&&", "||"]);

// The domain [1000, 2999] according to the grammar in QL.rsc
public str randomDateString() = 
  randomDateString(1000, 2999);
