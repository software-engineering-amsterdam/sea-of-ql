@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::ql::Plugin

import IO;
import ParseTree;
import util::IDE;
import util::Prompt;

import lang::ql::analysis::SemanticChecker;
import lang::ql::ast::AST;
import lang::ql::compiler::PrettyPrinter;
import lang::ql::compiler::web::Web;
import lang::ql::ide::Outline;
import lang::ql::syntax::QL;
import lang::ql::util::ParseHelper;

private str LANG_QL = "QL-R";
private str EXT_QL = "q";
private str ACTION_FORMAT = "Format (removes comments)";
private str ACTION_BUILD = "Build form";
private loc FORM_TARGET = |project://QL-R-kemi/output/|;

private void format(start[Form] f, loc l) =
  writeFile(l, prettyPrint(implode(f)));
  
private void build(start[Form] form, loc source) {
  messages = buildAndReturnMessages(form, FORM_TARGET);
  
  if(messages != {}) {
    alert("The form cannot be built when it still contains errors.");
  } else {
    alert("The form is built in <FORM_TARGET>.");
  }
  return;
}
  
public set[Message] buildAndReturnMessages(start[Form] form, loc target) =
  buildAndReturnMessages(implode(form), target);
  
public set[Message] buildAndReturnMessages(Form form, loc target) {
  messages = semanticChecker(form);
  if(messages != {}) {
    return messages;
  }
  buildForm(form, target);
  
  return {};
}

public void setupQL() {
  registerLanguage(LANG_QL, EXT_QL, Tree(str src, loc l) {
    return parse(src, l);
  });
  
  contribs = {
    outliner(node(Tree input) {
      return outlineForm(implode(input));
    }),
    
    annotator(Tree(Tree input) {
      return input[@messages=semanticChecker(implode(input))];
    }),
    
    popup(
      menu(LANG_QL,[
        action(ACTION_BUILD, build),
        action(ACTION_FORMAT, format)
      ])
    ), 
    
    builder(set[Message] (Tree input) {
      messages = buildAndReturnMessages(implode(input), FORM_TARGET);
      return messages;
    })
  };
  
  registerContributions(LANG_QL, contribs);
}
