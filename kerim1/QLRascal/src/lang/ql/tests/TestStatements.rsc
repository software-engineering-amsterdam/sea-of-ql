module lang::ql::tests::TestStatements

import ParseTree;

import lang::ql::ast::AST;
import lang::ql::util::Parse;

private Statement p(str src) = implode(#Statement, parseStatement(src));

public test bool testIfThenElse1() = p(	"if (a == b) { 
										'	a: \"abc\" string 
										'} else { 
										'	b: \"bcd\" int }") is ifThenElse;
										
public test bool testIfThenElse2() = p("if(test){a: \"abc\" string}else{b: \"bcd\" int}") is ifThenElse;

public test bool testIfThenElse3() = p(	"if (a == b) { 
										'	a: \"abc\" string 
										'} else if (test) {
										'	b: \"bcd\" int
										'} else { 
										'	c: \"cde\" bool }") is ifThenElse;

public test bool testIfThenElse4() = p(	"if(a == b){ 
										'	a: \"abc\" string 
										'	b: \"bcd\" int
										'}elseif(test){
										'	c: \"cde\" bool
										'	d: \"def\" bool
										'}elseif(1 \> 2){
										'	e: \"efg\" string
										'}else{ 
										'	f: \"fgh\" int}") is ifThenElse;
										
public test bool testIfThen1() = p(	"if (a == b) { 
										'	a: \"abc\" string }") is ifThen;
										
public test bool testIfThen2() = p("if(test){a: \"abc\" string}") is ifThen;

public test bool testIfThen3() = p(	"if (a == b) { 
										'	a: \"abc\" string 
										'} else if (test) {
										'	b: \"bcd\" int }") is ifThen;

public test bool testIfThen4() = p(	"if(a == b){ 
										'	a: \"abc\" string 
										'	b: \"bcd\" int
										'}elseif(test){
										'	c: \"cde\" bool
										'	d: \"def\" bool
										'}elseif(1 \> 2){
										'	e: \"efg\" string}") is ifThen;						