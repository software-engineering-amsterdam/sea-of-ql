@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::ql::analysis::State

import lang::ql::ast::AST;
import util::IDE;

public alias TypeMap = 
  map[IdentDefinition ident, Type \type];

public alias TypeMapMessages = 
  tuple[TypeMap \map, set[Message] messages];

public alias LabelMap = 
  map[QuestionText text, IdentDefinition ident];

public alias LabelMapMessages = 
  tuple[LabelMap \map, set[Message] messages];

// SemanticAnalysisState
public alias SAS = 
  tuple[TypeMap definitions, 
  LabelMap labels];

public alias State = 
  tuple[SAS sas,
  set[Message] messages];
