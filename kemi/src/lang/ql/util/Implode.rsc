module lang::ql::util::Implode

import ParseTree;
import lang::ql::util::Parse;
import lang::ql::ast::AST;
import util::Maybe;


public Form implode(Tree t) {
    // TODO: Do we want this?
    i = implode(#Form, t);
    return visit(i) {
        case question(a, b, c, []) => question(string(a), \type(b), ident(c), nothing())
        case question(a, b, c, [d]) => question(string(a), \type(b), ident(c), just(d))
    };
}

public Form load(loc l) = implode(parse(readFile(l), l));