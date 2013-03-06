@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::ql::ide::Outline

import List;
import Node;
import lang::ql::\ast::AST;
import lang::ql::compiler::PrettyPrinter;
import lang::ql::util::ParseHelper;
import util::IDE;

public node outlineForm(Form form) =
  "outline"(outliner(form.formElements, form@location))
  [@label="Form"]
  [@\loc=form@location];
  
private node createNode(str name, str label, loc location, 
    list[node] children) =
  setAnnotations(makeNode(name, children), ("label": label, "loc": location));

private list[node] outliner(list[Statement] statements, loc rootloc) {
  qs = createNodeList(statements, "Question");
  cqs = createNodeList(statements, "CQuestion");
  
  ifs = createNodeList(statements, "if");
  ifelse = createNodeList(statements, "ifelse");
  ifelseif = createNodeList(statements, "ifelseif");
  ifelseifelse = createNodeList(statements, "ifelseifelse");
  
  list[node] conds = 
    [createNode("if", "if statements (<size(ifs)>)", rootloc, ifs)] +
    [createNode("ifelse", "if-else statements (<size(ifelse)>)", 
      rootloc, ifelse
    )] + 
    [createNode("ifelseif", "if-else-if statements (<size(ifelseif)>)", 
      rootloc, ifelseif
    )] + 
    [createNode("ifelseifelse", 
      "if-else-if-else statements (<size(ifelseifelse)>)", 
      rootloc, ifelseifelse
    )]; 
  
  return 
    [createNode("Questions", "Questions (<size(qs)>)", rootloc, qs)] +
    [createNode("Calculated Questions", "Calculated Questions (<size(cqs)>)", 
      rootloc, cqs
    )] + 
    [createNode("Conditionals", 
      "Conditionals (<size(ifs + ifelse + ifelseif + ifelseifelse)>)", 
      rootloc, conds
    )];
}

private list[node] createNodeList(list[Statement] statements, str listType) = 
  [
    createNode(listType, "<text.text> : <\type.name>", q@location, []) |
    /Question q: question(text, \type, _) <- statements
  ] 
    when listType == "Question"; 

private list[node] createNodeList(list[Statement] statements, str listType) = 
  [
    createNode(listType, "<text.text> : <\type.name> (<prettyPrint(cf)>)", 
      q@location, []
    ) | 
    /Question q: question(text, \type, _, cf) <- statements
  ]
    when listType == "CQuestion"; 
    
private list[node] createNodeList(list[Statement] statements, str listType) =  
  [
    createNode(listType, "if (<prettyPrint(ifPart.condition)>)", i@location, []) | 
    /Statement i: ifCondition(Conditional ifPart, list[Conditional] elseIfs, 
      list[ElsePart] elsePart
    ) <- statements, 
    elseIfs == [], 
    elsePart == []
  ]
    when listType == "if";

private list[node] createNodeList(list[Statement] statements, str listType) =  
  [
    createNode(listType, "if else (<prettyPrint(ifPart.condition)>)", i@location, []) | 
    /Statement i: ifCondition(
      Conditional ifPart, list[Conditional] elseIfs, list[ElsePart] elsePart
    ) <- statements, 
    elseIfs == [],
    elsePart != []
  ]
    when listType == "ifelse";

private list[node] createNodeList(list[Statement] statements, str listType) =  
  [
    createNode(listType, "if <prettyPrint(ifPart.condition)> elseif", i@location, []) | 
    /Statement i: ifCondition(Conditional ifPart, 
      list[Conditional] elseIfs, list[ElsePart] elsePart
    ) <- statements,
    elseIfs != [], 
    elsePart == []
  ]
    when listType == "ifelseif";

private list[node] createNodeList(list[Statement] statements, str listType) =  
  [
    createNode(listType,
      "if <prettyPrint(ifPart.condition)> elseifelse", i@location, []
    ) | 
    /Statement i: ifCondition(Conditional ifPart, list[Conditional] elseIfs, 
      list[ElsePart] elsePart
    ) <- statements,
    elseIfs != [], 
    elsePart != []
  ]
    when listType == "ifelseifelse";

private default list[node] createNodeList(list[Statement] stmts, str listType) =
  [];
