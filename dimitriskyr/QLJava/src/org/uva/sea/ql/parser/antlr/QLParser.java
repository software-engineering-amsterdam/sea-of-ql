// $ANTLR 3.5 C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-01-15 01:07:32

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class QLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "Ident", "Int", "SIMPLECOMMENT", 
		"WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", 
		"'<'", "'<='", "'=='", "'>'", "'>='", "'||'"
	};
	public static final int EOF=-1;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int COMMENT=4;
	public static final int Ident=5;
	public static final int Int=6;
	public static final int SIMPLECOMMENT=7;
	public static final int WS=8;

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
		this.state.ruleMemo = new HashMap[24+1];


	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g"; }


	public static class primary_return extends ParserRuleReturnScope {
		public Expr result;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "primary"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:15:1: primary returns [Expr result] : ( Int | Ident | '(' x= orExpr ')' );
	public final QLParser.primary_return primary() throws RecognitionException {
		QLParser.primary_return retval = new QLParser.primary_return();
		retval.start = input.LT(1);
		int primary_StartIndex = input.index();

		Object root_0 = null;

		Token Int1=null;
		Token Ident2=null;
		Token char_literal3=null;
		Token char_literal4=null;
		ParserRuleReturnScope x =null;

		Object Int1_tree=null;
		Object Ident2_tree=null;
		Object char_literal3_tree=null;
		Object char_literal4_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }

			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:16:3: ( Int | Ident | '(' x= orExpr ')' )
			int alt1=3;
			switch ( input.LA(1) ) {
			case Int:
				{
				alt1=1;
				}
				break;
			case Ident:
				{
				alt1=2;
				}
				break;
			case 12:
				{
				alt1=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}
			switch (alt1) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:16:5: Int
					{
					root_0 = (Object)adaptor.nil();


					Int1=(Token)match(input,Int,FOLLOW_Int_in_primary58); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Int1_tree = (Object)adaptor.create(Int1);
					adaptor.addChild(root_0, Int1_tree);
					}

					if ( state.backtracking==0 ) { retval.result = new Int(Integer.parseInt((Int1!=null?Int1.getText():null))); }
					}
					break;
				case 2 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:17:5: Ident
					{
					root_0 = (Object)adaptor.nil();


					Ident2=(Token)match(input,Ident,FOLLOW_Ident_in_primary68); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Ident2_tree = (Object)adaptor.create(Ident2);
					adaptor.addChild(root_0, Ident2_tree);
					}

					if ( state.backtracking==0 ) { retval.result = new Ident((Ident2!=null?Ident2.getText():null)); }
					}
					break;
				case 3 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:18:5: '(' x= orExpr ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal3=(Token)match(input,12,FOLLOW_12_in_primary76); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal3_tree = (Object)adaptor.create(char_literal3);
					adaptor.addChild(root_0, char_literal3_tree);
					}

					pushFollow(FOLLOW_orExpr_in_primary80);
					x=orExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());

					char_literal4=(Token)match(input,13,FOLLOW_13_in_primary82); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal4_tree = (Object)adaptor.create(char_literal4);
					adaptor.addChild(root_0, char_literal4_tree);
					}

					if ( state.backtracking==0 ) { retval.result = (x!=null?((QLParser.orExpr_return)x).result:null); }
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 1, primary_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "primary"


	public static class unExpr_return extends ParserRuleReturnScope {
		public Expr result;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "unExpr"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:21:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final QLParser.unExpr_return unExpr() throws RecognitionException {
		QLParser.unExpr_return retval = new QLParser.unExpr_return();
		retval.start = input.LT(1);
		int unExpr_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal5=null;
		Token char_literal6=null;
		Token char_literal7=null;
		ParserRuleReturnScope x =null;

		Object char_literal5_tree=null;
		Object char_literal6_tree=null;
		Object char_literal7_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }

			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:22:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
			int alt2=4;
			switch ( input.LA(1) ) {
			case 15:
				{
				alt2=1;
				}
				break;
			case 16:
				{
				alt2=2;
				}
				break;
			case 9:
				{
				alt2=3;
				}
				break;
			case Ident:
			case Int:
			case 12:
				{
				alt2=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:22:8: '+' x= unExpr
					{
					root_0 = (Object)adaptor.nil();


					char_literal5=(Token)match(input,15,FOLLOW_15_in_unExpr107); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal5_tree = (Object)adaptor.create(char_literal5);
					adaptor.addChild(root_0, char_literal5_tree);
					}

					pushFollow(FOLLOW_unExpr_in_unExpr111);
					x=unExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());

					if ( state.backtracking==0 ) { retval.result = new Pos((x!=null?((QLParser.primary_return)x).result:null)); }
					}
					break;
				case 2 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:23:8: '-' x= unExpr
					{
					root_0 = (Object)adaptor.nil();


					char_literal6=(Token)match(input,16,FOLLOW_16_in_unExpr122); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal6_tree = (Object)adaptor.create(char_literal6);
					adaptor.addChild(root_0, char_literal6_tree);
					}

					pushFollow(FOLLOW_unExpr_in_unExpr126);
					x=unExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());

					if ( state.backtracking==0 ) { retval.result = new Neg((x!=null?((QLParser.primary_return)x).result:null)); }
					}
					break;
				case 3 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:24:8: '!' x= unExpr
					{
					root_0 = (Object)adaptor.nil();


					char_literal7=(Token)match(input,9,FOLLOW_9_in_unExpr137); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal7_tree = (Object)adaptor.create(char_literal7);
					adaptor.addChild(root_0, char_literal7_tree);
					}

					pushFollow(FOLLOW_unExpr_in_unExpr141);
					x=unExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());

					if ( state.backtracking==0 ) { retval.result = new Not((x!=null?((QLParser.primary_return)x).result:null)); }
					}
					break;
				case 4 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:25:8: x= primary
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_primary_in_unExpr154);
					x=primary();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());

					if ( state.backtracking==0 ) { retval.result = (x!=null?((QLParser.primary_return)x).result:null); }
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 2, unExpr_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "unExpr"


	public static class mulExpr_return extends ParserRuleReturnScope {
		public Expr result;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "mulExpr"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:28:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final QLParser.mulExpr_return mulExpr() throws RecognitionException {
		QLParser.mulExpr_return retval = new QLParser.mulExpr_return();
		retval.start = input.LT(1);
		int mulExpr_StartIndex = input.index();

		Object root_0 = null;

		Token op=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object op_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }

			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:29:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:29:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_unExpr_in_mulExpr192);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());

			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.unExpr_return)lhs).result:null); }
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:29:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==14||LA3_0==17) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:29:47: op= ( '*' | '/' ) rhs= unExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==14||input.LA(1)==17 ) {
						input.consume();
						if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(op));
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unExpr_in_mulExpr212);
					rhs=unExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());

					if ( state.backtracking==0 ) { 
					      if ((op!=null?op.getText():null).equals("*")) {
					        retval.result = new Mul(retval.result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals("<=")) {
					        retval.result = new Div(retval.result, rhs);      
					      }
					    }
					}
					break;

				default :
					break loop3;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 3, mulExpr_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "mulExpr"


	public static class addExpr_return extends ParserRuleReturnScope {
		public Expr result;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "addExpr"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:41:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final QLParser.addExpr_return addExpr() throws RecognitionException {
		QLParser.addExpr_return retval = new QLParser.addExpr_return();
		retval.start = input.LT(1);
		int addExpr_StartIndex = input.index();

		Object root_0 = null;

		Token op=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object op_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }

			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:42:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:42:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_mulExpr_in_addExpr253);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());

			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.mulExpr_return)lhs).result:null); }
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:42:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= 15 && LA4_0 <= 16)) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:42:48: op= ( '+' | '-' ) rhs= mulExpr
					{
					op=input.LT(1);
					if ( (input.LA(1) >= 15 && input.LA(1) <= 16) ) {
						input.consume();
						if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(op));
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mulExpr_in_addExpr271);
					rhs=mulExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());

					if ( state.backtracking==0 ) { 
					      if ((op!=null?op.getText():null).equals("+")) {
					        retval.result = new Add(retval.result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals("-")) {
					        retval.result = new Sub(retval.result, rhs);      
					      }
					    }
					}
					break;

				default :
					break loop4;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 4, addExpr_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "addExpr"


	public static class relExpr_return extends ParserRuleReturnScope {
		public Expr result;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "relExpr"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:53:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final QLParser.relExpr_return relExpr() throws RecognitionException {
		QLParser.relExpr_return retval = new QLParser.relExpr_return();
		retval.start = input.LT(1);
		int relExpr_StartIndex = input.index();

		Object root_0 = null;

		Token op=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object op_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }

			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:54:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:54:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_addExpr_in_relExpr306);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());

			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.addExpr_return)lhs).result:null); }
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:54:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==10||(LA5_0 >= 18 && LA5_0 <= 22)) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:54:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==10||(input.LA(1) >= 18 && input.LA(1) <= 22) ) {
						input.consume();
						if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(op));
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_relExpr330);
					rhs=addExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());

					if ( state.backtracking==0 ) { 
					      if ((op!=null?op.getText():null).equals("<")) {
					        retval.result = new LT(retval.result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals("<=")) {
					        retval.result = new LEq(retval.result, rhs);      
					      }
					      if ((op!=null?op.getText():null).equals(">")) {
					        retval.result = new GT(retval.result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals(">=")) {
					        retval.result = new GEq(retval.result, rhs);      
					      }
					      if ((op!=null?op.getText():null).equals("==")) {
					        retval.result = new Eq(retval.result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals("!=")) {
					        retval.result = new NEq(retval.result, rhs);
					      }
					    }
					}
					break;

				default :
					break loop5;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 5, relExpr_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "relExpr"


	public static class andExpr_return extends ParserRuleReturnScope {
		public Expr result;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "andExpr"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:77:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final QLParser.andExpr_return andExpr() throws RecognitionException {
		QLParser.andExpr_return retval = new QLParser.andExpr_return();
		retval.start = input.LT(1);
		int andExpr_StartIndex = input.index();

		Object root_0 = null;

		Token string_literal8=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object string_literal8_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }

			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:78:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:78:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_relExpr_in_andExpr368);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());

			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.relExpr_return)lhs).result:null); }
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:78:46: ( '&&' rhs= relExpr )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==11) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:78:48: '&&' rhs= relExpr
					{
					string_literal8=(Token)match(input,11,FOLLOW_11_in_andExpr374); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal8_tree = (Object)adaptor.create(string_literal8);
					adaptor.addChild(root_0, string_literal8_tree);
					}

					pushFollow(FOLLOW_relExpr_in_andExpr378);
					rhs=relExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());

					if ( state.backtracking==0 ) { retval.result = new And(retval.result, rhs); }
					}
					break;

				default :
					break loop6;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 6, andExpr_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "andExpr"


	public static class orExpr_return extends ParserRuleReturnScope {
		public Expr result;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "orExpr"
	// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:82:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final QLParser.orExpr_return orExpr() throws RecognitionException {
		QLParser.orExpr_return retval = new QLParser.orExpr_return();
		retval.start = input.LT(1);
		int orExpr_StartIndex = input.index();

		Object root_0 = null;

		Token string_literal9=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object string_literal9_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }

			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:83:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:83:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_andExpr_in_orExpr413);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());

			if ( state.backtracking==0 ) { retval.result = (lhs!=null?((QLParser.andExpr_return)lhs).result:null); }
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:83:48: ( '||' rhs= andExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==23) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:83:50: '||' rhs= andExpr
					{
					string_literal9=(Token)match(input,23,FOLLOW_23_in_orExpr419); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal9_tree = (Object)adaptor.create(string_literal9);
					adaptor.addChild(root_0, string_literal9_tree);
					}

					pushFollow(FOLLOW_andExpr_in_orExpr423);
					rhs=andExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());

					if ( state.backtracking==0 ) { retval.result = new Or(retval.result, rhs); }
					}
					break;

				default :
					break loop7;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 7, orExpr_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "orExpr"

	// Delegated rules



	public static final BitSet FOLLOW_Int_in_primary58 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary68 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_primary76 = new BitSet(new long[]{0x0000000000019260L});
	public static final BitSet FOLLOW_orExpr_in_primary80 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_primary82 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_15_in_unExpr107 = new BitSet(new long[]{0x0000000000019260L});
	public static final BitSet FOLLOW_unExpr_in_unExpr111 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_16_in_unExpr122 = new BitSet(new long[]{0x0000000000019260L});
	public static final BitSet FOLLOW_unExpr_in_unExpr126 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_9_in_unExpr137 = new BitSet(new long[]{0x0000000000019260L});
	public static final BitSet FOLLOW_unExpr_in_unExpr141 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr154 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr192 = new BitSet(new long[]{0x0000000000024002L});
	public static final BitSet FOLLOW_set_in_mulExpr200 = new BitSet(new long[]{0x0000000000019260L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr212 = new BitSet(new long[]{0x0000000000024002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr253 = new BitSet(new long[]{0x0000000000018002L});
	public static final BitSet FOLLOW_set_in_addExpr261 = new BitSet(new long[]{0x0000000000019260L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr271 = new BitSet(new long[]{0x0000000000018002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr306 = new BitSet(new long[]{0x00000000007C0402L});
	public static final BitSet FOLLOW_set_in_relExpr314 = new BitSet(new long[]{0x0000000000019260L});
	public static final BitSet FOLLOW_addExpr_in_relExpr330 = new BitSet(new long[]{0x00000000007C0402L});
	public static final BitSet FOLLOW_relExpr_in_andExpr368 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_11_in_andExpr374 = new BitSet(new long[]{0x0000000000019260L});
	public static final BitSet FOLLOW_relExpr_in_andExpr378 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_andExpr_in_orExpr413 = new BitSet(new long[]{0x0000000000800002L});
	public static final BitSet FOLLOW_23_in_orExpr419 = new BitSet(new long[]{0x0000000000019260L});
	public static final BitSet FOLLOW_andExpr_in_orExpr423 = new BitSet(new long[]{0x0000000000800002L});
}
