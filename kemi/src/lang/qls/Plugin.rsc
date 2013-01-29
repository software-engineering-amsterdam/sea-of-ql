module lang::qls::Plugin

import IO;
import ParseTree;
import util::IDE;
import util::Prompt;

import lang::qls::analysis::SemanticChecker;
import lang::qls::ast::AST;
import lang::qls::compiler::PrettyPrinter;
import lang::qls::ide::Outline;
import lang::qls::syntax::QLS;
import lang::qls::util::Implode;
import lang::qls::util::Parse;

private str LANG_QLS = "QLS-R";
private str EXT_QLS = "qs";

private Stylesheet implodeQLS(Tree t) =
  lang::qls::util::Implode::implode(t);

private start[Stylesheet] parseQLS(str src, loc l) =
  lang::qls::util::Parse::parse(src, l);

private set[Message] semanticCheckerQLS(Tree t) =
  lang::qls::analysis::SemanticChecker::semanticChecker(implodeQLS(t));

private void formatQLS(start[Stylesheet] s, loc l) =
  writeFile(l, lang::qls::compiler::PrettyPrinter::prettyPrint(implodeQLS(s)));

public void setupQLS() {
  registerLanguage(LANG_QLS, EXT_QLS, Tree(str src, loc l) {
    return parseQLS(src, l);
  });
  
  contribs = {
    outliner(node(Tree input) {
      return outlineStylesheet(implodeQLS(input));
    }),
    /*
    annotator(Tree (Tree input) {
      return input[@messages=semanticCheckerQLS(input)];
    }),
    */
    popup(
      menu("QLS",[
        action("Format (removes comments)", formatQLS)
      ])
    )
  };
  
  registerContributions(LANG_QLS, contribs);
}
