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
import lang::ql::analysis::State;
import lang::ql::\ast::AST;
import lang::qls::analysis::Messages;
import lang::qls::analysis::StyleAttrChecker;
import lang::qls::analysis::WidgetTypeChecker;
import lang::qls::\ast::AST;
import lang::qls::util::StyleHelper;
import Map;
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

private set[Message] filenameDoesNotMatchErrors(Stylesheet s) =
  {stylesheetDoesNotMatchFilename(s.ident.name, s@location)}
    when s.ident.name != basename(s@location);

private default set[Message] filenameDoesNotMatchErrors(Stylesheet s) = 
  {};
  
private set[Message] accompanyingFormNotFoundErrors(Stylesheet s) =
  {accompanyingFormNotFound(s.ident.name, s@location)}
    when !isFile(getAccompanyingFormLocation(s));

private default set[Message] accompanyingFormNotFoundErrors(Stylesheet s) =
  {};

private set[Message] alreadyUsedQuestionErrors(Stylesheet s) {
  set[Message] errors = {};
  list[Definition] questionDefinitions = getQuestionDefinitions(s);
  map[Ident, loc] idents = ();
  
  for(d <- questionDefinitions) {
    if(d.ident in idents) {
      errors += questionAlreadyDefined(idents[d.ident], d@location);
    } 
    idents[d.ident] = d@location;
  }
  
  return errors;
}

private set[Message] undefinedQuestionErrors(Stylesheet s) =
  {} when !isFile(getAccompanyingFormLocation(s));
  

private default set[Message] undefinedQuestionErrors(Stylesheet s) {
  set[Message] errors = {};
  TypeMap typeMap = getTypeMap(getAccompanyingForm(s));
  list[Definition] qdefs = getQuestionDefinitions(s);
  
  return {questionUndefinedInForm(q@location) | q <- qdefs, 
    identDefinition(q.ident.name) notin typeMap};
}

private set[Message] unusedQuestionWarnings(Stylesheet s) {
  TypeMap typeMap = domainX(
    getTypeMap(getAccompanyingForm(s)),
    {identDefinition(d.ident.name) | d <- getQuestionDefinitions(s)}
  );
  
  return {questionUnused(ident.ident, endOfStylesheet(s)) | ident <- typeMap};
}

private loc endOfStylesheet(Stylesheet s) {
  loc endLoc = s@location;
  endLoc.offset = s@location.length - 1;
  endLoc.length = 1;
  endLoc.begin.line = s@location.end.line;
  endLoc.begin.column = s@location.end.column - 1;
  return endLoc;
}

private set[Message] doubleNameWarnings(Stylesheet s) =
  doublePageNameWarnings(s) +
  doubleSectionNameWarnings(s);

private set[Message] doublePageNameWarnings(Stylesheet s) {
  set[Message] warnings = {};
  list[Definition] pageDefinitions = getPageDefinitions(s);
  map[str, loc] pages = ();
  
  for(pd <- pageDefinitions) {
    if(pd.name in pages) {
      warnings += pageAlreadyDefined(pages[pd.name], pd@location);
    } 
    pages[pd.name] = pd@location;
  }
  
  return warnings;
}

private set[Message] doubleSectionNameWarnings(Stylesheet s) {
  set[Message] warnings = {};
  list[Definition] sectionDefinitions = getSectionDefinitions(s);
  map[str, loc] sections = ();
  
  for(sd <- sectionDefinitions) {
    if(sd.name in sections) {
      warnings += sectionAlreadyDefined(sections[sd.name], sd@location);
    } 
    sections[sd.name] = sd@location;
  }
  
  return warnings;
}

private set[Message] defaultRedefinitionWarnings(Stylesheet s) =
  {
    defaultAlreadyDefined(redef@location) |
    redef <- getDefaultRedefinitions(s.definitions)
  } + 
  {
    defaultAlreadyDefined(redef@location) | 
    pd <- getPageDefinitions(s) + getSectionDefinitions(s),
    redef <- getDefaultRedefinitions(toDefinitionList(pd.layoutRules))
  };

private list[Definition] getDefaultRedefinitions(list[Definition] definitions) {
  set[Type] idents = {};
  list[Definition] redefinitions = [];
  
  for(Definition dd: defaultDefinition(\type, _) <- definitions) {
    if(\type in idents) {
      redefinitions += dd;
    } else {
      idents += \type;
    }
  }
  
  return redefinitions;
}
