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
import List;
import Set;
import String;
import Map;
import lang::ql::ast::AST;
import lang::qls::analysis::Messages;
import lang::qls::analysis::StyleAttrChecker;
import lang::qls::analysis::WidgetTypeChecker;
import lang::qls::ast::AST;
import lang::qls::compiler::PrettyPrinter;
import lang::qls::util::ParseHelper;
import lang::qls::util::StyleHelper;
import util::IDE;
import util::LocationHelper;

public set[Message] semanticChecker(Stylesheet s) =
  filenameDoesNotMatchErrors(s) +
  getAccompanyingFormNotFoundErrors(s) +
  unallowedAttrErrors(s) +
  unallowedWidgetErrors(s) +
  alreadyUsedQuestionErrors(s) +
  undefinedQuestionErrors(s) +
  unusedQuestionWarnings(s) +
  doubleNameWarnings(s) +
  defaultRedefinitionWarnings(s);


public default set[Message] filenameDoesNotMatchErrors(Stylesheet s) = 
  {};

public set[Message] filenameDoesNotMatchErrors(Stylesheet s) =
  {stylesheetDoesNotMatchFilename(s.ident, s@location)}
    when s.ident != basename(s@location);

private default set[Message] getAccompanyingFormNotFoundErrors(Stylesheet s) =
  {};

private set[Message] getAccompanyingFormNotFoundErrors(Stylesheet s) =
  {getAccompanyingFormNotFound(s.ident, s@location)}
    when !isFile(getAccompanyingFormLocation(s));


public set[Message] alreadyUsedQuestionErrors(Stylesheet s) {
  set[Message] errors = {};
  list[QuestionDefinition] questionDefinitions = getQuestionDefinitions(s);
  map[str, loc] idents = ();
  
  for(d <- questionDefinitions) {
    if(d.ident in idents) {
      errors += questionAlreadyDefined(idents[d.ident], d@location);
    } 
    idents[d.ident] = d@location;
  }
  
  return errors;
}

public set[Message] undefinedQuestionErrors(Stylesheet s) {
  if(!isFile(getAccompanyingFormLocation(s)))
    return {};
  
  set[Message] errors = {};
  typeMap = getTypeMap(getAccompanyingForm(s));
  qdefs = getQuestionDefinitions(s);
  
  return {questionUndefinedInForm(q@location) | q <- qdefs, 
    identDefinition(q.ident) notin typeMap};
}

public set[Message] unusedQuestionWarnings(Stylesheet s) {
  list[QuestionDefinition] questionDefinitions = getQuestionDefinitions(s);
  typeMap = getTypeMap(getAccompanyingForm(s));
  
  for(d <- questionDefinitions) {
    typeMap = domainX(typeMap, {identDefinition(d.ident)});
  }
  
  loc warningLoc = s@location;
  warningLoc.offset = s@location.length - 1;
  warningLoc.length = 1;
  warningLoc.begin.line = s@location.end.line;
  warningLoc.begin.column = s@location.end.column - 1;
  
  return {questionUnused(ident.ident, warningLoc) | ident <- typeMap};
}

public set[Message] doubleNameWarnings(Stylesheet s) {
  return doublePageNameWarnings(s) +
    doubleSectionNameWarnings(s);
}

public set[Message] doublePageNameWarnings(Stylesheet s) {
  set[Message] warnings = {};
  list[PageDefinition] pageDefinitions = getPageDefinitions(s);
  map[str, loc] pages = ();
  
  for(d <- pageDefinitions) {
    if(d.ident in pages) {
      warnings += pageAlreadyDefined(pages[d.ident], d@location);
    } 
    pages[d.ident] = d@location;
  }
  
  return warnings;
}

public set[Message] doubleSectionNameWarnings(Stylesheet s) {
  set[Message] warnings = {};
  list[SectionDefinition] sectionDefinitions = getSectionDefinitions(s);
  map[str, loc] sections = ();
  
  for(d <- sectionDefinitions) {
    if(d.ident in sections) {
      warnings += sectionAlreadyDefined(sections[d.ident], d@location);
    } 
    sections[d.ident] = d@location;
  }
  
  return warnings;
}

public set[Message] defaultRedefinitionWarnings(Stylesheet s) {
  list[list[PageRule]] pdrules = [pd.pageRules | 
    pd <- getPageDefinitions(s)];
  list[list[SectionRule]] sdrules = [sd.sectionRules | 
    sd <- getSectionDefinitions(s)];
  
  return 
    {defaultAlreadyDefined(r@location) | 
      r <- getDefaultRedefinitions(s.definitions)} + 
    {defaultAlreadyDefined(r@location) | 
      rules <- pdrules, r <- getDefaultRedefinitions(rules)} + 
    {defaultAlreadyDefined(r@location) | 
      rules <- sdrules, r <- getDefaultRedefinitions(rules)};
}

private list[DefaultDefinition] getDefaultRedefinitions(list[&T] definitions) {
  set[Type] idents = {};
  list[DefaultDefinition] redefinitions = [];
  
  for(definition(DefaultDefinition d) <- definitions) {
    if(d.ident in idents) {
      redefinitions += d;
    } else {
      idents += d.ident;
    }
  }
  return redefinitions;
}
