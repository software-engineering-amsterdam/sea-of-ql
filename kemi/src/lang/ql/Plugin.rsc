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
import lang::ql::util::Implode;
import lang::ql::util::Parse;

private str LANG_QL = "QL-R";
private str EXT_QL = "q";
private loc FORM_TARGET = |project://QL-R-kemi/bin/|;

private Form implodeQL(Tree t) =
  lang::ql::util::Implode::implode(t);

private start[Form] parseQL(str src, loc l) =
  lang::ql::util::Parse::parse(src, l);

private set[Message] semanticCheckerQL(Tree t) =
  lang::ql::analysis::SemanticChecker::semanticChecker(implodeQL(t));

private void formatQL(start[Form] f, loc l) =
  writeFile(l, lang::ql::compiler::PrettyPrinter::prettyPrint(implodeQL(f)));

private void buildQL(start[Form] f, loc l) {
  if(semanticCheckerQL(f) != {}) {
    alert("The form cannot be built when it still contains errors.");
    return;
  }
  target = buildForm(implodeQL(f), |project://QL-R-kemi/bin/|);
  alert("The form is built in <target>.");
}

public void setupQL() {
  registerLanguage(LANG_QL, EXT_QL, Tree(str src, loc l) {
    return parseQL(src, l);
  });
  
  contribs = {
    outliner(node(Tree input) {
      return outlineForm(implodeQL(input));
    }),
    
    annotator(Tree(Tree input) {
      return input[@messages=semanticCheckerQL(input)];
    }),
    
    popup(
      menu("QL",[
        action("Format (removes comments)", formatQL),
        action("Build", buildQL)
      ])
    )
  };
  
  registerContributions(LANG_QL, contribs);
}
