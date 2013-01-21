module lang::ql::analysis::TypeChecker

import List;
import ParseTree;
import Set;
import lang::ql::ast::AST;
import util::IDE;

private alias EST = 
  tuple[str name, str \type];

// Note: Because we check for duplicate questions AND duplicate identifiers, 
// we can assume that each name has a single type.
// We also already know that each variable binds to a single type, so 
// we can freely use the toMap stuff below. 

public set[Message] typeChecker(Form f, definitions) {
  set[Message] ret = {};

  // To decide on valid types, first make a make a map to do a lookup on:
  map[str, str] typeMap = toMapUnique({ <name, \type> | 
    i <- definitions, question(x, _) := i, 
    question(_, \type, name) := x || 
    question(_, \type, name, _) := x});
    
  // Check all calculatedQuestions:
  cq = [<name, expr> | 
    i <- definitions, 
    question(x, _) := i, 
    question(_, _, name, expr) := x];

  for (e <- cq) {
    if(<name, expr> := e) {
      typeSet = generateExpressionTypeSet(typeMap, expr);
      reducedTypeSet = { \type | t <- typeSet, <_, \type> := t};
      if(size(reducedTypeSet) > 1) {
        ret += typeError(typeSet, e@location);
      } 
    }
  }

  // And all conditionals
  visit(f) {
    case c:conditional(Expr condition, _): {
      typeSet = generateExpressionTypeSet(typeMap, condition);
      reducedTypeSet = { \type | t <- typeSet, <_, \type> := t};
      if(size(reducedTypeSet) > 1) {
        ret += typeError(typeSet, c@location);
      }
    }
  }
  
  return ret;
}

private set[EST] generateExpressionTypeSet(map[str, str] typeMap, Expr e) {
  typeset = {};
  visit(e) {
    case x:ident(name): {
      if(name in typeMap) {
        typeset += {<name, typeMap[name]>};
      } else {
        typeset += {<name, "undefined">};
      }
    }
    case x:\int(val): typeset += {<"<val>", "integer">};
    case x:money(val): typeset += {<"<val>", "money">};
    case x:boolean(val): typeset += {<"<val>", "boolean">};
    case x:date(val): typeset += {<"<val>", "date">};
    case x:string(text): typeset += {<"<text>", "string">};
  }
  return typeset;
}

private Message typeError(set[EST] info, \loc) {
  info = intercalate(", ", [ "<v>:<t>" | <v, t> <- info ]);
  return error("Varying types given in expression: <info>", \loc);
}
