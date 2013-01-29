module lang::ql::analysis::blah

import lang::ql::ast::AST;
import lang::ql::analysis::TypeMap;
import lang::ql::analysis::LabelMap;
import lang::ql::util::Implode;
import lang::ql::util::Parse;
import lang::ql::compiler::web::Web;
import lang::ql::analysis::IdentifierOccurrences;
import lang::ql::analysis::FlowGraph;
import lang::ql::analysis::SemanticChecker;

import IO;
import util::ValueUI;

// DELETE When done
// New:
// TypeMap
// LabelMap

private Form p(loc f) = implode(parse(readFile(f), |file:///-|));

public void main() {
  //f = p(|project://QL-R-kemi/forms/nestedIfElseIfElseCondition.q|);
  //f = p(|project://QL-R-kemi/forms/ifElseIfElseCondition.q|);
  //f = p(|project://QL-R-kemi/forms/calculatedField.q|);
  f = p(|project://QL-R-kemi/forms/ifCondition.q|);
  //f = p(|project://QL-R-kemi/forms/nestedIfElseIfElseCondition.q|);
  <tm, err> = createTypeMap(f);
  
  <tm, err> = createLabelMap(f);
  
  us = identifierUses(f);
  def = identifierDefinitions(f);
  fgraph = flowGraph(f);
  x = useBeforeDeclarationMessages(us, def, fgraph);
  
  iprintln(x);
}
