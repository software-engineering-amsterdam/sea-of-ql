// $ANTLR 3.5 C:\\Users\\caytekin\\Downloads\\ANTLR\\grammars\\SimpleCalc.g 2013-01-14 14:35:32

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class SimpleCalcParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "DIGIT", "DIV", "MINUS", "MULT", 
		"NUMBER", "PLUS", "WHITESPACE"
	};
	public static final int EOF=-1;
	public static final int DIGIT=4;
	public static final int DIV=5;
	public static final int MINUS=6;
	public static final int MULT=7;
	public static final int NUMBER=8;
	public static final int PLUS=9;
	public static final int WHITESPACE=10;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public SimpleCalcParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public SimpleCalcParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return SimpleCalcParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\caytekin\\Downloads\\ANTLR\\grammars\\SimpleCalc.g"; }


	public static class expr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr"
	// C:\\Users\\caytekin\\Downloads\\ANTLR\\grammars\\SimpleCalc.g:11:1: expr : term ( ( PLUS | MINUS ) term )* ;
	public final SimpleCalcParser.expr_return expr() throws  {
		SimpleCalcParser.expr_return retval = new SimpleCalcParser.expr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set2=null;
		ParserRuleReturnScope term1 =null;
		ParserRuleReturnScope term3 =null;

		Object set2_tree=null;

		try {
			// C:\\Users\\caytekin\\Downloads\\ANTLR\\grammars\\SimpleCalc.g:11:9: ( term ( ( PLUS | MINUS ) term )* )
			// C:\\Users\\caytekin\\Downloads\\ANTLR\\grammars\\SimpleCalc.g:11:11: term ( ( PLUS | MINUS ) term )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_term_in_expr82);
			term1=term();
			state._fsp--;

			adaptor.addChild(root_0, term1.getTree());

			// C:\\Users\\caytekin\\Downloads\\ANTLR\\grammars\\SimpleCalc.g:11:16: ( ( PLUS | MINUS ) term )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==MINUS||LA1_0==PLUS) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\caytekin\\Downloads\\ANTLR\\grammars\\SimpleCalc.g:11:18: ( PLUS | MINUS ) term
					{
					set2=input.LT(1);
					if ( input.LA(1)==MINUS||input.LA(1)==PLUS ) {
						input.consume();
						adaptor.addChild(root_0, (Object)adaptor.create(set2));
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_term_in_expr97);
					term3=term();
					state._fsp--;

					adaptor.addChild(root_0, term3.getTree());

					}
					break;

				default :
					break loop1;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr"


	public static class term_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "term"
	// C:\\Users\\caytekin\\Downloads\\ANTLR\\grammars\\SimpleCalc.g:13:1: term : factor ( ( MULT | DIV ) factor )* ;
	public final SimpleCalcParser.term_return term() throws  {
		SimpleCalcParser.term_return retval = new SimpleCalcParser.term_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set5=null;
		ParserRuleReturnScope factor4 =null;
		ParserRuleReturnScope factor6 =null;

		Object set5_tree=null;

		try {
			// C:\\Users\\caytekin\\Downloads\\ANTLR\\grammars\\SimpleCalc.g:13:9: ( factor ( ( MULT | DIV ) factor )* )
			// C:\\Users\\caytekin\\Downloads\\ANTLR\\grammars\\SimpleCalc.g:13:11: factor ( ( MULT | DIV ) factor )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_factor_in_term113);
			factor4=factor();
			state._fsp--;

			adaptor.addChild(root_0, factor4.getTree());

			// C:\\Users\\caytekin\\Downloads\\ANTLR\\grammars\\SimpleCalc.g:13:18: ( ( MULT | DIV ) factor )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==DIV||LA2_0==MULT) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// C:\\Users\\caytekin\\Downloads\\ANTLR\\grammars\\SimpleCalc.g:13:20: ( MULT | DIV ) factor
					{
					set5=input.LT(1);
					if ( input.LA(1)==DIV||input.LA(1)==MULT ) {
						input.consume();
						adaptor.addChild(root_0, (Object)adaptor.create(set5));
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_factor_in_term127);
					factor6=factor();
					state._fsp--;

					adaptor.addChild(root_0, factor6.getTree());

					}
					break;

				default :
					break loop2;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "term"


	public static class factor_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "factor"
	// C:\\Users\\caytekin\\Downloads\\ANTLR\\grammars\\SimpleCalc.g:15:1: factor : NUMBER ;
	public final SimpleCalcParser.factor_return factor() throws  {
		SimpleCalcParser.factor_return retval = new SimpleCalcParser.factor_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NUMBER7=null;

		Object NUMBER7_tree=null;

		try {
			// C:\\Users\\caytekin\\Downloads\\ANTLR\\grammars\\SimpleCalc.g:15:9: ( NUMBER )
			// C:\\Users\\caytekin\\Downloads\\ANTLR\\grammars\\SimpleCalc.g:15:11: NUMBER
			{
			root_0 = (Object)adaptor.nil();


			NUMBER7=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_factor141); 
			NUMBER7_tree = (Object)adaptor.create(NUMBER7);
			adaptor.addChild(root_0, NUMBER7_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "factor"

	// Delegated rules



	public static final BitSet FOLLOW_term_in_expr82 = new BitSet(new long[]{0x0000000000000242L});
	public static final BitSet FOLLOW_set_in_expr86 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_term_in_expr97 = new BitSet(new long[]{0x0000000000000242L});
	public static final BitSet FOLLOW_factor_in_term113 = new BitSet(new long[]{0x00000000000000A2L});
	public static final BitSet FOLLOW_set_in_term117 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_factor_in_term127 = new BitSet(new long[]{0x00000000000000A2L});
	public static final BitSet FOLLOW_NUMBER_in_factor141 = new BitSet(new long[]{0x0000000000000002L});
}
