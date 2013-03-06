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
import lang::ql::analysis::State;
import lang::ql::\ast::AST;
import lang::qls::analysis::Messages;
import lang::qls::\ast::AST;
import lang::qls::util::StyleHelper;
import util::IDE;

private list[str] defaultAttrs =
  ["widget", "label-fontsize", "label-font", "label-color"];

private map[Type, list[str]] allowedAttrs = (
  booleanType("boolean"):
    defaultAttrs + ["fontsize", "font", "color"],
  integerType("integer"):
    defaultAttrs + ["width", "fontsize", "font", "color"],
  moneyType("money"):
    defaultAttrs + ["width", "fontsize", "font", "color"],
  dateType("date"):
    defaultAttrs + [],
  stringType("string"):
    defaultAttrs + ["width", "fontsize", "font", "color"]
);

private bool isAllowedAttr(Type \type, StyleAttr attr) =
  attr.name in allowedAttrs[\type];

public set[Message] unallowedAttrErrors(Stylesheet s) =
  unallowedDefaultAttrErrors(s) +
  unallowedQuestionAttrErrors(s);

private set[Message] unallowedDefaultAttrErrors(Stylesheet s) =
  {
    typeWithInvalidAttr(sr.attr.name, dd.\type.name, sr@location) | 
    dd <- getDefaultDefinitions(s), 
    sr <- dd.styleRules, 
    !isAllowedAttr(dd.\type, sr.attr)
  };

private set[Message] unallowedQuestionAttrErrors(Stylesheet s) {
  TypeMap typeMap = getTypeMap(getAccompanyingForm(s));
  return 
    {
      typeWithInvalidAttr(sr.attr.name, \type.name, sr@location) | 
      qd <- getQuestionDefinitions(s), 
      qd.styleRules?,
      identDefinition(qd.ident.name) in typeMap,
      \type := typeMap[identDefinition(qd.ident.name)],
      sr <- qd.styleRules,
      !isAllowedAttr(\type, sr.attr)
    };
}
