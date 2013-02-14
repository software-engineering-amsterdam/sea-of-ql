@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::qls::ast::Keyword

import Grammar;
import lang::qls::syntax::QLS;
import lang::rascal::grammar::definition::Keywords;

public set[str] keywords = {
  x | /prod(_, literal, _) <- getKeywords(grammar({}, #Stylesheet.definitions)), 
  i <- literal, 
  lit(x) := i
};
