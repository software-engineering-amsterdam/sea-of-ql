// $ANTLR !Unknown version! QL.g 2013-01-18 19:56:35

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.operations.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class QLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "INT", "BOOL", "STRING", "IDENT", "WS", "COMMENT", "'('", "')'", "'+'", "'-'", "'!'", "'*'", "'/'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'&&'", "'||'"
    };
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int BOOL=5;
    public static final int INT=4;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int WS=8;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__10=10;
    public static final int IDENT=7;
    public static final int COMMENT=9;
    public static final int STRING=6;

    // delegates
    // delegators


        public QLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public QLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[26+1];
             
             
        }
        

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "QL.g"; }



    // $ANTLR start "primary"
    // QL.g:18:1: primary returns [Expr result] : ( INT | BOOL | STRING | IDENT | '(' x= orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;
        int primary_StartIndex = input.index();
        Token INT1=null;
        Token BOOL2=null;
        Token STRING3=null;
        Token IDENT4=null;
        Expr x = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }
            // QL.g:19:3: ( INT | BOOL | STRING | IDENT | '(' x= orExpr ')' )
            int alt1=5;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt1=1;
                }
                break;
            case BOOL:
                {
                alt1=2;
                }
                break;
            case STRING:
                {
                alt1=3;
                }
                break;
            case IDENT:
                {
                alt1=4;
                }
                break;
            case 10:
                {
                alt1=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // QL.g:19:5: INT
                    {
                    INT1=(Token)match(input,INT,FOLLOW_INT_in_primary46); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new Int(Integer.parseInt((INT1!=null?INT1.getText():null))); 
                    }

                    }
                    break;
                case 2 :
                    // QL.g:20:5: BOOL
                    {
                    BOOL2=(Token)match(input,BOOL,FOLLOW_BOOL_in_primary57); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new Bool(Boolean.parseBoolean((BOOL2!=null?BOOL2.getText():null))); 
                    }

                    }
                    break;
                case 3 :
                    // QL.g:21:5: STRING
                    {
                    STRING3=(Token)match(input,STRING,FOLLOW_STRING_in_primary67); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new QLString((STRING3!=null?STRING3.getText():null)); 
                    }

                    }
                    break;
                case 4 :
                    // QL.g:22:5: IDENT
                    {
                    IDENT4=(Token)match(input,IDENT,FOLLOW_IDENT_in_primary75); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new Ident((IDENT4!=null?IDENT4.getText():null)); 
                    }

                    }
                    break;
                case 5 :
                    // QL.g:23:5: '(' x= orExpr ')'
                    {
                    match(input,10,FOLLOW_10_in_primary84); if (state.failed) return result;
                    pushFollow(FOLLOW_orExpr_in_primary88);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;
                    match(input,11,FOLLOW_11_in_primary90); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = x; 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 1, primary_StartIndex); }
        }
        return result;
    }
    // $ANTLR end "primary"


    // $ANTLR start "unExpr"
    // QL.g:26:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr | x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;
        int unExpr_StartIndex = input.index();
        Expr x = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }
            // QL.g:27:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr | x= primary )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt2=1;
                }
                break;
            case 13:
                {
                alt2=2;
                }
                break;
            case 14:
                {
                alt2=3;
                }
                break;
            case INT:
            case BOOL:
            case STRING:
            case IDENT:
            case 10:
                {
                alt2=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // QL.g:27:8: '+' x= unExpr
                    {
                    match(input,12,FOLLOW_12_in_unExpr115); if (state.failed) return result;
                    pushFollow(FOLLOW_unExpr_in_unExpr119);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new Pos(x); 
                    }

                    }
                    break;
                case 2 :
                    // QL.g:28:8: '-' x= unExpr
                    {
                    match(input,13,FOLLOW_13_in_unExpr130); if (state.failed) return result;
                    pushFollow(FOLLOW_unExpr_in_unExpr134);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new Neg(x); 
                    }

                    }
                    break;
                case 3 :
                    // QL.g:29:8: '!' x= unExpr
                    {
                    match(input,14,FOLLOW_14_in_unExpr145); if (state.failed) return result;
                    pushFollow(FOLLOW_unExpr_in_unExpr149);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = new Not(x); 
                    }

                    }
                    break;
                case 4 :
                    // QL.g:30:8: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr162);
                    x=primary();

                    state._fsp--;
                    if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = x; 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 2, unExpr_StartIndex); }
        }
        return result;
    }
    // $ANTLR end "unExpr"


    // $ANTLR start "mulExpr"
    // QL.g:33:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;
        int mulExpr_StartIndex = input.index();
        Token op=null;
        Expr lhs = null;

        Expr rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }
            // QL.g:34:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // QL.g:34:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr200);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;
            if ( state.backtracking==0 ) {
               result =lhs; 
            }
            // QL.g:34:45: (op= ( '*' | '/' ) rhs= unExpr )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=15 && LA3_0<=16)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // QL.g:34:47: op= ( '*' | '/' ) rhs= unExpr
            	    {
            	    op=(Token)input.LT(1);
            	    if ( (input.LA(1)>=15 && input.LA(1)<=16) ) {
            	        input.consume();
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_unExpr_in_mulExpr220);
            	    rhs=unExpr();

            	    state._fsp--;
            	    if (state.failed) return result;
            	    if ( state.backtracking==0 ) {
            	       
            	            if ((op!=null?op.getText():null).equals("*")) {
            	              result = new Mul(result, rhs);
            	            }
            	            if ((op!=null?op.getText():null).equals("<=")) {
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
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, mulExpr_StartIndex); }
        }
        return result;
    }
    // $ANTLR end "mulExpr"


    // $ANTLR start "addExpr"
    // QL.g:46:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;
        int addExpr_StartIndex = input.index();
        Token op=null;
        Expr lhs = null;

        Expr rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }
            // QL.g:47:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // QL.g:47:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr261);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;
            if ( state.backtracking==0 ) {
               result =lhs; 
            }
            // QL.g:47:46: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=12 && LA4_0<=13)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // QL.g:47:48: op= ( '+' | '-' ) rhs= mulExpr
            	    {
            	    op=(Token)input.LT(1);
            	    if ( (input.LA(1)>=12 && input.LA(1)<=13) ) {
            	        input.consume();
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_mulExpr_in_addExpr279);
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
            	    break loop4;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 4, addExpr_StartIndex); }
        }
        return result;
    }
    // $ANTLR end "addExpr"


    // $ANTLR start "relExpr"
    // QL.g:58:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;
        int relExpr_StartIndex = input.index();
        Token op=null;
        Expr lhs = null;

        Expr rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }
            // QL.g:59:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // QL.g:59:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr314);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;
            if ( state.backtracking==0 ) {
               result =lhs; 
            }
            // QL.g:59:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=17 && LA5_0<=22)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // QL.g:59:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
            	    {
            	    op=(Token)input.LT(1);
            	    if ( (input.LA(1)>=17 && input.LA(1)<=22) ) {
            	        input.consume();
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_addExpr_in_relExpr338);
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
            	    break loop5;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, relExpr_StartIndex); }
        }
        return result;
    }
    // $ANTLR end "relExpr"


    // $ANTLR start "andExpr"
    // QL.g:82:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;
        int andExpr_StartIndex = input.index();
        Expr lhs = null;

        Expr rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }
            // QL.g:83:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // QL.g:83:9: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr376);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;
            if ( state.backtracking==0 ) {
               result =lhs; 
            }
            // QL.g:83:46: ( '&&' rhs= relExpr )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==23) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // QL.g:83:48: '&&' rhs= relExpr
            	    {
            	    match(input,23,FOLLOW_23_in_andExpr382); if (state.failed) return result;
            	    pushFollow(FOLLOW_relExpr_in_andExpr386);
            	    rhs=relExpr();

            	    state._fsp--;
            	    if (state.failed) return result;
            	    if ( state.backtracking==0 ) {
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
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, andExpr_StartIndex); }
        }
        return result;
    }
    // $ANTLR end "andExpr"


    // $ANTLR start "orExpr"
    // QL.g:87:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;
        int orExpr_StartIndex = input.index();
        Expr lhs = null;

        Expr rhs = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }
            // QL.g:88:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // QL.g:88:9: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr421);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;
            if ( state.backtracking==0 ) {
               result = lhs; 
            }
            // QL.g:88:48: ( '||' rhs= andExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==24) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // QL.g:88:50: '||' rhs= andExpr
            	    {
            	    match(input,24,FOLLOW_24_in_orExpr427); if (state.failed) return result;
            	    pushFollow(FOLLOW_andExpr_in_orExpr431);
            	    rhs=andExpr();

            	    state._fsp--;
            	    if (state.failed) return result;
            	    if ( state.backtracking==0 ) {
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
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, orExpr_StartIndex); }
        }
        return result;
    }
    // $ANTLR end "orExpr"

    // Delegated rules


 

    public static final BitSet FOLLOW_INT_in_primary46 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_primary57 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_primary67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_primary75 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_primary84 = new BitSet(new long[]{0x00000000000074F0L});
    public static final BitSet FOLLOW_orExpr_in_primary88 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_primary90 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_unExpr115 = new BitSet(new long[]{0x00000000000074F0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_unExpr130 = new BitSet(new long[]{0x00000000000074F0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_unExpr145 = new BitSet(new long[]{0x00000000000074F0L});
    public static final BitSet FOLLOW_unExpr_in_unExpr149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr200 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_set_in_mulExpr208 = new BitSet(new long[]{0x00000000000074F0L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr220 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr261 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_set_in_addExpr269 = new BitSet(new long[]{0x00000000000074F0L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr279 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr314 = new BitSet(new long[]{0x00000000007E0002L});
    public static final BitSet FOLLOW_set_in_relExpr322 = new BitSet(new long[]{0x00000000000074F0L});
    public static final BitSet FOLLOW_addExpr_in_relExpr338 = new BitSet(new long[]{0x00000000007E0002L});
    public static final BitSet FOLLOW_relExpr_in_andExpr376 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_andExpr382 = new BitSet(new long[]{0x00000000000074F0L});
    public static final BitSet FOLLOW_relExpr_in_andExpr386 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr421 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_orExpr427 = new BitSet(new long[]{0x00000000000074F0L});
    public static final BitSet FOLLOW_andExpr_in_orExpr431 = new BitSet(new long[]{0x0000000001000002L});

}