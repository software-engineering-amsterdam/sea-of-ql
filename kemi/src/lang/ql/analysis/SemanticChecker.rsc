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

alias identInfo = 
  tuple[loc \loc, str \type];

alias labelMap = 
  map[str ident, list[identInfo] identInfo];

public set[Message] semanticChecker(node form) {
  set[Message] ret = {};
  
  us = identifierUses(form);
  def = identifierDefinitions(form);
  fgraph = flowGraph(form);
  
  <typeMap, err> = createTypeMap(form);

  ret = duplicateIdentifierMessages(def);
  if(ret != {})
    return ret;
    
  ret = duplicateQuestionMessages(def);
  if(ret != {})
    return ret;
  
  ret = useBeforeDeclarationMessages(us, def, fgraph);
  if(ret != {})
    return ret;

  ret = typeChecker(form, def);
  
  return ret;  
}

public set[Message] useBeforeDeclarationMessages(
  list[GraphNode] idUses, list[GraphNode] definitions, rel[GraphNode, GraphNode] fgraph) {
  
  list[GraphNode] found = [];

  for(u <- idUses) {
    for(d <- definitions) {
      if(idNameMatches(u, d)) {
        parents = [ a | <a, b> <- fgraph, b == d];
        
        reachable = reach(fgraph, toSet(parents));
        
        ids = { x | /x:ident(str name) <- reachable };
        
        if(u.expr in ids) {
          found += [u];
        }
      }
    }
  }
  
  return 
    {useBeforeDeclaration(prettyPrint(u.expr), u.location) | u <- (idUses - found)};
}

public set[Message] duplicateIdentifierMessages(list[GraphNode] definitions) {
  ids = toMap([ <name, <\type, x@location>> | 
    i <- definitions, 
    question(x, _) := i, 
    question(_, \type, name) := x || 
    question(_, \type, name, _) := x]);
    
  ids = (key : ids[key] | key <- ids, size(ids[key]) > 1);
  
  idsRel = {< x, d> | d <- ids, x <- ids[d]};
  
  return
    {duplicateIdentifierMessage(name, \type, \loc) | <<\type, \loc>, name> <- idsRel};
}

public set[Message] duplicateQuestionMessages(list[GraphNode] definitions) {
  textMap = toMap([ <text, x@location> | 
    i <- definitions, 
    question(x, _) := i, 
    question(text, _, _) := x || 
    question(text, _, _, _) := x]);
    
  textMap = (key : textMap[key] | key <- textMap, size(textMap[key]) > 1);
  textMapRel = {< x, d> | d <- textMap, x <- textMap[d]};
  
  return 
    {duplicateQuestionMessage(text, \loc) | <\loc, text> <- textMapRel};
}

private Message duplicateQuestionMessage(text, \loc) 
  = error("Duplicate question: \"<text>\"", \loc);
  
private Message useBeforeDeclaration(name, \loc) 
  = error("Undeclared: \"<name>\" is used before a declaration", \loc);
  
private Message duplicateIdentifierMessage(name, \type, \loc) 
  = error("Duplicate identifier: \"<\type> <name>\"", \loc);

private bool sortOccurrences(
  tuple[loc loca, str \type, Expr ident] a, 
  tuple[loc locb, str \type, Expr ident] b) =
    a.loca.begin.line <= b.locb.begin.line;

private bool idNameMatches(GraphNode use, GraphNode definition) {
  if(question(question(_, _, name), _) := definition) {
    return name == use.expr.name;
  } else if(question(question(_, _, name, _), _) := definition) {
    return name == use.expr.name;
  }
}

private bool getQuestionTextFromGraphNode(GraphNode definition) {
  if(question(question(text, _, _), _) := definition) {
    return text;
  } else if(question(question(text, _, _, _), _) := definition) {
    return text;
  }
}