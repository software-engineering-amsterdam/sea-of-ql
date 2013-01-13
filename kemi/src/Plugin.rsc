module Plugin

import util::IDE;
import lang::ql::ide::Outline;
import lang::ql::util::Parse;
import lang::ql::util::Implode;
import ParseTree;

private str LANG = "QL-R";
private str EXT = "q";


public void main() {
  registerLanguage(LANG, EXT, Tree(str src, loc l) {
  return parse(src, l);
  });
  
  contribs = {
    outliner(node(Tree input) {
      return outlineForm(implode(input));
    })
  };
  
  registerContributions(LANG, contribs);
}
