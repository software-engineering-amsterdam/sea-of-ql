module Plugin

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

import lang::qls::analysis::SemanticChecker;
import lang::qls::ast::AST;
import lang::qls::compiler::PrettyPrinter;
import lang::qls::ide::Outline;
import lang::qls::syntax::QLS;
import lang::qls::util::Implode;
import lang::qls::util::Parse;

private str LANG_QL = "QL-R";
private str EXT_QL = "q";

private str LANG_QLS = "QLS-R";
private str EXT_QLS = "qs";

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

private Stylesheet implodeQLS(Tree t) =
  lang::qls::util::Implode::implode(t);

private start[Stylesheet] parseQLS(str src, loc l) =
  lang::qls::util::Parse::parse(src, l);

private set[Message] semanticCheckerQLS(Tree t) =
  lang::qls::analysis::SemanticChecker::semanticChecker(implodeQLS(t));

private void formatQLS(start[Stylesheet] s, loc l) =
  writeFile(l, lang::qls::compiler::PrettyPrinter::prettyPrint(implodeQLS(s)));

private void setupQL() {
  registerLanguage(LANG_QL, EXT_QL, Tree(str src, loc l) {
    return parseQL(src, l);
  });
  
  contribs = {
    outliner(node(Tree input) {
      return outlineForm(implodeQL(input));
    }),
    
    annotator(Tree (Tree input) {
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

private void setupQLS() {
  registerLanguage(LANG_QLS, EXT_QLS, Tree(str src, loc l) {
    return parseQLS(src, l);
  });
  
  contribs = {
    outliner(node(Tree input) {
      return outlineStylesheet(implodeQLS(input));
    }),
    
    annotator(Tree (Tree input) {
      return input[@messages=semanticCheckerQLS(input)];
    }),
    
    popup(
      menu("QLS",[
        action("Format (removes comments)", formatQLS)
      ])
    )
  };
  
  registerContributions(LANG_QLS, contribs);
}

public void main() {
  setupQLS(); 
  setupQL();
}
