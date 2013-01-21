module Plugin

import ParseTree;
import IO;
import util::IDE;

import lang::ql::analysis::SemanticChecker;
import lang::ql::ast::AST;
import lang::ql::compiler::PrettyPrinter;
import lang::ql::ide::Outline;
import lang::ql::syntax::QL;
import lang::ql::util::Implode;
import lang::ql::util::Parse;

import lang::qls::ast::AST;
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

private Stylesheet implodeStylesheet(Tree t) =
  lang::qls::util::Implode::implode(t);

private start[Stylesheet] parseStylesheet(str src, loc l) =
  lang::qls::util::Parse::parse(src, l);

private void format(start[Form] f, loc l) {
  writeFile(l, prettyPrint(implodeQL(f)));
}

private void setupQL() {
  registerLanguage(LANG_QL, EXT_QL, Tree(str src, loc l) {
    return parseQL(src, l);
  });
  
  contribs = {
    outliner(node(Tree input) {
      return outlineForm(implodeQL(input));
    }),
    
    annotator(Tree (Tree input) {
      return input[@messages=semanticChecker(implodeQL(input))];
    }),
    
    popup(
      menu("QL",[
        action("Format (removes comments)", format)
      ])
    )
  };
  
  registerContributions(LANG_QL, contribs);
}

private void setupQLS() {
  registerLanguage(LANG_QLS, EXT_QLS, Tree(str src, loc l) {
    return parseStylesheet(src, l);
  });
  
  contribs = {
    outliner(node(Tree input) {
      return outlineStylesheet(implodeStylesheet(input));
    })
  };
  
  registerContributions(LANG_QLS, contribs);
}

public void main() {
  setupQLS(); 
  setupQL();
}
