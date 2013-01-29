module lang::ql::analysis::SemanticChecker

import List;
import Set;
import analysis::graphs::Graph;
import lang::ql::ast::AST;
import lang::ql::ast::Graph;
import lang::ql::compiler::PrettyPrinter;
import lang::ql::analysis::FlowGraph;
import lang::ql::analysis::IdentifierOccurrences;
import lang::ql::analysis::TypeChecker;
import lang::ql::analysis::TypeMap;
import util::IDE;

public set[Message] semanticChecker(node form) {
  set[Message] ret = {};
  
  return ret;  
}

private Message duplicateQuestionMessage(text, \loc) 
  = error("Duplicate question: \"<text>\"", \loc);
  
private Message useBeforeDeclaration(name, \loc) 
  = error("Undeclared: \"<name>\" is used before a declaration", \loc);
  
private Message duplicateIdentifierMessage(name, \type, \loc) 
  = error("Duplicate identifier: \"<\type> <name>\"", \loc);
