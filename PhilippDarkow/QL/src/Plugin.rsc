module Plugin

import util::IDE;
import util::Load;
import ParseTree;

private str LANG = "QL";
private str EXT = "q";


public void main() {
  registerLanguage(LANG, EXT, Tree(str src, loc l) {
     return parse(src, l);
  });
}
