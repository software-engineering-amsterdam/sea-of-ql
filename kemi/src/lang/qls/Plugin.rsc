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

private str LANG = "QLS-R";
private str EXT = "qs";
private str ACTION_FORMAT = "Format (removes comments)";

private void format(start[Stylesheet] s, loc l) =
  writeFile(l, prettyPrint(implode(s)));

public void setupQLS() {
  registerLanguage(LANG, EXT, Tree(str src, loc l) {
    return parse(src, l);
  });
  
  contribs = {
    outliner(node(Tree input) {
      return outlineStylesheet(implode(input));
    }),
    
    annotator(Tree (Tree input) {
      return input[@messages=semanticChecker(implode(input))];
    }),
    
    popup(
      menu(LANG, [action(ACTION_FORMAT, format)])
    )
  };
  
  registerContributions(LANG, contribs);
}
