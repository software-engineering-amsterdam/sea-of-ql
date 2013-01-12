module Plugin

import util::IDE;
import lang::ql::util::Parse;
import lang::ql::util::Implode;
import lang::ql::ide::Outline;
import ParseTree;

private str LANG = "QL-R";
private str EXT = "q";


public void main() {

  registerLanguage(LANG, EXT, Tree(str src, loc l) {
     return parse(src, l);
  });
  
  registerContributions(LANG, {getOutliner()});
}
