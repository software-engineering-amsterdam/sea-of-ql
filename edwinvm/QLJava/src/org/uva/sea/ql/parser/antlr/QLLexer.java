package org.uva.sea.ql.parser.antlr;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import org.antlr.runtime.*;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLLexer extends Lexer {
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

    // Delegates
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public QLLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    
    public QLLexer(CharStream input, RecognizerSharedState state) {
        super(input, state);
    }
    
    public String getGrammarFileName() { 
    	return "/Users/tvdstorm/SEA/courses/sc/2012-2013/repos/sc-ql-2012-2013-java/src/org/uva/sea/ql/parser/antlr/QL.g"; 
    }

    // $ANTLR start "T__8"
    public final void matchT__8() throws RecognitionException {
        try {
        	int type = _T__8;
            int channel = DEFAULT_TOKEN_CHANNEL;
            {
            	match('!'); 
            }
            state.type = type;
            state.channel = channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__8"

    // $ANTLR start "T__9"
    public final void matchT__9() throws RecognitionException {
        try {
            int type = _T__9;
            int channel = DEFAULT_TOKEN_CHANNEL;
            {
            	match("!="); 
            }
            state.type = type;
            state.channel = channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void matchT__10() throws RecognitionException {
        try {
            int type = _T__10;
            int channel = DEFAULT_TOKEN_CHANNEL;
            {
            	match("&&"); 
            }
            state.type = type;
            state.channel = channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void matchT__11() throws RecognitionException {
        try {
            int type = _T__11;
            int channel = DEFAULT_TOKEN_CHANNEL;
            {
            	match('('); 
            }
            state.type = type;
            state.channel = channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void matchT__12() throws RecognitionException {
        try {
            int type = _T__12;
            int channel = DEFAULT_TOKEN_CHANNEL;
            {
            	match(')'); 
            }
            state.type = type;
            state.channel = channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void matchT__13() throws RecognitionException {
        try {
            int type = _T__13;
            int channel = DEFAULT_TOKEN_CHANNEL;
            {
            	match('*'); 
            }
            state.type = type;
            state.channel = channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void matchT__14() throws RecognitionException {
        try {
            int type = _T__14;
            int channel = DEFAULT_TOKEN_CHANNEL;
            {
            	match('+'); 
            }
            state.type = type;
            state.channel = channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void matchT__15() throws RecognitionException {
        try {
            int type = _T__15;
            int channel = DEFAULT_TOKEN_CHANNEL;
            {
            	match('-'); 
            }
            state.type = type;
            state.channel = channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void matchT__16() throws RecognitionException {
        try {
            int type = _T__16;
            int channel = DEFAULT_TOKEN_CHANNEL;
            {
            	match('/'); 
            }
            state.type = type;
            state.channel = channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void matchT__17() throws RecognitionException {
        try {
            int type = _T__17;
            int channel = DEFAULT_TOKEN_CHANNEL;
            {
            	match('<'); 
            }
            state.type = type;
            state.channel = channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void matchT__18() throws RecognitionException {
        try {
            int type = _T__18;
            int channel = DEFAULT_TOKEN_CHANNEL;
            {
            	match("<="); 
            }
            state.type = type;
            state.channel = channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void matchT__19() throws RecognitionException {
        try {
            int type = _T__19;
            int channel = DEFAULT_TOKEN_CHANNEL;
            {
            	match("=="); 
            }
            state.type = type;
            state.channel = channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void matchT__20() throws RecognitionException {
        try {
            int type = _T__20;
            int channel = DEFAULT_TOKEN_CHANNEL;
            {
            	match('>'); 
            }
            state.type = type;
            state.channel = channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void matchT__21() throws RecognitionException {
        try {
            int type = _T__21;
            int channel = DEFAULT_TOKEN_CHANNEL;
            {
            	match(">="); 
            }
            state.type = type;
            state.channel = channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void matchT__22() throws RecognitionException {
        try {
            int type = _T__22;
            int channel = DEFAULT_TOKEN_CHANNEL;
            {
            	match("||"); 
            }
            state.type = type;
            state.channel = channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "WS"
    public final void matchWs() throws RecognitionException {
        try {
            int type = _WS;
            int channel = DEFAULT_TOKEN_CHANNEL;
            // Match input on ( ' ' | '\\t' | '\\n' | '\\r' ) )
            {
            	// Look Ahead on given Lexer input CharStream
            	// Check if input matches WhiteSpace
            	if ((input.LA(1) >= '\t' && input.LA(1) <= '\n') || 
            		 input.LA(1) == '\r' || 
            		 input.LA(1) == ' ') {
            		input.consume();
	            } else {
	                MismatchedSetException mse = new MismatchedSetException(null, input);
	                recover(mse);
	                throw mse;
	            }
            	channel = HIDDEN; 
            }
            state.type = type;
            state.channel = channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "COMMENT"
    public final void matchComment() throws RecognitionException {
        try {
            int type = _COMMENT;
            int channel = DEFAULT_TOKEN_CHANNEL;
            
            // Match input on Multi line comment ( '/*' ( . )* '*/' )
            {
            	match("/*"); 
            	// ( . )*
	            loop1:
	            do {
	                int alt1 = 2;
	                int lA1_0 = input.LA(1);
	
	                if (lA1_0 == '*') {
	                	int lA1_1 = input.LA(2);
	
	                    if (lA1_1 == '/') {
	                        alt1 = 2;
	                    }
	                    else if (((lA1_1 >= '\u0000' && lA1_1 <= '.') ||
	                    		  (lA1_1 >= '0' && lA1_1 <= '\uFFFF'))) {
	                        alt1 = 1;
	                    }
	                }
	                else if (((lA1_0 >= '\u0000' && lA1_0 <= ')') || 
	                		  (lA1_0 >= '+' && lA1_0 <= '\uFFFF'))) {
	                    alt1=1;
	                }
		
	                switch (alt1) {
		            	case 1 :
		            	    {
		            	    	matchAny();
		            	    }
		            	    break;
		            	default :
		            	    break loop1;
	                }
	            } while (true);
	            
            	match("*/"); 
            	channel = HIDDEN;
            }

            state.type = type;
            state.channel = channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "Ident"
    public final void matchIdent() throws RecognitionException {
        try {
            int type = _IDENT;
            int channel = DEFAULT_TOKEN_CHANNEL;
            
            // Match input on ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            {
	            if ((input.LA(1) >= 'A' && input.LA(1) <= 'Z') || 
	            	(input.LA(1) >= 'a' && input.LA(1) <= 'z')) {
	                input.consume();
	            } else {
	                MismatchedSetException mse = new MismatchedSetException(null, input);
	                recover(mse);
	                throw mse;
	            }

	            loop2:
	            do {
	                int alt2 = 2;
	                int lA2_0 = input.LA(1);
	
	                if (((lA2_0 >= '0' && lA2_0 <= '9') || 
	                	 (lA2_0 >= 'A' && lA2_0 <= 'Z') || 
	                	  lA2_0 == '_' || 
	                	 (lA2_0 >= 'a' && lA2_0 <= 'z'))) {
	                	alt2 = 1;
	                }
	
	                switch (alt2) {
		            	case 1 :
		            	    {
			            	    if ((input.LA(1) >= '0' && input.LA(1) <= '9') || 
			            	    	(input.LA(1) >= 'A' && input.LA(1) <= 'Z') || 
			            	    	 input.LA(1) == '_' || 
			            	    	(input.LA(1) >= 'a' && input.LA(1) <= 'z')) {
			            	        input.consume();
			            	    }
			            	    else {
			            	        MismatchedSetException mse = new MismatchedSetException(null, input);
			            	        recover(mse);
			            	        throw mse;
			            	    }
		            	    }
		            	    break;
		            	default :
		            	    break loop2;
	                }
	            } while (true);
            }

            state.type = type;
            state.channel = channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Ident"

    // $ANTLR start "Int"
    public final void matchInt() throws RecognitionException {
        try {
            int type = _INT;
            int channel = DEFAULT_TOKEN_CHANNEL;
            
            // Match input on ( ( '0' .. '9' )+ )
            {
	            int cnt3 = 0;
	            loop3:
	            do {
	                int alt3 = 2;
	                int lA3_0 = input.LA(1);
	
	                if (lA3_0 >= '0' && lA3_0 <= '9') {
	                    alt3 = 1;
	                }
		
	                switch (alt3) {
		            	case 1 :
		            	    {
			            	    if (input.LA(1) >= '0' && input.LA(1) <= '9') {
			            	        input.consume();
			            	    } else {
			            	        MismatchedSetException mse = new MismatchedSetException(null, input);
			            	        recover(mse);
			            	        throw mse;
			            	    }
		            	    }
		            	    break;
		            	default :
		            	    if (cnt3 >= 1 ) {
		            	    	break loop3;
		            	    }
	                        EarlyExitException eee = new EarlyExitException(3, input);
	                        throw eee;
	                }
	                cnt3++;
	            } while (true);
            }

            state.type = type;
            state.channel = channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Int"

    public void mTokens() throws RecognitionException {
        // Match tokens ( T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | WS | COMMENT | IDENT | INT )
        int alt4 = 19;
        
        switch (input.LA(1)) {
	        case '!':
	            {
	            	int lA4_1 = input.LA(2);
		            if (lA4_1 == '=') {
		                alt4 = 2;
		            } else {
		                alt4 = 1;
		            }
	            }
	            break;
	        case '&':
	            {
	            	alt4 = 3;
	            }
	            break;
	        case '(':
	            {
	            	alt4 = 4;
	            }
	            break;
	        case ')':
	            {
	            	alt4 = 5;
	            }
	            break;
	        case '*':
	            {
	            	alt4 = 6;
	            }
	            break;
	        case '+':
	            {
	            	alt4 = 7;
	            }
	            break;
	        case '-':
	            {
	            	alt4 = 8;
	            }
	            break;
	        case '/':
	            {
	            	int lA4_8 = input.LA(2);
		            if (lA4_8 == '*') {
		                alt4 = 17;
		            } else {
		                alt4 = 9;
		            }
	            }
	            break;
	        case '<':
	            {
		            int lA4_9 = input.LA(2);
		            if (lA4_9 == '=') {
		                alt4 = 11;
		            } else {
		                alt4 = 10;
		            }
	            }
	            break;
	        case '=':
	            {
	            	alt4 = 12;
	            }
	            break;
	        case '>':
	            {
		            int lA4_11 = input.LA(2);
		            if (lA4_11 == '=') {
		                alt4 = 14;
		            } else {
		                alt4 = 13;
		            }
	            }
	            break;
	        case '|':
	            {
	            	alt4 = 15;
	            }
	            break;
	        case '\t':
	        case '\n':
	        case '\r':
	        case ' ':
	            {
	            	alt4 = 16;
	            }
	            break;
	        case 'A':
	        case 'B':
	        case 'C':
	        case 'D':
	        case 'E':
	        case 'F':
	        case 'G':
	        case 'H':
	        case 'I':
	        case 'J':
	        case 'K':
	        case 'L':
	        case 'M':
	        case 'N':
	        case 'O':
	        case 'P':
	        case 'Q':
	        case 'R':
	        case 'S':
	        case 'T':
	        case 'U':
	        case 'V':
	        case 'W':
	        case 'X':
	        case 'Y':
	        case 'Z':
	        case 'a':
	        case 'b':
	        case 'c':
	        case 'd':
	        case 'e':
	        case 'f':
	        case 'g':
	        case 'h':
	        case 'i':
	        case 'j':
	        case 'k':
	        case 'l':
	        case 'm':
	        case 'n':
	        case 'o':
	        case 'p':
	        case 'q':
	        case 'r':
	        case 's':
	        case 't':
	        case 'u':
	        case 'v':
	        case 'w':
	        case 'x':
	        case 'y':
	        case 'z':
	            {
	            	alt4 = 18;
	            }
	            break;
	        case '0':
	        case '1':
	        case '2':
	        case '3':
	        case '4':
	        case '5':
	        case '6':
	        case '7':
	        case '8':
	        case '9':
	            {
	            	alt4 = 19;
	            }
	            break;
	        default:
	            NoViableAltException nvae = new NoViableAltException("", 4, 0, input);
	            throw nvae;
        }

        switch (alt4) {
            case 1 :
                {
                	matchT__8(); 
                }
                break;
            case 2 :
                {
                	matchT__9(); 
                }
                break;
            case 3 :
                {
                	matchT__10(); 
                }
                break;
            case 4 :
                {
                	matchT__11(); 
                }
                break;
            case 5 :
                {
                	matchT__12(); 
                }
                break;
            case 6 :
                {
                	matchT__13(); 
                }
                break;
            case 7 :
                {
                	matchT__14(); 
                }
                break;
            case 8 :
                {
                	matchT__15(); 
                }
                break;
            case 9 :
                {
                	matchT__16(); 
                }
                break;
            case 10 :
                {
                	matchT__17(); 
                }
                break;
            case 11 :
                {
                	matchT__18(); 
                }
                break;
            case 12 :
                {
                	matchT__19(); 
                }
                break;
            case 13 :
                {
                	matchT__20(); 
                }
                break;
            case 14 :
                {
                	matchT__21(); 
                }
                break;
            case 15 :
                {
                	matchT__22(); 
                }
                break;
            case 16 :
                {
                	matchWs(); 
                }
                break;
            case 17 :
                {
                	matchComment(); 
                }
                break;
            case 18 :
                {
                	matchIdent(); 
                }
                break;
            case 19 :
                {
                	matchInt(); 
                }
                break;
            default:
            	break;
        }
    }
}