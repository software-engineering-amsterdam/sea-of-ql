module lang::qls::util::Parse

import lang::qls::syntax::QLS;
import ParseTree;

public start[QLS] parse(str src, loc l) = parse(#start[QLS], src, l);
