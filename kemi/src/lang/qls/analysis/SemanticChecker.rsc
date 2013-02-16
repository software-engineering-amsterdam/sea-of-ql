@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::qls::analysis::SemanticChecker

import IO;
import Map;
import lang::ql::analysis::State;
import lang::ql::ast::AST;
import lang::qls::analysis::Messages;
import lang::qls::analysis::StyleAttrChecker;
import lang::qls::analysis::WidgetTypeChecker;
import lang::qls::ast::AST;
import lang::qls::util::StyleHelper;
import util::IDE;
import util::LocationHelper;

// Retrieve all errors and warnings regarding a Stylesheet s
public set[Message] semanticChecker(Stylesheet s) =
  filenameDoesNotMatchErrors(s) +
  accompanyingFormNotFoundErrors(s) +
  unallowedAttrErrors(s) +
  unallowedWidgetErrors(s) +
  alreadyUsedQuestionErrors(s) +
  undefinedQuestionErrors(s) +
  unusedQuestionWarnings(s) +
  doubleNameWarnings(s) +
  defaultRedefinitionWarnings(s);

private default set[Message] filenameDoesNotMatchErrors(Stylesheet s) = 
  {};

private set[Message] filenameDoesNotMatchErrors(Stylesheet s) =
  {stylesheetDoesNotMatchFilename(s.ident, s@location)}
    when s.ident != basename(s@location);

private default set[Message] accompanyingFormNotFoundErrors(Stylesheet s) =
  {};

private set[Message] accompanyingFormNotFoundErrors(Stylesheet s) =
  {accompanyingFormNotFound(s.ident, s@location)}
    when !isFile(getAccompanyingFormLocation(s));

private set[Message] alreadyUsedQuestionErrors(Stylesheet s) {
  set[Message] errors = {};
  list[Definition] questionDefinitions = getQuestionDefinitions(s);
  map[str, loc] idents = ();
  
  for(d <- questionDefinitions) {
    if(d.ident in idents) {
      errors += questionAlreadyDefined(idents[d.ident], d@location);
    } 
    idents[d.ident] = d@location;
  }
  
  return errors;
}

private set[Message] undefinedQuestionErrors(Stylesheet s) {
  if(!isFile(getAccompanyingFormLocation(s)))
    return {};
  
  set[Message] errors = {};
  TypeMap typeMap = getTypeMap(getAccompanyingForm(s));
  list[Definition] qdefs = getQuestionDefinitions(s);
  
  return {questionUndefinedInForm(q@location) | q <- qdefs, 
    identDefinition(q.ident) notin typeMap};
}

private set[Message] unusedQuestionWarnings(Stylesheet s) {
  TypeMap typeMap = domainX(
    getTypeMap(getAccompanyingForm(s)),
    {identDefinition(d.ident) | d <- getQuestionDefinitions(s)}
  );
  
  // Show warning at the end of the Stylesheet
  loc warningLoc = s@location;
  warningLoc.offset = s@location.length - 1;
  warningLoc.length = 1;
  warningLoc.begin.line = s@location.end.line;
  warningLoc.begin.column = s@location.end.column - 1;
  
  return {questionUnused(ident.ident, warningLoc) | ident <- typeMap};
}

private set[Message] doubleNameWarnings(Stylesheet s) =
  doublePageNameWarnings(s) +
  doubleSectionNameWarnings(s);

private set[Message] doublePageNameWarnings(Stylesheet s) {
  set[Message] warnings = {};
  list[Definition] pageDefinitions = getPageDefinitions(s);
  map[str, loc] pages = ();
  
  for(d <- pageDefinitions) {
    if(d.ident in pages) {
      warnings += pageAlreadyDefined(pages[d.ident], d@location);
    } 
    pages[d.ident] = d@location;
  }
  
  return warnings;
}

private set[Message] doubleSectionNameWarnings(Stylesheet s) {
  set[Message] warnings = {};
  list[Definition] sectionDefinitions = getSectionDefinitions(s);
  map[str, loc] sections = ();
  
  for(d <- sectionDefinitions) {
    if(d.ident in sections) {
      warnings += sectionAlreadyDefined(sections[d.ident], d@location);
    } 
    sections[d.ident] = d@location;
  }
  
  return warnings;
}

private set[Message] defaultRedefinitionWarnings(Stylesheet s) =
  {
    defaultAlreadyDefined(r@location) |
    r <- getDefaultRedefinitions(s.definitions)
  } + 
  {
    defaultAlreadyDefined(r@location) | 
    d <- getPageDefinitions(s) + getSectionDefinitions(s),
    r <- getDefaultRedefinitions(toDefinitionList(d.layoutRules))
  };

private list[Definition] getDefaultRedefinitions(list[Definition] definitions) {
  set[Type] idents = {};
  list[Definition] redefinitions = [];
  
  for(Definition d: defaultDefinition(\type, _) <- definitions) {
    if(\type in idents) {
      redefinitions += d;
    } else {
      idents += \type;
    }
  }
  
  return redefinitions;
}
