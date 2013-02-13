@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::qls::analysis::StyleAttrChecker

import IO;
import util::IDE;

import lang::ql::ast::AST;
import lang::qls::analysis::SemanticChecker;
import lang::qls::ast::AST;
import lang::qls::util::StyleHelper;

private map[Type, list[str]] allowedAttrs = (
  booleanType("boolean"):
    ["widget"],
  integerType("integer"):
    ["widget", "width"],
  moneyType("money"):
    ["widget", "width"],
  dateType("date"):
    ["widget"],
  stringType("string"):
    ["widget", "width"]
);

private bool isAllowedAttr(Type \type, StyleAttr attr) =
  attr.name in allowedAttrs[\type];

public set[Message] unallowedAttrErrors(Stylesheet s) =
  unallowedDefaultAttrErrors(s) +
  unallowedQuestionAttrErrors(s);

private set[Message] unallowedDefaultAttrErrors(Stylesheet s) {
  errors = {};
  for(d <- getDefaultDefinitions(s)) {
    for(r <- d.styleRules) {
      if(!isAllowedAttr(d.ident, r.attr))
        errors += error(
          "Attr <r.attr> not allowed for type <d.ident.name>",
          r@location
        );
    }
  }
  return errors;
}

private set[Message] unallowedQuestionAttrErrors(Stylesheet s) {
  errors = {};
  typeMap = getTypeMap(getAccompanyingForm(s));
  for(d <- getQuestionDefinitions(s)) {
    if(!d.styleRules? || identDefinition(d.ident) notin typeMap)
      continue;

    \type = typeMap[identDefinition(d.ident)];
    for(r <- d.styleRules) {
      if(!isAllowedAttr(\type, r.attr))
        errors += error(
          "Attr <r.attr> not allowed for type <\type.name>",
          r@location
        );
    }
  }
  return errors;
}
