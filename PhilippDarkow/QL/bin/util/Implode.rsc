module util::Implode

import ParseTree;
import util::Load;
import syntax::AbstractSyntax;
import IO;
import Prelude;


public EXP implode(Tree t) {
 println("TREE : <t>");
 return implode(#EXP, t);
 }

public EXP load(loc l) = implode(parse(readFile(l), l));