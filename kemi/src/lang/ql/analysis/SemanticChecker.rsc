module lang::ql::analysis::SemanticChecker

import List;
import Set;
import lang::ql::analysis::LabelMap;
import lang::ql::analysis::TypeMap;
import lang::ql::ast::AST;
import lang::ql::compiler::PrettyPrinter;
import util::IDE;

public set[Message] semanticChecker(node form) {
  SAS sas = <(), (), ()>;
  return analyzeSemantics(sas, form);
}

// SemanticAnalysisState
private alias SAS = tuple[
  TypeMap definitions, 
  map[Expr ident, Type \type] uses,
  LabelMap labels];
  
private alias State = tuple[
  SAS sas,
  set[Message] messages];

private Message duplicateQuestionMessage(text, \loc) 
  = error("Duplicate question: \"<text>\"", \loc);
  
private Message useBeforeDeclaration(name, \loc) 
  = error("Undeclared: \"<name>\" is used before a declaration", \loc);
  
private Message duplicateIdentifierMessage(name, \type, \loc) 
  = error("Duplicate identifier: \"<\type> <name>\"", \loc);

private SAS merge(SAS cur, SAS add) {
  SAS ret = <(), (), ()>;
  ret.definitions = cur.definitions + add.definitions;
  ret.uses = cur.uses + add.uses;
  ret.labels = cur.labels + add.labels;
  return ret;
}
  
private set[Message] analyzeSemantics(SAS sas, Form form) {
  messages = {};
  for(e <- form.formElements) {
    <s, m> = analyzeSemantics(sas, e);
    messages += m;
    sas = merge(sas, s);
  }
  return messages;
}

private State analyzeSemantics(SAS sas, 
  Statement item: question(Question question)) = 
    analyzeSemantics(sas, question);
    
private State analyzeSemantics(SAS sas, Question q: 
  question(text, \type, ident)) {
    set[Message] messages = {};
    
    <tm, m> = typeMapper(ident, \type, sas.definitions);
    messages += m;
    sas.definitions += tm;
    
    <lm, m> = labelMapper(text, ident, sas.labels);
    messages += m;
    sas.labels += lm;
            
    return <sas, messages>;
}

private State analyzeSemantics(SAS sas, Question q: 
  question(text, \type, ident, calc)) {
    <tm, message> = typeMapper(ident, \type, sas.definitions);
    
    sas.definitions += tm;    
    return <sas, message>;  
}

private State analyzeSemantics(SAS sas, Statement item: 
  ifCondition(Conditional ifPart, list[Conditional] elseIfs, list[ElsePart] elsePart)) {
    set[Message] messages = {};
    
    // If branch
    for(e <- ifPart.body) {
      <s, m> = analyzeSemantics(sas, e);
      messages += m;
      sas = merge(sas, s);
    }
    
    // ElseIf branche(s)
    for(ei <- elseIfs) {
      for(e <- ei.body) {
        <s, m> = analyzeSemantics(sas, e);
        messages += m;
        sas = merge(sas, s);
      }
    }
        
    // Else branch
    for(ep <- elsePart) {
      for(e <- ep.body) {
        <s, m> = analyzeSemantics(sas, e);
        messages += m;
        sas = merge(sas, s);
      }
    }    

    return <sas, messages>;
}
