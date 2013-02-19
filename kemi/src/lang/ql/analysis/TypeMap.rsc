@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::ql::analysis::TypeMap

import lang::ql::analysis::Messages;
import lang::ql::analysis::State;
import lang::ql::\ast::AST;
import util::IDE;

public TypeMapMessages typeMapper(IdentDefinition ident, Type \type, 
    TypeMap tm) = 
  <tm + (ident : \type), {}>
    when ident notin tm;

public TypeMapMessages typeMapper(IdentDefinition ident, Type \type, 
    TypeMap tm) = 
  <tm, {redeclaredMessage(\type@location)}>
    when tm[ident] != \type;

public default TypeMapMessages typeMapper(IdentDefinition ident, Type \type, 
    TypeMap tm) = 
  <tm, {alreadyDeclaredMessage(ident.ident, ident@location)}>;
