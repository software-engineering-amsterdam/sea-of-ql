module Plugin

import util::IDE;
import lang::ql::util::Parse;
import ParseTree;

private str LANG = "QL-R";
private str EXT = "ql";


public void main() {
  registerLanguage(LANG, EXT, Tree(str src, loc l) {
     return parse(src, l);
  });
  //registerOutliner(CONTROLLER_LANG, controllerOutliner);
  //registerAnnotator(CONTROLLER_LANG, check);
}

Tree parser(str x, loc l) {
    return parse(#FORM, x, l);
    }