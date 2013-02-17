module lang::ql::ide::Outline

import lang::ql::syntax::Expressions;
import lang::ql::syntax::Declarations;

import ParseTree; 

data Node
	= outline(list[Node] nodes)
	| constDecl()
	| varDecl()
	| typeDecl()
	;	

anno str Node@label;
anno loc Node@\loc;

public node outlineModule(Form x) 
{
	return outlineDecls(x.decls)[@label="<x.name>"];
}

Node outlineDecls(Declarations decls) 
{
	cds = outline([ constDecl()[@label="<cd.name>"][@\loc=cd@\loc] | /ConstDecl cd := decls.consts ])[@label="Constants"];
	tds = outline([ typeDecl()[@label="<td.name>"][@\loc=td@\loc] | /TypeDecl td := decls.types ])[@label="Types"];
	vds = outline([ varDecl()[@label="<vd.names>"][@\loc=vd@\loc] | /VarDecl vd := decls.vars ])[@label="Variables"];
	
 	return outline([cds, tds, vds]);
}