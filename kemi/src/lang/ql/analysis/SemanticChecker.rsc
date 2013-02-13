@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::ql::analysis::SemanticChecker

import List;
import Set;
import lang::ql::analysis::Expression;
import lang::ql::analysis::LabelMap;
import lang::ql::analysis::Messages;
import lang::ql::analysis::State;
import lang::ql::analysis::TypeMap;
import lang::ql::ast::AST;
import lang::ql::compiler::PrettyPrinter;
import util::IDE;
import util::LocationHelper;

public set[Message] semanticChecker(Form form) {
  SAS sas = <(), ()>;
  <_, messages> = analyzeSemantics(sas, form);
  
  return filenameDoesNotMatchErrors(form) + messages;
}

public SAS semanticAnalysisState(Form form) {
  SAS sas = <(), ()>;
  <sas, _> = analyzeSemantics(sas, form);
  return sas;
}

private default set[Message] filenameDoesNotMatchErrors(Form form) = 
  {};

private set[Message] filenameDoesNotMatchErrors(Form form) =
  {formIdentifierDoesNotMatchFilename(form.formName)}
    when form.formName.ident != basename(form.formName@location);

private SAS merge(SAS cur, SAS add) {
  SAS ret = <(), ()>;

  ret.definitions = cur.definitions + add.definitions;
  ret.labels = cur.labels + add.labels;
  
  return ret;
}
  
private tuple[SAS sas, set[Message] messages] analyzeSemantics(SAS sas, 
    Form form) {
  messages = {};
  
  for(e <- form.formElements) {
    <s, m> = analyzeSemantics(sas, e);
    messages += m;
    sas = merge(sas, s);
  }
  
  return <sas, messages>;
}

private State analyzeSemantics(SAS sas, 
    Statement item: question(Question question)) = 
  analyzeSemantics(sas, question);
    
private State analyzeSemantics(SAS sas, Question q:
    question(QuestionText text, Type \type, IdentDefinition ident)) =
  analyzeSemanticsQuestion(sas, text, \type, ident); 

private State analyzeSemantics(SAS sas, Question q: 
    question(QuestionText text, Type \type, IdentDefinition ident, Expr calc)) =
  analyzeSemanticsQuestion(sas, text, \type, ident, calc);

private State analyzeSemanticsQuestion(SAS sas,
    QuestionText text, Type \type, IdentDefinition ident, Expr expression) {
  messages = analyzeAssignmentExpression(sas, \type, expression);
    
  <sas, m> = analyzeSemanticsQuestion(sas, text, \type, ident);
    
  return <sas, messages + m>;
}

private State analyzeSemanticsQuestion(SAS sas, 
    QuestionText text, Type \type, IdentDefinition ident) {
  set[Message] messages = {};
    
  <tm, m> = typeMapper(ident, \type, sas.definitions);
  messages += m;
  sas.definitions += tm;
    
  <lm, m> = labelMapper(text, ident, sas.labels);
  messages += m;
  sas.labels += lm;

  return <sas, messages>;
}


private State analyzeSemantics(SAS sas, Statement item: 
    ifCondition(Conditional ifPart, list[Conditional] elseIfs, 
    list[ElsePart] elsePart)) {
  set[Message] messages = {};
    
  messages += analyzeExpression(sas, ifPart.condition);
    
  for(e <- ifPart.body) {
    <s, m> = analyzeSemantics(sas, e);
    messages += m;
    sas = merge(sas, s);
  }
    
  for(ei <- elseIfs) {
    messages += analyzeExpression(sas, ei.condition);
    for(e <- ei.body) {
      <s, m> = analyzeSemantics(sas, e);
      messages += m;
      sas = merge(sas, s);
    }
  }
        
  for(ep <- elsePart) {
    for(e <- ep.body) {
      <s, m> = analyzeSemantics(sas, e);
      messages += m;
      sas = merge(sas, s);
    }
  }    

  return <sas, messages>;
}
