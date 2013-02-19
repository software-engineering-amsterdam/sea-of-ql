// $ANTLR 3.5 C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-02-17 23:48:44

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.bool.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.math.*;
import org.uva.sea.ql.ast.literals.*;
import org.uva.sea.ql.ast.expressions.*;
import org.uva.sea.ql.ast.elements.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class QLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Assign", "COMMENT", "Form", "FormIdent", 
		"Ident", "Int", "LEFTBR", "LEFTCBR", "RIGHTBR", "RIGHTCBR", "String", 
		"WS", "'!'", "'!='", "'&&'", "'*'", "'+'", "'-'", "'/'", "'<'", "'<='", 
		"'=='", "'>'", "'>='", "'boolean'", "'if'", "'integer'", "'money'", "'string'", 
		"'||'"
	};
	public static final int EOF=-1;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int T__33=33;
	public static final int Assign=4;
	public static final int COMMENT=5;
	public static final int Form=6;
	public static final int FormIdent=7;
	public static final int Ident=8;
	public static final int Int=9;
	public static final int LEFTBR=10;
	public static final int LEFTCBR=11;
	public static final int RIGHTBR=12;
	public static final int RIGHTCBR=13;
	public static final int String=14;
	public static final int WS=15;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public QLParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public QLParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
		this.state.ruleMemo = new HashMap[46+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g"; }



	// $ANTLR start "parse"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:21:1: parse returns [Form result] : formDefinition EOF ;
	public final Form parse() throws RecognitionException {
		Form result = null;

		int parse_StartIndex = input.index();

		Form formDefinition1 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:22:4: ( formDefinition EOF )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:22:4: formDefinition EOF
			{
			pushFollow(FOLLOW_formDefinition_in_parse45);
			formDefinition1=formDefinition();
			state._fsp--;
			if (state.failed) return result;
			match(input,EOF,FOLLOW_EOF_in_parse47); if (state.failed) return result;
			if ( state.backtracking==0 ) {result = formDefinition1;}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 1, parse_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "parse"



	// $ANTLR start "formDefinition"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:24:1: formDefinition returns [Form result] : Form formDeclaration ;
	public final Form formDefinition() throws RecognitionException {
		Form result = null;

		int formDefinition_StartIndex = input.index();

		Form formDeclaration2 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:25:2: ( Form formDeclaration )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:25:5: Form formDeclaration
			{
			match(input,Form,FOLLOW_Form_in_formDefinition63); if (state.failed) return result;
			pushFollow(FOLLOW_formDeclaration_in_formDefinition65);
			formDeclaration2=formDeclaration();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) {result = formDeclaration2;}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 2, formDefinition_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "formDefinition"



	// $ANTLR start "formDeclaration"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:27:1: formDeclaration returns [Form result] : FormIdent LEFTCBR blockContent RIGHTCBR ;
	public final Form formDeclaration() throws RecognitionException {
		Form result = null;

		int formDeclaration_StartIndex = input.index();

		Token FormIdent3=null;
		Block blockContent4 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:28:4: ( FormIdent LEFTCBR blockContent RIGHTCBR )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:28:4: FormIdent LEFTCBR blockContent RIGHTCBR
			{
			FormIdent3=(Token)match(input,FormIdent,FOLLOW_FormIdent_in_formDeclaration81); if (state.failed) return result;
			match(input,LEFTCBR,FOLLOW_LEFTCBR_in_formDeclaration83); if (state.failed) return result;
			pushFollow(FOLLOW_blockContent_in_formDeclaration85);
			blockContent4=blockContent();
			state._fsp--;
			if (state.failed) return result;
			match(input,RIGHTCBR,FOLLOW_RIGHTCBR_in_formDeclaration87); if (state.failed) return result;
			if ( state.backtracking==0 ) {result = new Form((FormIdent3!=null?FormIdent3.getText():null), blockContent4);}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 3, formDeclaration_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "formDeclaration"



	// $ANTLR start "blockContent"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:30:1: blockContent returns [Block result] : ( blockLine )* ;
	public final Block blockContent() throws RecognitionException {
		Block result = null;

		int blockContent_StartIndex = input.index();

		BlockElement blockLine5 =null;


			List l = new ArrayList();
			result = new Block(l);	

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:36:3: ( ( blockLine )* )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:36:3: ( blockLine )*
			{
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:36:3: ( blockLine )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==Ident||LA1_0==29) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:36:4: blockLine
					{
					pushFollow(FOLLOW_blockLine_in_blockContent108);
					blockLine5=blockLine();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {if(blockLine5 != null) {result.addLine(blockLine5);}}
					}
					break;

				default :
					break loop1;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 4, blockContent_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "blockContent"



	// $ANTLR start "blockLine"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:39:1: blockLine returns [BlockElement result] : ( question | ifStatement );
	public final BlockElement blockLine() throws RecognitionException {
		BlockElement result = null;

		int blockLine_StartIndex = input.index();

		Question question6 =null;
		IfStatement ifStatement7 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:40:4: ( question | ifStatement )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==Ident) ) {
				alt2=1;
			}
			else if ( (LA2_0==29) ) {
				alt2=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:40:4: question
					{
					pushFollow(FOLLOW_question_in_blockLine129);
					question6=question();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result = question6;}
					}
					break;
				case 2 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:41:3: ifStatement
					{
					pushFollow(FOLLOW_ifStatement_in_blockLine135);
					ifStatement7=ifStatement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result = ifStatement7;}
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 5, blockLine_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "blockLine"



	// $ANTLR start "question"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:44:1: question returns [Question result] : Ident Assign String type ;
	public final Question question() throws RecognitionException {
		Question result = null;

		int question_StartIndex = input.index();

		Token Ident8=null;
		Token String9=null;
		Type type10 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:45:3: ( Ident Assign String type )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:45:3: Ident Assign String type
			{
			Ident8=(Token)match(input,Ident,FOLLOW_Ident_in_question150); if (state.failed) return result;
			match(input,Assign,FOLLOW_Assign_in_question152); if (state.failed) return result;
			String9=(Token)match(input,String,FOLLOW_String_in_question154); if (state.failed) return result;
			pushFollow(FOLLOW_type_in_question156);
			type10=type();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) {result = new Question(new Ident((Ident8!=null?Ident8.getText():null)), new StringLiteral((String9!=null?String9.getText():null)), type10);}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 6, question_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "question"



	// $ANTLR start "ifStatement"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:48:1: ifStatement returns [IfStatement result] : 'if' LEFTBR orExpr RIGHTBR LEFTCBR blockContent RIGHTCBR ;
	public final IfStatement ifStatement() throws RecognitionException {
		IfStatement result = null;

		int ifStatement_StartIndex = input.index();

		Expr orExpr11 =null;
		Block blockContent12 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:49:3: ( 'if' LEFTBR orExpr RIGHTBR LEFTCBR blockContent RIGHTCBR )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:49:3: 'if' LEFTBR orExpr RIGHTBR LEFTCBR blockContent RIGHTCBR
			{
			match(input,29,FOLLOW_29_in_ifStatement171); if (state.failed) return result;
			match(input,LEFTBR,FOLLOW_LEFTBR_in_ifStatement173); if (state.failed) return result;
			pushFollow(FOLLOW_orExpr_in_ifStatement175);
			orExpr11=orExpr();
			state._fsp--;
			if (state.failed) return result;
			match(input,RIGHTBR,FOLLOW_RIGHTBR_in_ifStatement177); if (state.failed) return result;
			match(input,LEFTCBR,FOLLOW_LEFTCBR_in_ifStatement179); if (state.failed) return result;
			pushFollow(FOLLOW_blockContent_in_ifStatement181);
			blockContent12=blockContent();
			state._fsp--;
			if (state.failed) return result;
			match(input,RIGHTCBR,FOLLOW_RIGHTCBR_in_ifStatement183); if (state.failed) return result;
			if ( state.backtracking==0 ) {result = new IfStatement(orExpr11, blockContent12);}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 7, ifStatement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "ifStatement"



	// $ANTLR start "type"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:52:1: type returns [Type result] : ( boolType | money | intType | strType );
	public final Type type() throws RecognitionException {
		Type result = null;

		int type_StartIndex = input.index();

		BooleanType boolType13 =null;
		Money money14 =null;
		IntType intType15 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:53:2: ( boolType | money | intType | strType )
			int alt3=4;
			switch ( input.LA(1) ) {
			case 28:
				{
				alt3=1;
				}
				break;
			case 31:
				{
				alt3=2;
				}
				break;
			case 30:
				{
				alt3=3;
				}
				break;
			case 32:
				{
				alt3=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:53:5: boolType
					{
					pushFollow(FOLLOW_boolType_in_type200);
					boolType13=boolType();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = boolType13;}
					}
					break;
				case 2 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:54:5: money
					{
					pushFollow(FOLLOW_money_in_type208);
					money14=money();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = money14;}
					}
					break;
				case 3 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:55:5: intType
					{
					pushFollow(FOLLOW_intType_in_type219);
					intType15=intType();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = intType15;}
					}
					break;
				case 4 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:56:5: strType
					{
					pushFollow(FOLLOW_strType_in_type227);
					strType();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new StrType();}
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 8, type_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "type"



	// $ANTLR start "intType"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:58:1: intType returns [IntType result] : ( 'integer' | 'integer' LEFTBR addExpr RIGHTBR );
	public final IntType intType() throws RecognitionException {
		IntType result = null;

		int intType_StartIndex = input.index();

		Expr addExpr16 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:59:2: ( 'integer' | 'integer' LEFTBR addExpr RIGHTBR )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==30) ) {
				int LA4_1 = input.LA(2);
				if ( (LA4_1==LEFTBR) ) {
					alt4=2;
				}
				else if ( (LA4_1==EOF||LA4_1==Ident||(LA4_1 >= RIGHTBR && LA4_1 <= RIGHTCBR)||(LA4_1 >= 17 && LA4_1 <= 27)||LA4_1==29||LA4_1==33) ) {
					alt4=1;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return result;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 4, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:59:4: 'integer'
					{
					match(input,30,FOLLOW_30_in_intType243); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new IntType(); }
					}
					break;
				case 2 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:60:5: 'integer' LEFTBR addExpr RIGHTBR
					{
					match(input,30,FOLLOW_30_in_intType251); if (state.failed) return result;
					match(input,LEFTBR,FOLLOW_LEFTBR_in_intType253); if (state.failed) return result;
					pushFollow(FOLLOW_addExpr_in_intType255);
					addExpr16=addExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,RIGHTBR,FOLLOW_RIGHTBR_in_intType257); if (state.failed) return result;
					if ( state.backtracking==0 ) {result = new IntType( addExpr16);}
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 9, intType_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "intType"



	// $ANTLR start "money"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:62:1: money returns [Money result] : ( 'money' | 'money' LEFTBR addExpr RIGHTBR );
	public final Money money() throws RecognitionException {
		Money result = null;

		int money_StartIndex = input.index();

		Expr addExpr17 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:63:2: ( 'money' | 'money' LEFTBR addExpr RIGHTBR )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==31) ) {
				int LA5_1 = input.LA(2);
				if ( (LA5_1==LEFTBR) ) {
					alt5=2;
				}
				else if ( (LA5_1==EOF||LA5_1==Ident||(LA5_1 >= RIGHTBR && LA5_1 <= RIGHTCBR)||(LA5_1 >= 17 && LA5_1 <= 27)||LA5_1==29||LA5_1==33) ) {
					alt5=1;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return result;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 5, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:63:5: 'money'
					{
					match(input,31,FOLLOW_31_in_money273); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Money(); }
					}
					break;
				case 2 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:64:5: 'money' LEFTBR addExpr RIGHTBR
					{
					match(input,31,FOLLOW_31_in_money281); if (state.failed) return result;
					match(input,LEFTBR,FOLLOW_LEFTBR_in_money283); if (state.failed) return result;
					pushFollow(FOLLOW_addExpr_in_money285);
					addExpr17=addExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,RIGHTBR,FOLLOW_RIGHTBR_in_money287); if (state.failed) return result;
					if ( state.backtracking==0 ) {result = new Money( addExpr17);}
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 10, money_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "money"



	// $ANTLR start "boolType"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:66:1: boolType returns [BooleanType result] : ( 'boolean' | 'boolean' LEFTBR addExpr RIGHTBR );
	public final BooleanType boolType() throws RecognitionException {
		BooleanType result = null;

		int boolType_StartIndex = input.index();

		Expr addExpr18 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:67:2: ( 'boolean' | 'boolean' LEFTBR addExpr RIGHTBR )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==28) ) {
				int LA6_1 = input.LA(2);
				if ( (LA6_1==LEFTBR) ) {
					alt6=2;
				}
				else if ( (LA6_1==EOF||LA6_1==Ident||(LA6_1 >= RIGHTBR && LA6_1 <= RIGHTCBR)||(LA6_1 >= 17 && LA6_1 <= 27)||LA6_1==29||LA6_1==33) ) {
					alt6=1;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return result;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 6, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:67:4: 'boolean'
					{
					match(input,28,FOLLOW_28_in_boolType302); if (state.failed) return result;
					if ( state.backtracking==0 ) {result = new BooleanType(); }
					}
					break;
				case 2 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:68:4: 'boolean' LEFTBR addExpr RIGHTBR
					{
					match(input,28,FOLLOW_28_in_boolType308); if (state.failed) return result;
					match(input,LEFTBR,FOLLOW_LEFTBR_in_boolType310); if (state.failed) return result;
					pushFollow(FOLLOW_addExpr_in_boolType312);
					addExpr18=addExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,RIGHTBR,FOLLOW_RIGHTBR_in_boolType314); if (state.failed) return result;
					if ( state.backtracking==0 ) {result = new BooleanType(addExpr18); }
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 11, boolType_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "boolType"



	// $ANTLR start "primary"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:72:1: primary returns [Expr result] : ( Int | Ident | String | type | '(' x= orExpr ')' );
	public final Expr primary() throws RecognitionException {
		Expr result = null;

		int primary_StartIndex = input.index();

		Token Int19=null;
		Token Ident20=null;
		Token String21=null;
		Expr x =null;
		Type type22 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:73:3: ( Int | Ident | String | type | '(' x= orExpr ')' )
			int alt7=5;
			switch ( input.LA(1) ) {
			case Int:
				{
				alt7=1;
				}
				break;
			case Ident:
				{
				alt7=2;
				}
				break;
			case String:
				{
				alt7=3;
				}
				break;
			case 28:
			case 30:
			case 31:
			case 32:
				{
				alt7=4;
				}
				break;
			case LEFTBR:
				{
				alt7=5;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}
			switch (alt7) {
				case 1 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:73:5: Int
					{
					Int19=(Token)match(input,Int,FOLLOW_Int_in_primary333); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new IntLiteral(Integer.parseInt((Int19!=null?Int19.getText():null))); }
					}
					break;
				case 2 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:74:5: Ident
					{
					Ident20=(Token)match(input,Ident,FOLLOW_Ident_in_primary343); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((Ident20!=null?Ident20.getText():null)); }
					}
					break;
				case 3 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:75:5: String
					{
					String21=(Token)match(input,String,FOLLOW_String_in_primary351); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new StringLiteral((String21!=null?String21.getText():null)); }
					}
					break;
				case 4 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:76:5: type
					{
					pushFollow(FOLLOW_type_in_primary359);
					type22=type();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result = type22; }
					}
					break;
				case 5 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:77:5: '(' x= orExpr ')'
					{
					match(input,LEFTBR,FOLLOW_LEFTBR_in_primary367); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary371);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,RIGHTBR,FOLLOW_RIGHTBR_in_primary373); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = x; }
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 12, primary_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "primary"



	// $ANTLR start "unExpr"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:80:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;

		int unExpr_StartIndex = input.index();

		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:81:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
			int alt8=4;
			switch ( input.LA(1) ) {
			case 20:
				{
				alt8=1;
				}
				break;
			case 21:
				{
				alt8=2;
				}
				break;
			case 16:
				{
				alt8=3;
				}
				break;
			case Ident:
			case Int:
			case LEFTBR:
			case String:
			case 28:
			case 30:
			case 31:
			case 32:
				{
				alt8=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:81:8: '+' x= unExpr
					{
					match(input,20,FOLLOW_20_in_unExpr398); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr402);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:82:8: '-' x= unExpr
					{
					match(input,21,FOLLOW_21_in_unExpr413); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr417);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:83:8: '!' x= unExpr
					{
					match(input,16,FOLLOW_16_in_unExpr428); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr432);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:84:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr445);
					x=primary();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = x; }
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 13, unExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "unExpr"



	// $ANTLR start "mulExpr"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:88:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:88:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr483);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:88:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==19||LA9_0==22) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:88:47: op= ( '*' | '/' ) rhs= unExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==19||input.LA(1)==22 ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unExpr_in_mulExpr503);
					rhs=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { 
					      if ((op!=null?op.getText():null).equals("*")) {
					        result = new Mul(result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals("/")) {
					        result = new Div(result, rhs);      
					      }
					    }
					}
					break;

				default :
					break loop9;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 14, mulExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "mulExpr"



	// $ANTLR start "addExpr"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:100:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:101:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:101:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr544);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:101:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( ((LA10_0 >= 20 && LA10_0 <= 21)) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:101:48: op= ( '+' | '-' ) rhs= mulExpr
					{
					op=input.LT(1);
					if ( (input.LA(1) >= 20 && input.LA(1) <= 21) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mulExpr_in_addExpr562);
					rhs=mulExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { 
					      if ((op!=null?op.getText():null).equals("+")) {
					        result = new Add(result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals("-")) {
					        result = new Sub(result, rhs);      
					      }
					    }
					}
					break;

				default :
					break loop10;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 15, addExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "addExpr"



	// $ANTLR start "relExpr"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:112:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:113:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:113:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr597);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:113:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==17||(LA11_0 >= 23 && LA11_0 <= 27)) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:113:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==17||(input.LA(1) >= 23 && input.LA(1) <= 27) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_relExpr621);
					rhs=addExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { 
					      if ((op!=null?op.getText():null).equals("<")) {
					        result = new LT(result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals("<=")) {
					        result = new LEq(result, rhs);      
					      }
					      if ((op!=null?op.getText():null).equals(">")) {
					        result = new GT(result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals(">=")) {
					        result = new GEq(result, rhs);      
					      }
					      if ((op!=null?op.getText():null).equals("==")) {
					        result = new Eq(result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals("!=")) {
					        result = new NEq(result, rhs);
					      }
					    }
					}
					break;

				default :
					break loop11;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 16, relExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "relExpr"



	// $ANTLR start "andExpr"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:136:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;

		int andExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:137:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:137:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr659);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:137:46: ( '&&' rhs= relExpr )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==18) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:137:48: '&&' rhs= relExpr
					{
					match(input,18,FOLLOW_18_in_andExpr665); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr669);
					rhs=relExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new And(result, rhs); }
					}
					break;

				default :
					break loop12;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 17, andExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "andExpr"



	// $ANTLR start "orExpr"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:141:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;

		int orExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:142:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:142:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr704);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:142:48: ( '||' rhs= andExpr )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==33) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:142:50: '||' rhs= andExpr
					{
					match(input,33,FOLLOW_33_in_orExpr710); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr714);
					rhs=andExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Or(result, rhs); }
					}
					break;

				default :
					break loop13;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 18, orExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "orExpr"



	// $ANTLR start "strType"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:146:1: strType : 'string' ;
	public final void strType() throws RecognitionException {
		int strType_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:146:9: ( 'string' )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:146:11: 'string'
			{
			match(input,32,FOLLOW_32_in_strType737); if (state.failed) return;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 19, strType_StartIndex); }

		}
	}
	// $ANTLR end "strType"

	// Delegated rules



	public static final BitSet FOLLOW_formDefinition_in_parse45 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_parse47 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Form_in_formDefinition63 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_formDeclaration_in_formDefinition65 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FormIdent_in_formDeclaration81 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_LEFTCBR_in_formDeclaration83 = new BitSet(new long[]{0x0000000020002100L});
	public static final BitSet FOLLOW_blockContent_in_formDeclaration85 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_RIGHTCBR_in_formDeclaration87 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_blockLine_in_blockContent108 = new BitSet(new long[]{0x0000000020000102L});
	public static final BitSet FOLLOW_question_in_blockLine129 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifStatement_in_blockLine135 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_question150 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_Assign_in_question152 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_String_in_question154 = new BitSet(new long[]{0x00000001D0000000L});
	public static final BitSet FOLLOW_type_in_question156 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_ifStatement171 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_LEFTBR_in_ifStatement173 = new BitSet(new long[]{0x00000001D0314700L});
	public static final BitSet FOLLOW_orExpr_in_ifStatement175 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_RIGHTBR_in_ifStatement177 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_LEFTCBR_in_ifStatement179 = new BitSet(new long[]{0x0000000020002100L});
	public static final BitSet FOLLOW_blockContent_in_ifStatement181 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_RIGHTCBR_in_ifStatement183 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_boolType_in_type200 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_money_in_type208 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_intType_in_type219 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_strType_in_type227 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_intType243 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_intType251 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_LEFTBR_in_intType253 = new BitSet(new long[]{0x00000001D0314700L});
	public static final BitSet FOLLOW_addExpr_in_intType255 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_RIGHTBR_in_intType257 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_money273 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_money281 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_LEFTBR_in_money283 = new BitSet(new long[]{0x00000001D0314700L});
	public static final BitSet FOLLOW_addExpr_in_money285 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_RIGHTBR_in_money287 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_boolType302 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_boolType308 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_LEFTBR_in_boolType310 = new BitSet(new long[]{0x00000001D0314700L});
	public static final BitSet FOLLOW_addExpr_in_boolType312 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_RIGHTBR_in_boolType314 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_primary333 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary343 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_String_in_primary351 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_primary359 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFTBR_in_primary367 = new BitSet(new long[]{0x00000001D0314700L});
	public static final BitSet FOLLOW_orExpr_in_primary371 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_RIGHTBR_in_primary373 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_unExpr398 = new BitSet(new long[]{0x00000001D0314700L});
	public static final BitSet FOLLOW_unExpr_in_unExpr402 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_unExpr413 = new BitSet(new long[]{0x00000001D0314700L});
	public static final BitSet FOLLOW_unExpr_in_unExpr417 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_16_in_unExpr428 = new BitSet(new long[]{0x00000001D0314700L});
	public static final BitSet FOLLOW_unExpr_in_unExpr432 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr445 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr483 = new BitSet(new long[]{0x0000000000480002L});
	public static final BitSet FOLLOW_set_in_mulExpr491 = new BitSet(new long[]{0x00000001D0314700L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr503 = new BitSet(new long[]{0x0000000000480002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr544 = new BitSet(new long[]{0x0000000000300002L});
	public static final BitSet FOLLOW_set_in_addExpr552 = new BitSet(new long[]{0x00000001D0314700L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr562 = new BitSet(new long[]{0x0000000000300002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr597 = new BitSet(new long[]{0x000000000F820002L});
	public static final BitSet FOLLOW_set_in_relExpr605 = new BitSet(new long[]{0x00000001D0314700L});
	public static final BitSet FOLLOW_addExpr_in_relExpr621 = new BitSet(new long[]{0x000000000F820002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr659 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_18_in_andExpr665 = new BitSet(new long[]{0x00000001D0314700L});
	public static final BitSet FOLLOW_relExpr_in_andExpr669 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr704 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_33_in_orExpr710 = new BitSet(new long[]{0x00000001D0314700L});
	public static final BitSet FOLLOW_andExpr_in_orExpr714 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_32_in_strType737 = new BitSet(new long[]{0x0000000000000002L});
}
