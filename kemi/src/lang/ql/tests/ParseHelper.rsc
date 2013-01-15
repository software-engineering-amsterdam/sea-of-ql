module lang::ql::tests::ParseHelper

import IO;
import ParseTree;
import lang::ql::ast::AST;
import lang::ql::syntax::QL;

public Expr parseExpr(str src) = implode(#lang::ql::ast::AST::Expr, parse(#lang::ql::syntax::QL::Expr, src, |file:///-|));
public Question parseQuestion(str src) = implode(#lang::ql::ast::AST::Question, parse(#lang::ql::syntax::QL::Question, src, |file:///-|));
public Form parseForm(str src) = implode(#lang::ql::ast::AST::Form, parse(#start[Form], src, |file:///-|));
public Form parseForm(loc f) = parseForm(readFile(f));
