module lang::ql::syntax::Declarations

syntax Declarations 
	= decls: ConstSect? consts TypeSect? types VarSect? vars
	;

syntax ConstDecl 
	= constDecl: Ident name "=" Expression value ";"
	;
	
syntax ConstSect 
	= "CONST" ConstDecl* consts
	;

syntax TypeDecl 
	= typeDecl: Ident name "=" Type type ";"
	;

syntax TypeSect 
	= "TYPE" TypeDecl* types
	;

syntax VarDecl 
	= varDecl: {Ident ","}* names ":" Type type ";"
	;
	
syntax VarSect 
	= @Foldable "VAR" VarDecl* vars
	;

keyword Keywords 
	= "VAR" 
	| "TYPE" 
	| "CONST" 
	;
	