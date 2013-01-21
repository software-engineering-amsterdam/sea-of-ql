module util::Parse

import syntax::ConcreteSyntax;
import ParseTree;
import Prelude;

public start[Expression] parse(str src, loc l) {
 println("SRC : <src>");
 println("L : <l>");
 return parse(#start[Expression], src, l);
 }