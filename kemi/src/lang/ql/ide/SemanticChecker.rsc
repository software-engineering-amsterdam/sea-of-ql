module lang::ql::ide::SemanticChecker

import List;
import Map;
import Node;
import ParseTree;
import Set;
import analysis::graphs::Graph;
import lang::ql::ast::AST;
import lang::ql::ast::Graph;
import lang::ql::compiler::PrettyPrinter;
import lang::ql::ide::IdentifierUsesDefinitions;
import lang::ql::ide::Outline;
import lang::ql::util::Implode;
import lang::ql::util::Parse;
import util::IDE;

import IO;
import lang::ql::ide::FlowGraph;
import util::ValueUI;

alias identInfo = tuple[loc \loc, str \type];
alias labelMap = map[str ident, list[identInfo] identInfo];



/*
  - Basic type checking for integer, string and boolean expressions. 
    -> dingen als integer + string expressions mogen niet.
  
  - Check cyclic dependencies, 
    -> niet een variabele referencen in een expression voordat die is gedeclareerd.
  
  - Check for undefined variables used in expressions.  
    -> declrataion voor expression usage.

  - Check for duplicate questions with different types, 
    -> Een duplicate question is een copy van de string? En dan is dus  "A" boolean aBool en "A" integer anInt een duplicate
 
  - Provide warnings for duplicate labels. 
  - Check for computed and answerable questions that bind the same variable. 
    -> laat een variable declaration maar een keer toe. [1]
  */
  

public void main() {
  //f = |tmp:///t.q|;
  //f = |project://QL-R-kemi/forms/ifCondition.q|;
  f = |project://QL-R-kemi/forms/ifElseCondition.q|;
  //f = |project://QL-R-kemi/forms/ifElseIfCondition.q|;
  //f = |project://QL-R-kemi/forms/calculatedField.q|;
  //f = |project://QL-R-kemi/forms/duplicateLabels.q|;
  //f = |project://QL-R-kemi/forms/undefinedVariable.q|;
  //f = |project://QL-R-kemi/forms/undefinedVariable.q|;

  x = implode(parse(readFile(f), |file:///-|));
  println("Parsing done: <x>");
  
  us = identifierUses(x);
  def = identifierDefinitions(x);

  sx = useBeforeDeclarationMessages(us, def, x);
  //sx = semanticChecker(x);


  iprintln(sx);
}

// Return after each error-checking step so the IDE will not be flooded with possible recursive errors
public set[Message] semanticChecker(node form) {
  set[Message] ret = {};
  us = identifierUses(form);
  def = identifierDefinitions(form);

  ret = duplicateIdentifierMessages(def);
    if(ret != {})
      return ret;

  ret = duplicateQuestionMessages(form);
    if(ret != {})
      return ret;  

  ret = useBeforeDeclarationMessages(us, def, form);
    if(ret != {})
      return ret;

   return ret;  
}

private set[Message] useBeforeDeclarationMessages(list[GraphNode] idUses, list[GraphNode] defs, Form form) {
  list[GraphNode] found = [];
  fgraph = formGraph(form);

  for(u <- idUses) {
    for(d <- defs) {
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

private set[Message] duplicateIdentifierMessages(list[GraphNode] defs) {
  ids = toMap([ <name, <\type, x@location>> | 
    i <- defs, question(x, _) := i, 
    question(_, \type, name) := x || 
    question(_, \type, name, _) := x]);
  
  ids = (key : ids[key] | key <- ids, size(ids[key]) > 1);
  
  idsRel = { < x, d> | d <- ids, x <- ids[d] };
  
  return
    {duplicateIdentifierMessage(name, \type, \loc) | <<\type, \loc>, name> <- idsRel};
}

private set[Message] duplicateQuestionMessages(Form form) { 
  map[str text, list[loc] \loc] textMap = ();

  // Needed, see issue 32: https://github.com/cwi-swat/rascal/issues/32
  list[loc] qinit = [];
  
  top-down visit(form) {
    case q:question(text, \type, ident): textMap[text]?qinit += [q@location];
    case q:question(text, \type, ident, calculated): textMap[text]?qinit += [q@location];
  }
  
  textMap = (key : textMap[key] | key <- textMap, size(textMap[key]) > 1);
  textMapRel = { < x, d> | d <- textMap, x <- textMap[d] };
  return {duplicateQuestionMessage(text, \loc) | <\loc, text> <- textMapRel};  
}

private Message duplicateQuestionMessage(text, \loc) 
  = error("Duplicate question: \"<text>\"", \loc);
  
private Message useBeforeDeclaration(name, \loc) 
  = error("Undeclared: \"<name>\" is used before a declaration", \loc);
  
private Message duplicateIdentifierMessage(name, \type, \loc) 
  = error("Duplicate identifier: \"<\type> <name>\"", \loc);

private bool sortOccurrences(
  tuple[loc loca, str \type, Expr ident] a, 
  tuple[loc locb, str \type, Expr ident] b) {
    return a.loca.begin.line <= b.locb.begin.line;
}

private bool idNameMatches(GraphNode use, GraphNode definition) {
  if(question(question(_, \type, name), _) := definition) {
    return name == use.expr.name;
  } else if(question(question(_, \type, name, _), _) := definition) {
    return name == use.expr.name;
  }
}
