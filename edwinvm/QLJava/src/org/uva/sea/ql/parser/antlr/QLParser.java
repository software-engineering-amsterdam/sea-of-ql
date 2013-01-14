package org.uva.sea.ql.parser.antlr;

import org.antlr.runtime.*;
import org.uva.sea.ql.ast.*;

import java.util.Map;
import java.util.List;
import java.util.Stack;
import java.util.HashMap;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLParser extends Parser {
    public static final String[] _TOKEN_NAMES = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "Ident", "Int", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "'<'", "'<='", "'=='", "'>'", "'>='", "'||'"
    };

    public static final int _EOF = -1;
    public static final int _T__8 = 8;
    public static final int _T__9 = 9;
    public static final int _T__10 = 10;
    public static final int _T__11 = 11;
    public static final int _T__12 = 12;
    public static final int _T__13 = 13;
    public static final int _T__14 = 14;
    public static final int _T__15 = 15;
    public static final int _T__16 = 16;
    public static final int _T__17 = 17;
    public static final int _T__18 = 18;
    public static final int _T__19 = 19;
    public static final int _T__20 = 20;
    public static final int _T__21 = 21;
    public static final int _T__22 = 22;
    public static final int _COMMENT = 4;
    public static final int _IDENT = 5;
    public static final int _INT = 6;
    public static final int _WS = 7;
    
    public static final BitSet _FOLLOW_Int_in_primary46      = new BitSet(new long[] { 0x0000000000000002L });
    public static final BitSet _FOLLOW_Ident_in_primary56    = new BitSet(new long[] { 0x0000000000000002L });
    public static final BitSet _FOLLOW_11_in_primary64       = new BitSet(new long[] { 0x000000000000C960L });
    public static final BitSet _FOLLOW_orExpr_in_primary68   = new BitSet(new long[] { 0x0000000000001000L });
    public static final BitSet _FOLLOW_12_in_primary70       = new BitSet(new long[] { 0x0000000000000002L });
    public static final BitSet _FOLLOW_14_in_unExpr95        = new BitSet(new long[] { 0x000000000000C960L });
    public static final BitSet _FOLLOW_unExpr_in_unExpr99    = new BitSet(new long[] { 0x0000000000000002L });
    public static final BitSet _FOLLOW_15_in_unExpr110       = new BitSet(new long[] { 0x000000000000C960L });
    public static final BitSet _FOLLOW_unExpr_in_unExpr114   = new BitSet(new long[] { 0x0000000000000002L });
    public static final BitSet _FOLLOW_8_in_unExpr125        = new BitSet(new long[] { 0x000000000000C960L });
    public static final BitSet _FOLLOW_unExpr_in_unExpr129   = new BitSet(new long[] { 0x0000000000000002L });
    public static final BitSet _FOLLOW_primary_in_unExpr142  = new BitSet(new long[] { 0x0000000000000002L });
    public static final BitSet _FOLLOW_unExpr_in_mulExpr180  = new BitSet(new long[] { 0x0000000000012002L });
    public static final BitSet _FOLLOW_set_in_mulExpr188     = new BitSet(new long[] { 0x000000000000C960L });
    public static final BitSet _FOLLOW_unExpr_in_mulExpr200  = new BitSet(new long[] { 0x0000000000012002L });
    public static final BitSet _FOLLOW_mulExpr_in_addExpr241 = new BitSet(new long[] { 0x000000000000C002L });
    public static final BitSet _FOLLOW_set_in_addExpr249     = new BitSet(new long[] { 0x000000000000C960L });
    public static final BitSet _FOLLOW_mulExpr_in_addExpr259 = new BitSet(new long[] { 0x000000000000C002L });
    public static final BitSet _FOLLOW_addExpr_in_relExpr294 = new BitSet(new long[] { 0x00000000003E0202L });
    public static final BitSet _FOLLOW_set_in_relExpr302     = new BitSet(new long[] { 0x000000000000C960L });
    public static final BitSet _FOLLOW_addExpr_in_relExpr318 = new BitSet(new long[] { 0x00000000003E0202L });
    public static final BitSet _FOLLOW_relExpr_in_andExpr356 = new BitSet(new long[] { 0x0000000000000402L });
    public static final BitSet _FOLLOW_10_in_andExpr362      = new BitSet(new long[] { 0x000000000000C960L });
    public static final BitSet _FOLLOW_relExpr_in_andExpr366 = new BitSet(new long[] { 0x0000000000000402L });
    public static final BitSet _FOLLOW_andExpr_in_orExpr401  = new BitSet(new long[] { 0x0000000000400002L });
    public static final BitSet _FOLLOW_22_in_orExpr407       = new BitSet(new long[] { 0x000000000000C960L });
    public static final BitSet _FOLLOW_andExpr_in_orExpr411  = new BitSet(new long[] { 0x0000000000400002L });

    // Delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    public QLParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    
    public QLParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.ruleMemo = new HashMap[24+1];
    }

    public String[] getTokenNames() { 
    	return QLParser._TOKEN_NAMES; 
    }
    
    public String getGrammarFileName() { 
    	return "/Users/tvdstorm/SEA/courses/sc/2012-2013/repos/sc-ql-2012-2013-java/src/org/uva/sea/ql/parser/antlr/QL.g"; 
    }

    // $ANTLR start "primary"
    // primary returns [Expr result] : ( Int | Ident | '(' x = orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;
        int primaryStartIndex = input.index();

        Expr x = null;
        Token int1, ident2 = null;

        try {
            if (state.backtracking > 0 && alreadyParsedRule(input, 1)) { 
            	return result; 
            }

            // ( Int | Ident | '(' x= orExpr ')' )
            int alt1 = 3;
            switch (input.LA(1)) {
	            case _INT:
	                {
	                	alt1 = 1;
	                }
	                break;
	            case _IDENT:
	                {
	                	alt1 = 2;
	                }
	                break;
	            case 11:
	                {
	                	alt1 = 3;
	                }
	                break;
	            default:
	                if (state.backtracking > 0) {
	                	state.failed = true; 
	                	return result;
	                }
	                NoViableAltException nvae = new NoViableAltException("", 1, 0, input);
	                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // _INT
                    {
                    	int1 = (Token)match(input, _INT, _FOLLOW_Int_in_primary46); 
                    	
                    	if (state.failed) { 
                    		return result;
                    	}

	                    if (state.backtracking == 0) { 
	                    	result = new Int(Integer.parseInt(int1 != null ? int1.getText() : null)); 
	                    }
                    }
                    break;
                case 2 :
                    // _IDENT
                    {
	                    ident2 = (Token)match(input, _IDENT, _FOLLOW_Ident_in_primary56); 
	                    
	                    if (state.failed) { 
	                    	return result;
	                    }
	
	                    if (state.backtracking == 0) { 
	                    	result = new Ident(ident2 != null ? ident2.getText() : null); 
	                    }
                    }
                    break;
                case 3 :
                    // '(' x = orExpr ')'
                    {
	                    match(input, 11, _FOLLOW_11_in_primary64); 
	                    
	                    if (state.failed) { 
	                    	return result;
	                    }
	
	                    pushFollow(_FOLLOW_orExpr_in_primary68);
	                    x = orExpr();
	
	                    state._fsp--;
	                    if (state.failed) { 
	                    	return result;
	                    }
	
	                    match(input, 12, _FOLLOW_12_in_primary70); 
	                    
	                    if (state.failed) { 
	                    	return result;
	                    }
	
	                    if (state.backtracking == 0) { 
	                    	result = x; 
	                    }
                    }
                    break;
                default:
                	break;
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        }
        finally {
        	// do for sure before leaving
            if (state.backtracking > 0) { 
            	memoize(input, 1, primaryStartIndex); 
        	}
        }
        return result;
    }
    // $ANTLR end "primary"

    // $ANTLR start "unExpr"
    // unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;
        int unExprStartIndex = input.index();

        Expr x = null;
        try {
            if (state.backtracking > 0 && alreadyParsedRule(input, 2)) { 
            	return result; 
            }

            // ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
            int alt2 = 4;
            switch (input.LA(1)) {
	            case 14:
	                {
	                	alt2 = 1;
	                }
	                break;
	            case 15:
	                {
	                	alt2 = 2;
	                }
	                break;
	            case 8:
	                {
	                	alt2 = 3;
	                }
	                break;
	            case _IDENT:
	            case _INT:
	            case 11:
	                {
	                	alt2 = 4;
	                }
	                break;
	            default:
	                if (state.backtracking > 0) {
	                	state.failed = true; 
	                	return result;
	                }
	                NoViableAltException nvae = new NoViableAltException("", 2, 0, input);
	                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // '+' x = unExpr
                    {
	                    match(input, 14, _FOLLOW_14_in_unExpr95); 
	                    
	                    if (state.failed) { 
	                    	return result;
	                    }
	
	                    pushFollow(_FOLLOW_unExpr_in_unExpr99);
	                    x = unExpr();
	
	                    state._fsp--;
	                    if (state.failed) { 
	                    	return result;
	                    }
	
	                    if (state.backtracking == 0) { 
	                    	result = new Pos(x); 
	                    }
                    }
                    break;
                case 2 :
                    // '-' x = unExpr
                    {
	                    match(input, 15, _FOLLOW_15_in_unExpr110); 
	                    
	                    if (state.failed) { 
	                    	return result;
	                    }
	
	                    pushFollow(_FOLLOW_unExpr_in_unExpr114);
	                    x = unExpr();
	
	                    state._fsp--;
	                    if (state.failed) { 
	                    	return result;
	                    }
	
	                    if (state.backtracking == 0) { 
	                    	result = new Neg(x); 
                    	}
                    }
                    break;
                case 3 :
                    // '!' x= unExpr
                    {
	                    match(input, 8, _FOLLOW_8_in_unExpr125); 
	                    
	                    if (state.failed) { 
	                    	return result;
	                    }
	
	                    pushFollow(_FOLLOW_unExpr_in_unExpr129);
	                    x = unExpr();
	
	                    state._fsp--;
	                    if (state.failed) { 
	                    	return result;
	                    }
	
	                    if (state.backtracking == 0) { 
	                    	result = new Not(x);
                    	}
                    }
                    break;
                case 4 :
                    // x = primary
                    {
	                    pushFollow(_FOLLOW_primary_in_unExpr142);
	                    x = primary();
	
	                    state._fsp--;
	                    if (state.failed) { 
	                    	return result;
	                    }
	
	                    if (state.backtracking == 0) { 
	                    	result = x; 
	                    }
                    }
                    break;
                default:
                	break;
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        }
        finally {
        	// do for sure before leaving
            if (state.backtracking > 0) { 
            	memoize(input, 2, unExprStartIndex); 
        	}
        }
        return result;
    }
    // $ANTLR end "unExpr"

    // $ANTLR start "mulExpr"
    // mulExpr returns [Expr result] : lhs = unExpr (op = ( '*' | '/' ) rhs = unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;
        int mulExprStartIndex = input.index();

        Token op = null;
        Expr lhs, rhs = null;
        try {
            if (state.backtracking > 0 && alreadyParsedRule(input, 3)) { 
            	return result; 
            }

            // (lhs = unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            {
	            pushFollow(_FOLLOW_unExpr_in_mulExpr180);
	            lhs = unExpr();
	
	            state._fsp--;
	            if (state.failed) { 
	            	return result;
	            }
	
	            if (state.backtracking == 0) { 
	            	result = lhs; 
	            }
	
	            // (op = ( '*' | '/' ) rhs = unExpr )*
	            loop3:
	            do {
	            	int alt3 = 2;
	                int lA3_0 = input.LA(1);
	
	                if (lA3_0 == 13 || lA3_0 == 16) {
	                    alt3 = 1;
	                }
		
	                switch (alt3) {
		            	case 1 :
		            	    // op = ( '*' | '/' ) rhs = unExpr
		            	    {
			            	    op = (Token)input.LT(1);
			
			            	    if (input.LA(1) == 13 || input.LA(1) == 16) {
			            	        input.consume();
			            	        state.errorRecovery = false;
			            	        state.failed = false;
			            	    } else {
			            	        if (state.backtracking > 0) {
			            	        	state.failed = true; 
			            	        	return result;
			            	        }
			            	        MismatchedSetException mse = new MismatchedSetException(null, input);
			            	        throw mse;
			            	    }

			            	    pushFollow(_FOLLOW_unExpr_in_mulExpr200);
			            	    rhs = unExpr();
			
			            	    state._fsp--;
			            	    if (state.failed) { 
			            	    	return result;
			            	    }
			
			            	    if (state.backtracking == 0) { 
									if ((op != null ? op.getText() : null).equals("*")) {
										result = new Mul(result, rhs);
									}
									if ((op != null ? op.getText() : null).equals("<=")) {
										result = new Div(result, rhs);      
									}
								}
		            	    }
		            	    break;
		            	default :
		            	    break loop3;
	                }
	            } while (true);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        }
        finally {
        	// do for sure before leaving
            if (state.backtracking > 0) { 
            	memoize(input, 3, mulExprStartIndex); 
            }
        }
        return result;
    }
    // $ANTLR end "mulExpr"

    // $ANTLR start "addExpr"
    // addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;
        int addExprStartIndex = input.index();

        Token op = null;
        Expr lhs, rhs = null;
        try {
            if (state.backtracking > 0 && alreadyParsedRule(input, 4)) { 
            	return result; 
            }

            // ( lhs = mulExpr (op= ( '+' | '-' ) rhs = mulExpr )* )
            {
	            pushFollow(_FOLLOW_mulExpr_in_addExpr241);
	            lhs = mulExpr();
	
	            state._fsp--;
	            if (state.failed) { 
	            	return result;
	            }
	
	            if (state.backtracking == 0) { 
	            	result = lhs; 
	            }
	
	            // ( op = ( '+' | '-' ) rhs= mulExpr )*
	            loop4:
	            do {
	                int alt4 = 2;
	                int lA4_0 = input.LA(1);
	
	                if (lA4_0 >= 14 && lA4_0 <= 15) {
	                    alt4 = 1;
	                }
		
	                switch (alt4) {
	            	case 1 :
	            	    // op = ( '+' | '-' ) rhs = mulExpr
	            	    {
		            	    op = (Token)input.LT(1);
		
		            	    if (input.LA(1) >= 14 && input.LA(1) <= 15) {
		            	        input.consume();
		            	        state.errorRecovery = false;
		            	        state.failed = false;
		            	    } else {
		            	        if (state.backtracking > 0) {
		            	        	state.failed = true;
		            	        	return result;
		            	        }
		            	        MismatchedSetException mse = new MismatchedSetException(null, input);
		            	        throw mse;
		            	    }
				
		            	    pushFollow(_FOLLOW_mulExpr_in_addExpr259);
		            	    rhs = mulExpr();
		
		            	    state._fsp--;
		            	    if (state.failed) { 
		            	    	return result;
		            	    }
		
		            	    if (state.backtracking == 0) { 
								if ((op != null ? op.getText() : null).equals("+")) {
									result = new Add(result, rhs);
								}
								if ((op != null ? op.getText() : null).equals("-")) {
									result = new Sub(result, rhs);
								}
	            	        }
	            	    }
	            	    break;
	            	default :
	            	    break loop4;
	                }
	            } while (true);
            }
        } 
        catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        }
        finally {
        	// do for sure before leaving
            if (state.backtracking > 0) { 
            	memoize(input, 4, addExprStartIndex); 
            }
        }
        return result;
    }
    // $ANTLR end "addExpr"

    // $ANTLR start "relExpr"
    // relExpr returns [Expr result] : lhs = addExpr (op = ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs = addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;
        int relExprStartIndex = input.index();

        Token op = null;
        Expr lhs, rhs = null;
        try {
            if (state.backtracking > 0 && alreadyParsedRule(input, 5)) { 
            	return result; 
            }

            // ( lhs = addExpr (op = ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs = addExpr )* )
            {
	            pushFollow(_FOLLOW_addExpr_in_relExpr294);
	            lhs = addExpr();
	
	            state._fsp--;
	            if (state.failed) { 
	            	return result;
	            }
	
	            if (state.backtracking == 0) { 
	            	result = lhs; 
	            }
	
	            // (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs = addExpr )*
	            loop5:
	            do {
	                int alt5 = 2;
	                int lA5_0 = input.LA(1);
	
	                if (lA5_0 == 9 || (lA5_0 >= 17 && lA5_0 <= 21)) {
	                    alt5 = 1;
	                }
	
	                switch (alt5) {
	            	case 1 :
	            	    // op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs = addExpr
	            	    {
		            	    op = (Token)input.LT(1);
		
		            	    if (input.LA(1) == 9 || (input.LA(1) >= 17 && input.LA(1) <= 21)) {
		            	        input.consume();
		            	        state.errorRecovery = false;
		            	        state.failed = false;
		            	    } else {
		            	        if (state.backtracking > 0) {
		            	        	state.failed = true; 
		            	        	return result;
		            	        }
		            	        MismatchedSetException mse = new MismatchedSetException(null, input);
		            	        throw mse;
		            	    }
		
		            	    pushFollow(_FOLLOW_addExpr_in_relExpr318);
		            	    rhs = addExpr();
		
		            	    state._fsp--;
		            	    if (state.failed) {
		            	    	return result;
		            	    }
		
		            	    if (state.backtracking == 0) { 
								if ((op != null ? op.getText() : null).equals("<")) {
									result = new LT(result, rhs);
								}
								if ((op != null ? op.getText() : null).equals("<=")) {
								    result = new LEq(result, rhs);      
								}
								if ((op != null ? op.getText() : null).equals(">")) {
								    result = new GT(result, rhs);
								}
								if ((op != null ? op.getText() : null).equals(">=")) {
								    result = new GEq(result, rhs);      
								}
								if ((op != null ? op.getText() : null).equals("==")) {
								    result = new Eq(result, rhs);
								}
								if ((op != null ? op.getText() : null).equals("!=")) {
								    result = new NEq(result, rhs);
								}
	            	        }
	            	    }
	            	    break;
	            	default :
	            	    break loop5;
	                }
	            } while (true);
            }
        } 
        catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        }
        finally {
        	// do for sure before leaving
            if (state.backtracking > 0) { 
            	memoize(input, 5, relExprStartIndex); 
            }
        }
        return result;
    }
    // $ANTLR end "relExpr"

    // $ANTLR start "andExpr"
    // andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;
        int andExprStartIndex = input.index();

        Expr lhs, rhs = null;
        try {
            if (state.backtracking > 0 && alreadyParsedRule(input, 6)) { 
            	return result; 
            }

            // (lhs = relExpr ( '&&' rhs= relExpr )* )
            {
	            pushFollow(_FOLLOW_relExpr_in_andExpr356);
	            lhs = relExpr();
	
	            state._fsp--;
	            if (state.failed) { 
	            	return result;
	            }
	
	            if (state.backtracking == 0) { 
	            	result = lhs; 
	            }
	
	            // ( '&&' rhs= relExpr )*
	            loop6:
	            do {
	                int alt6 = 2;
	                int lA6_0 = input.LA(1);
	
	                if (lA6_0 == 10) {
	                    alt6 = 1;
	                }
	
	                switch (alt6) {
	            	case 1 :
	            	    // '&&' rhs = relExpr
	            	    {
		            	    match(input, 10, _FOLLOW_10_in_andExpr362); 
		            	    if (state.failed) { 
		            	    	return result;
		            	    }
		
		            	    pushFollow(_FOLLOW_relExpr_in_andExpr366);
		            	    rhs = relExpr();
		
		            	    state._fsp--;
		            	    if (state.failed) {
		            	    	return result;
		            	    }
		
		            	    if (state.backtracking == 0) { 
		            	    	result = new And(result, rhs); 
		            	    }
	            	    }
	            	    break;
	            	default :
	            	    break loop6;
	                }
	            } while (true);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        }
        finally {
        	// do for sure before leaving
            if (state.backtracking > 0) { 
            	memoize(input, 6, andExprStartIndex); 
            }
        }
        return result;
    }
    // $ANTLR end "andExpr"

    // $ANTLR start "orExpr"
    // lhs = andExpr ( '||' rhs = andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;
        int orExprStartIndex = input.index();

        Expr lhs, rhs = null;
        try {
            if (state.backtracking > 0 && alreadyParsedRule(input, 7)) { 
            	return result; 
            }

            // (lhs = andExpr ( '||' rhs= andExpr )* )
            {
	            pushFollow(_FOLLOW_andExpr_in_orExpr401);
	            lhs = andExpr();
	
	            state._fsp--;
	            if (state.failed) {
	            	return result;
	            }
	
	            if (state.backtracking == 0) { 
	            	result = lhs; 
	            }
	
	            // ( '||' rhs = andExpr )*
	            loop7:
	            do {
	                int alt7 = 2;
	                int lA7_0 = input.LA(1);
	
	                if (lA7_0 == 22) {
	                    alt7 = 1;
	                }
	
	                switch (alt7) {
		            	case 1 :
		            	    // '||' rhs = andExpr
		            	    {
			            	    match(input, 22, _FOLLOW_22_in_orExpr407); 
			            	    if (state.failed) {
			            	    	return result;
			            	    }
			
			            	    pushFollow(_FOLLOW_andExpr_in_orExpr411);
			            	    rhs = andExpr();
			
			            	    state._fsp--;
			            	    if (state.failed) { 
			            	    	return result;
			            	    }
			
			            	    if (state.backtracking == 0) { 
			            	    	result = new Or(result, rhs); 
			            	    }
		            	    }
		            	    break;
		            	default :
		            	    break loop7;
	                }
	            } while (true);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        }
        finally {
        	// do for sure before leaving
            if (state.backtracking > 0) { 
            	memoize(input, 7, orExprStartIndex); 
        	}
        }
        return result;
    }
    // $ANTLR end "orExpr"

    // Delegated rules
}