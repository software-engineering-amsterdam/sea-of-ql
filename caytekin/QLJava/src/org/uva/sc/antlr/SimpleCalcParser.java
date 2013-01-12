package org.uva.sc.antlr;

// $ANTLR 3.5 C:\\Users\\caytekin\\Downloads\\ANTLR\\grammars\\SimpleCalc.g 2013-01-11 13:52:34

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

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

	@Override public String[] getTokenNames() { return SimpleCalcParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\caytekin\\Downloads\\ANTLR\\grammars\\SimpleCalc.g"; }



	// $ANTLR start "expr"
	// C:\\Users\\caytekin\\Downloads\\ANTLR\\grammars\\SimpleCalc.g:10:1: expr : term ( ( PLUS | MINUS ) term )* ;
	public final void expr() throws RecognitionException {
		try {
			// C:\\Users\\caytekin\\Downloads\\ANTLR\\grammars\\SimpleCalc.g:10:9: ( term ( ( PLUS | MINUS ) term )* )
			// C:\\Users\\caytekin\\Downloads\\ANTLR\\grammars\\SimpleCalc.g:10:11: term ( ( PLUS | MINUS ) term )*
			{
			pushFollow(FOLLOW_term_in_expr75);
			term();
			state._fsp--;

			// C:\\Users\\caytekin\\Downloads\\ANTLR\\grammars\\SimpleCalc.g:10:16: ( ( PLUS | MINUS ) term )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==MINUS||LA1_0==PLUS) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\caytekin\\Downloads\\ANTLR\\grammars\\SimpleCalc.g:10:18: ( PLUS | MINUS ) term
					{
					if ( input.LA(1)==MINUS||input.LA(1)==PLUS ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_term_in_expr90);
					term();
					state._fsp--;

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
		}
	}
	// $ANTLR end "expr"



	// $ANTLR start "term"
	// C:\\Users\\caytekin\\Downloads\\ANTLR\\grammars\\SimpleCalc.g:12:1: term : factor ( ( MULT | DIV ) factor )* ;
	public final void term() throws RecognitionException {
		try {
			// C:\\Users\\caytekin\\Downloads\\ANTLR\\grammars\\SimpleCalc.g:12:9: ( factor ( ( MULT | DIV ) factor )* )
			// C:\\Users\\caytekin\\Downloads\\ANTLR\\grammars\\SimpleCalc.g:12:11: factor ( ( MULT | DIV ) factor )*
			{
			pushFollow(FOLLOW_factor_in_term106);
			factor();
			state._fsp--;

			// C:\\Users\\caytekin\\Downloads\\ANTLR\\grammars\\SimpleCalc.g:12:18: ( ( MULT | DIV ) factor )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==DIV||LA2_0==MULT) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// C:\\Users\\caytekin\\Downloads\\ANTLR\\grammars\\SimpleCalc.g:12:20: ( MULT | DIV ) factor
					{
					if ( input.LA(1)==DIV||input.LA(1)==MULT ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_factor_in_term120);
					factor();
					state._fsp--;

					}
					break;

				default :
					break loop2;
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
		}
	}
	// $ANTLR end "term"



	// $ANTLR start "factor"
	// C:\\Users\\caytekin\\Downloads\\ANTLR\\grammars\\SimpleCalc.g:14:1: factor : NUMBER ;
	public final void factor() throws RecognitionException {
		try {
			// C:\\Users\\caytekin\\Downloads\\ANTLR\\grammars\\SimpleCalc.g:14:9: ( NUMBER )
			// C:\\Users\\caytekin\\Downloads\\ANTLR\\grammars\\SimpleCalc.g:14:11: NUMBER
			{
			match(input,NUMBER,FOLLOW_NUMBER_in_factor134); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "factor"

	// Delegated rules



	public static final BitSet FOLLOW_term_in_expr75 = new BitSet(new long[]{0x0000000000000242L});
	public static final BitSet FOLLOW_set_in_expr79 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_term_in_expr90 = new BitSet(new long[]{0x0000000000000242L});
	public static final BitSet FOLLOW_factor_in_term106 = new BitSet(new long[]{0x00000000000000A2L});
	public static final BitSet FOLLOW_set_in_term110 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_factor_in_term120 = new BitSet(new long[]{0x00000000000000A2L});
	public static final BitSet FOLLOW_NUMBER_in_factor134 = new BitSet(new long[]{0x0000000000000002L});
}
