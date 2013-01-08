module Plugin

import util::IDE;
import lang::ql::util::Parse;
import ParseTree;

import lang::ql::syntax::QL;

private str LANG = "QL-R";
private str EXT = "q";


public void main() {
  registerLanguage(LANG, EXT, Tree(str src, loc l) {
     return parse(src, l);
  });
  /*
  registerOutliner("myLanguage", node (Form t) { 
  n = "myNode"();
  n@\loc = t@\loc;
  n@label = "My node label";
return n;
});*/
  
}


