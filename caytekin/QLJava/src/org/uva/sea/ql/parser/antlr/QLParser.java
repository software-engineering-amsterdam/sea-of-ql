// $ANTLR 3.4 C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-18 14:27:22

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BooleanType", "COMMENT", "ElseRW", "FalseRW", "Ident", "IfRW", "Int", "IntegerType", "SINGLE_LINE_COMMENT", "StringLiteral", "StringType", "ThenRW", "TrueRW", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'||'"
    };

    public static final int EOF=-1;
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
    public static final int BooleanType=4;
    public static final int COMMENT=5;
    public static final int ElseRW=6;
    public static final int FalseRW=7;
    public static final int Ident=8;
    public static final int IfRW=9;
    public static final int Int=10;
    public static final int IntegerType=11;
    public static final int SINGLE_LINE_COMMENT=12;
    public static final int StringLiteral=13;
    public static final int StringType=14;
    public static final int ThenRW=15;
    public static final int TrueRW=16;
    public static final int WS=17;

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
        this.state.ruleMemo = new HashMap[34+1];
         

    }

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g"; }



    // $ANTLR start "question"
    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:17:1: question returns [Question result] : Ident ':' StringLiteral t= type ;
    public final Question question() throws RecognitionException {
        Question result = null;

        int question_StartIndex = input.index();

        Token Ident1=null;
        Token StringLiteral2=null;
        Type t =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:18:3: ( Ident ':' StringLiteral t= type )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:18:5: Ident ':' StringLiteral t= type
            {
            Ident1=(Token)match(input,Ident,FOLLOW_Ident_in_question49); if (state.failed) return result;

            match(input,27,FOLLOW_27_in_question51); if (state.failed) return result;

            StringLiteral2=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_question53); if (state.failed) return result;

            pushFollow(FOLLOW_type_in_question57);
            t=type();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new Question((Ident1!=null?Ident1.getText():null), (StringLiteral2!=null?StringLiteral2.getText():null), t); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 1, question_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "question"



    // $ANTLR start "type"
    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:23:1: type returns [Type result] : ( BooleanType | IntegerType | StringType );
    public final Type type() throws RecognitionException {
        Type result = null;

        int type_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:24:4: ( BooleanType | IntegerType | StringType )
            int alt1=3;
            switch ( input.LA(1) ) {
            case BooleanType:
                {
                alt1=1;
                }
                break;
            case IntegerType:
                {
                alt1=2;
                }
                break;
            case StringType:
                {
                alt1=3;
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
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:24:6: BooleanType
                    {
                    match(input,BooleanType,FOLLOW_BooleanType_in_type86); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new BooleanType(); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:25:6: IntegerType
                    {
                    match(input,IntegerType,FOLLOW_IntegerType_in_type95); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new IntegerType(); }

                    }
                    break;
                case 3 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:26:6: StringType
                    {
                    match(input,StringType,FOLLOW_StringType_in_type104); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new StringType(); }

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
            if ( state.backtracking>0 ) { memoize(input, 2, type_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "type"



    // $ANTLR start "reservedWord"
    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:29:1: reservedWord returns [ReservedWord result] : ( TrueRW | FalseRW | IfRW | ThenRW | ElseRW );
    public final ReservedWord reservedWord() throws RecognitionException {
        ReservedWord result = null;

        int reservedWord_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:30:2: ( TrueRW | FalseRW | IfRW | ThenRW | ElseRW )
            int alt2=5;
            switch ( input.LA(1) ) {
            case TrueRW:
                {
                alt2=1;
                }
                break;
            case FalseRW:
                {
                alt2=2;
                }
                break;
            case IfRW:
                {
                alt2=3;
                }
                break;
            case ThenRW:
                {
                alt2=4;
                }
                break;
            case ElseRW:
                {
                alt2=5;
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
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:30:4: TrueRW
                    {
                    match(input,TrueRW,FOLLOW_TrueRW_in_reservedWord122); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new TrueRW(); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:31:4: FalseRW
                    {
                    match(input,FalseRW,FOLLOW_FalseRW_in_reservedWord129); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new FalseRW(); }

                    }
                    break;
                case 3 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:32:4: IfRW
                    {
                    match(input,IfRW,FOLLOW_IfRW_in_reservedWord136); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new IfRW(); }

                    }
                    break;
                case 4 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:33:4: ThenRW
                    {
                    match(input,ThenRW,FOLLOW_ThenRW_in_reservedWord143); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new ThenRW(); }

                    }
                    break;
                case 5 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:34:4: ElseRW
                    {
                    match(input,ElseRW,FOLLOW_ElseRW_in_reservedWord150); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new ElseRW(); }

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
            if ( state.backtracking>0 ) { memoize(input, 3, reservedWord_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "reservedWord"



    // $ANTLR start "primary"
    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:39:1: primary returns [Expr result] : ( Int | Ident | StringLiteral | '(' x= orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;

        int primary_StartIndex = input.index();

        Token Int3=null;
        Token Ident4=null;
        Token StringLiteral5=null;
        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:40:3: ( Int | Ident | StringLiteral | '(' x= orExpr ')' )
            int alt3=4;
            switch ( input.LA(1) ) {
            case Int:
                {
                alt3=1;
                }
                break;
            case Ident:
                {
                alt3=2;
                }
                break;
            case StringLiteral:
                {
                alt3=3;
                }
                break;
            case 21:
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
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:40:5: Int
                    {
                    Int3=(Token)match(input,Int,FOLLOW_Int_in_primary172); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int3!=null?Int3.getText():null))); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:41:5: Ident
                    {
                    Ident4=(Token)match(input,Ident,FOLLOW_Ident_in_primary182); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident((Ident4!=null?Ident4.getText():null)); }

                    }
                    break;
                case 3 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:42:5: StringLiteral
                    {
                    StringLiteral5=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_primary190); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new StringLiteral((StringLiteral5!=null?StringLiteral5.getText():null)); }

                    }
                    break;
                case 4 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:5: '(' x= orExpr ')'
                    {
                    match(input,21,FOLLOW_21_in_primary198); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_primary202);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,22,FOLLOW_22_in_primary204); if (state.failed) return result;

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
            if ( state.backtracking>0 ) { memoize(input, 4, primary_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "primary"



    // $ANTLR start "unExpr"
    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:47:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;

        int unExpr_StartIndex = input.index();

        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:48:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
            int alt4=4;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt4=1;
                }
                break;
            case 25:
                {
                alt4=2;
                }
                break;
            case 18:
                {
                alt4=3;
                }
                break;
            case Ident:
            case Int:
            case StringLiteral:
            case 21:
                {
                alt4=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }

            switch (alt4) {
                case 1 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:48:7: '+' x= unExpr
                    {
                    match(input,24,FOLLOW_24_in_unExpr229); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr233);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Pos(x); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:49:7: '-' x= unExpr
                    {
                    match(input,25,FOLLOW_25_in_unExpr243); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr247);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Neg(x); }

                    }
                    break;
                case 3 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:50:7: '!' x= unExpr
                    {
                    match(input,18,FOLLOW_18_in_unExpr257); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr261);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Not(x); }

                    }
                    break;
                case 4 :
                    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:51:7: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr273);
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
            if ( state.backtracking>0 ) { memoize(input, 5, unExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "unExpr"



    // $ANTLR start "mulExpr"
    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:55:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;

        int mulExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:56:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:56:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr309);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:56:45: (op= ( '*' | '/' ) rhs= unExpr )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==23||LA5_0==26) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:56:47: op= ( '*' | '/' ) rhs= unExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==23||input.LA(1)==26 ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_unExpr_in_mulExpr329);
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
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, mulExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "mulExpr"



    // $ANTLR start "addExpr"
    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:68:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;

        int addExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:69:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:69:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr370);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:69:46: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= 24 && LA6_0 <= 25)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:69:48: op= ( '+' | '-' ) rhs= mulExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( (input.LA(1) >= 24 && input.LA(1) <= 25) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_mulExpr_in_addExpr388);
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
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, addExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "addExpr"



    // $ANTLR start "relExpr"
    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:80:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;

        int relExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:81:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:81:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr423);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:81:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==19||(LA7_0 >= 28 && LA7_0 <= 32)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:81:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==19||(input.LA(1) >= 28 && input.LA(1) <= 32) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_addExpr_in_relExpr447);
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
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, relExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "relExpr"



    // $ANTLR start "andExpr"
    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:104:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;

        int andExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:105:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:105:9: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr485);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:105:46: ( '&&' rhs= relExpr )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==20) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:105:48: '&&' rhs= relExpr
            	    {
            	    match(input,20,FOLLOW_20_in_andExpr491); if (state.failed) return result;

            	    pushFollow(FOLLOW_relExpr_in_andExpr495);
            	    rhs=relExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new And(result, rhs); }

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, andExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "andExpr"



    // $ANTLR start "orExpr"
    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:109:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;

        int orExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:110:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:110:9: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr530);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = lhs; }

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:110:48: ( '||' rhs= andExpr )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==33) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:110:50: '||' rhs= andExpr
            	    {
            	    match(input,33,FOLLOW_33_in_orExpr536); if (state.failed) return result;

            	    pushFollow(FOLLOW_andExpr_in_orExpr540);
            	    rhs=andExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new Or(result, rhs); }

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 10, orExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "orExpr"

    // Delegated rules


 

    public static final BitSet FOLLOW_Ident_in_question49 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_question51 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_StringLiteral_in_question53 = new BitSet(new long[]{0x0000000000004810L});
    public static final BitSet FOLLOW_type_in_question57 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BooleanType_in_type86 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IntegerType_in_type95 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringType_in_type104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TrueRW_in_reservedWord122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FalseRW_in_reservedWord129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IfRW_in_reservedWord136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ThenRW_in_reservedWord143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ElseRW_in_reservedWord150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Int_in_primary172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_primary190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_primary198 = new BitSet(new long[]{0x0000000003242500L});
    public static final BitSet FOLLOW_orExpr_in_primary202 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_primary204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_unExpr229 = new BitSet(new long[]{0x0000000003242500L});
    public static final BitSet FOLLOW_unExpr_in_unExpr233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_unExpr243 = new BitSet(new long[]{0x0000000003242500L});
    public static final BitSet FOLLOW_unExpr_in_unExpr247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_unExpr257 = new BitSet(new long[]{0x0000000003242500L});
    public static final BitSet FOLLOW_unExpr_in_unExpr261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr309 = new BitSet(new long[]{0x0000000004800002L});
    public static final BitSet FOLLOW_set_in_mulExpr317 = new BitSet(new long[]{0x0000000003242500L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr329 = new BitSet(new long[]{0x0000000004800002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr370 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_set_in_addExpr378 = new BitSet(new long[]{0x0000000003242500L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr388 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr423 = new BitSet(new long[]{0x00000001F0080002L});
    public static final BitSet FOLLOW_set_in_relExpr431 = new BitSet(new long[]{0x0000000003242500L});
    public static final BitSet FOLLOW_addExpr_in_relExpr447 = new BitSet(new long[]{0x00000001F0080002L});
    public static final BitSet FOLLOW_relExpr_in_andExpr485 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_andExpr491 = new BitSet(new long[]{0x0000000003242500L});
    public static final BitSet FOLLOW_relExpr_in_andExpr495 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr530 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_orExpr536 = new BitSet(new long[]{0x0000000003242500L});
    public static final BitSet FOLLOW_andExpr_in_orExpr540 = new BitSet(new long[]{0x0000000200000002L});

}