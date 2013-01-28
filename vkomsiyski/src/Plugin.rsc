module Plugin

import util::IDE;
import lang::ql::util::Parse;
import lang::ql::util::Implode;
import lang::ql::ide::Outline;
import lang::ql::ide::Check;
import lang::ql::ide::Build;
import ParseTree;

private str LANG = "QL-R";
private str EXT = "q";


public void main() {
  registerLanguage(LANG, EXT, parser);
  registerContributions(LANG, {getOutliner(), getAnnotator(), getBuilder()});
}


private Tree parser(str src, loc l) = parse(src, l);
