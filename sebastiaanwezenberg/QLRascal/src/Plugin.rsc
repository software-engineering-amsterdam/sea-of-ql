module Plugin

import util::IDE;
import lang::ql::util::Parse;
import ParseTree;


public void main() {
  registerLanguage("QL-R", "q", Tree(str src, loc l) {
     return parse(src, l);
  });
}
