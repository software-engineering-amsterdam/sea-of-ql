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

