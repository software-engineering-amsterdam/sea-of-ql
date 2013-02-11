module Plugin

import lang::ql::ide::Outline;
import lang::ql::util::Parse;
import lang::ql::util::Implode;

import util::IDE;
import ParseTree;

private str LANG = "QL-R";

public void main() {
	registerLanguage(LANG, "q", Tree(str src, loc l) {
		return parse(src, l);
	});
	
	registerOutliner(LANG, outlineModule);
}