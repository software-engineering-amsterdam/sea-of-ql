// $ANTLR 3.4 /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g 2013-01-13 16:17:08

	package org.uva.sea.ql.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLLexer extends Lexer {
    public static final int EOF=-1;
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
    public static final int T__34=34;
    public static final int COMMENT=4;
    public static final int DIGIT=5;
    public static final int IDENTIFIER=6;
    public static final int INTEGER=7;
    public static final int LETTER=8;
    public static final int MULTILINE_COMMENT=9;
    public static final int STRING_LITERAL=10;
    public static final int WHITESPACE=11;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public QLLexer() {} 
    public QLLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public QLLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g"; }

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:11:7: ( '!' )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:11:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:12:7: ( '!=' )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:12:9: '!='
            {
            match("!="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:13:7: ( '&&' )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:13:9: '&&'
            {
            match("&&"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:14:7: ( '(' )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:14:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:15:7: ( ')' )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:15:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:16:7: ( '*' )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:16:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:17:7: ( '+' )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:17:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:18:7: ( '-' )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:18:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:19:7: ( '/' )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:19:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:20:7: ( ':' )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:20:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:21:7: ( '<' )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:21:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:22:7: ( '<=' )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:22:9: '<='
            {
            match("<="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:23:7: ( '==' )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:23:9: '=='
            {
            match("=="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:24:7: ( '>' )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:24:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:25:7: ( '>=' )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:25:9: '>='
            {
            match(">="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:26:7: ( 'boolean' )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:26:9: 'boolean'
            {
            match("boolean"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:27:7: ( 'else' )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:27:9: 'else'
            {
            match("else"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:28:7: ( 'form' )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:28:9: 'form'
            {
            match("form"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:29:7: ( 'if' )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:29:9: 'if'
            {
            match("if"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:30:7: ( 'integer' )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:30:9: 'integer'
            {
            match("integer"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:31:7: ( '{' )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:31:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:32:7: ( '||' )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:32:9: '||'
            {
            match("||"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:33:7: ( '}' )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:33:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "STRING_LITERAL"
    public final void mSTRING_LITERAL() throws RecognitionException {
        try {
            int _type = STRING_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            int c;

            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:156:2: ( '\"' ( '\\\\' '\"' |c=~ ( '\"' | '\\r' | '\\n' ) )* '\"' )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:156:4: '\"' ( '\\\\' '\"' |c=~ ( '\"' | '\\r' | '\\n' ) )* '\"'
            {
            match('\"'); 

             StringBuilder b = new StringBuilder(); 

            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:158:3: ( '\\\\' '\"' |c=~ ( '\"' | '\\r' | '\\n' ) )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='\\') ) {
                    int LA1_2 = input.LA(2);

                    if ( (LA1_2=='\"') ) {
                        int LA1_4 = input.LA(3);

                        if ( ((LA1_4 >= '\u0000' && LA1_4 <= '\t')||(LA1_4 >= '\u000B' && LA1_4 <= '\f')||(LA1_4 >= '\u000E' && LA1_4 <= '\uFFFF')) ) {
                            alt1=1;
                        }

                        else {
                            alt1=2;
                        }


                    }
                    else if ( ((LA1_2 >= '\u0000' && LA1_2 <= '\t')||(LA1_2 >= '\u000B' && LA1_2 <= '\f')||(LA1_2 >= '\u000E' && LA1_2 <= '!')||(LA1_2 >= '#' && LA1_2 <= '\uFFFF')) ) {
                        alt1=2;
                    }


                }
                else if ( ((LA1_0 >= '\u0000' && LA1_0 <= '\t')||(LA1_0 >= '\u000B' && LA1_0 <= '\f')||(LA1_0 >= '\u000E' && LA1_0 <= '!')||(LA1_0 >= '#' && LA1_0 <= '[')||(LA1_0 >= ']' && LA1_0 <= '\uFFFF')) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:158:5: '\\\\' '\"'
            	    {
            	    match('\\'); 

            	    match('\"'); 

            	     b.appendCodePoint('"');

            	    }
            	    break;
            	case 2 :
            	    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:159:5: c=~ ( '\"' | '\\r' | '\\n' )
            	    {
            	    c= input.LA(1);

            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	     b.appendCodePoint(c);

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            match('\"'); 

             setText(b.toString()); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING_LITERAL"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:166:17: ( ( 'a' .. 'z' | 'A' .. 'Z' ) )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:167:16: ( '0' .. '9' )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:168:9: ( ( DIGIT )+ )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:168:11: ( DIGIT )+
            {
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:168:11: ( DIGIT )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INTEGER"

    // $ANTLR start "IDENTIFIER"
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:169:12: ( LETTER ( LETTER | DIGIT | '_' )* )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:169:14: LETTER ( LETTER | DIGIT | '_' )*
            {
            mLETTER(); 


            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:169:21: ( LETTER | DIGIT | '_' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'Z')||LA3_0=='_'||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IDENTIFIER"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:170:12: ( ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+ )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:170:14: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
            {
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:170:14: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '\t' && LA4_0 <= '\n')||(LA4_0 >= '\f' && LA4_0 <= '\r')||LA4_0==' ') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:
            	    {
            	    if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHITESPACE"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:171:9: ( '//' ( . )* ( '\\n' | '\\r' ) )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:171:11: '//' ( . )* ( '\\n' | '\\r' )
            {
            match("//"); 



            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:171:16: ( . )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\n'||LA5_0=='\r') ) {
                    alt5=2;
                }
                else if ( ((LA5_0 >= '\u0000' && LA5_0 <= '\t')||(LA5_0 >= '\u000B' && LA5_0 <= '\f')||(LA5_0 >= '\u000E' && LA5_0 <= '\uFFFF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:171:16: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "MULTILINE_COMMENT"
    public final void mMULTILINE_COMMENT() throws RecognitionException {
        try {
            int _type = MULTILINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:172:19: ( '/*' ( . )* '*/' )
            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:172:21: '/*' ( . )* '*/'
            {
            match("/*"); 



            // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:172:26: ( . )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='*') ) {
                    int LA6_1 = input.LA(2);

                    if ( (LA6_1=='/') ) {
                        alt6=2;
                    }
                    else if ( ((LA6_1 >= '\u0000' && LA6_1 <= '.')||(LA6_1 >= '0' && LA6_1 <= '\uFFFF')) ) {
                        alt6=1;
                    }


                }
                else if ( ((LA6_0 >= '\u0000' && LA6_0 <= ')')||(LA6_0 >= '+' && LA6_0 <= '\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:172:26: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            match("*/"); 



            _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MULTILINE_COMMENT"

    public void mTokens() throws RecognitionException {
        // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:1:8: ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | STRING_LITERAL | INTEGER | IDENTIFIER | WHITESPACE | COMMENT | MULTILINE_COMMENT )
        int alt7=29;
        switch ( input.LA(1) ) {
        case '!':
            {
            int LA7_1 = input.LA(2);

            if ( (LA7_1=='=') ) {
                alt7=2;
            }
            else {
                alt7=1;
            }
            }
            break;
        case '&':
            {
            alt7=3;
            }
            break;
        case '(':
            {
            alt7=4;
            }
            break;
        case ')':
            {
            alt7=5;
            }
            break;
        case '*':
            {
            alt7=6;
            }
            break;
        case '+':
            {
            alt7=7;
            }
            break;
        case '-':
            {
            alt7=8;
            }
            break;
        case '/':
            {
            switch ( input.LA(2) ) {
            case '/':
                {
                alt7=28;
                }
                break;
            case '*':
                {
                alt7=29;
                }
                break;
            default:
                alt7=9;
            }

            }
            break;
        case ':':
            {
            alt7=10;
            }
            break;
        case '<':
            {
            int LA7_10 = input.LA(2);

            if ( (LA7_10=='=') ) {
                alt7=12;
            }
            else {
                alt7=11;
            }
            }
            break;
        case '=':
            {
            alt7=13;
            }
            break;
        case '>':
            {
            int LA7_12 = input.LA(2);

            if ( (LA7_12=='=') ) {
                alt7=15;
            }
            else {
                alt7=14;
            }
            }
            break;
        case 'b':
            {
            int LA7_13 = input.LA(2);

            if ( (LA7_13=='o') ) {
                int LA7_33 = input.LA(3);

                if ( (LA7_33=='o') ) {
                    int LA7_38 = input.LA(4);

                    if ( (LA7_38=='l') ) {
                        int LA7_43 = input.LA(5);

                        if ( (LA7_43=='e') ) {
                            int LA7_47 = input.LA(6);

                            if ( (LA7_47=='a') ) {
                                int LA7_51 = input.LA(7);

                                if ( (LA7_51=='n') ) {
                                    int LA7_53 = input.LA(8);

                                    if ( ((LA7_53 >= '0' && LA7_53 <= '9')||(LA7_53 >= 'A' && LA7_53 <= 'Z')||LA7_53=='_'||(LA7_53 >= 'a' && LA7_53 <= 'z')) ) {
                                        alt7=26;
                                    }
                                    else {
                                        alt7=16;
                                    }
                                }
                                else {
                                    alt7=26;
                                }
                            }
                            else {
                                alt7=26;
                            }
                        }
                        else {
                            alt7=26;
                        }
                    }
                    else {
                        alt7=26;
                    }
                }
                else {
                    alt7=26;
                }
            }
            else {
                alt7=26;
            }
            }
            break;
        case 'e':
            {
            int LA7_14 = input.LA(2);

            if ( (LA7_14=='l') ) {
                int LA7_34 = input.LA(3);

                if ( (LA7_34=='s') ) {
                    int LA7_39 = input.LA(4);

                    if ( (LA7_39=='e') ) {
                        int LA7_44 = input.LA(5);

                        if ( ((LA7_44 >= '0' && LA7_44 <= '9')||(LA7_44 >= 'A' && LA7_44 <= 'Z')||LA7_44=='_'||(LA7_44 >= 'a' && LA7_44 <= 'z')) ) {
                            alt7=26;
                        }
                        else {
                            alt7=17;
                        }
                    }
                    else {
                        alt7=26;
                    }
                }
                else {
                    alt7=26;
                }
            }
            else {
                alt7=26;
            }
            }
            break;
        case 'f':
            {
            int LA7_15 = input.LA(2);

            if ( (LA7_15=='o') ) {
                int LA7_35 = input.LA(3);

                if ( (LA7_35=='r') ) {
                    int LA7_40 = input.LA(4);

                    if ( (LA7_40=='m') ) {
                        int LA7_45 = input.LA(5);

                        if ( ((LA7_45 >= '0' && LA7_45 <= '9')||(LA7_45 >= 'A' && LA7_45 <= 'Z')||LA7_45=='_'||(LA7_45 >= 'a' && LA7_45 <= 'z')) ) {
                            alt7=26;
                        }
                        else {
                            alt7=18;
                        }
                    }
                    else {
                        alt7=26;
                    }
                }
                else {
                    alt7=26;
                }
            }
            else {
                alt7=26;
            }
            }
            break;
        case 'i':
            {
            switch ( input.LA(2) ) {
            case 'f':
                {
                int LA7_36 = input.LA(3);

                if ( ((LA7_36 >= '0' && LA7_36 <= '9')||(LA7_36 >= 'A' && LA7_36 <= 'Z')||LA7_36=='_'||(LA7_36 >= 'a' && LA7_36 <= 'z')) ) {
                    alt7=26;
                }
                else {
                    alt7=19;
                }
                }
                break;
            case 'n':
                {
                int LA7_37 = input.LA(3);

                if ( (LA7_37=='t') ) {
                    int LA7_42 = input.LA(4);

                    if ( (LA7_42=='e') ) {
                        int LA7_46 = input.LA(5);

                        if ( (LA7_46=='g') ) {
                            int LA7_50 = input.LA(6);

                            if ( (LA7_50=='e') ) {
                                int LA7_52 = input.LA(7);

                                if ( (LA7_52=='r') ) {
                                    int LA7_54 = input.LA(8);

                                    if ( ((LA7_54 >= '0' && LA7_54 <= '9')||(LA7_54 >= 'A' && LA7_54 <= 'Z')||LA7_54=='_'||(LA7_54 >= 'a' && LA7_54 <= 'z')) ) {
                                        alt7=26;
                                    }
                                    else {
                                        alt7=20;
                                    }
                                }
                                else {
                                    alt7=26;
                                }
                            }
                            else {
                                alt7=26;
                            }
                        }
                        else {
                            alt7=26;
                        }
                    }
                    else {
                        alt7=26;
                    }
                }
                else {
                    alt7=26;
                }
                }
                break;
            default:
                alt7=26;
            }

            }
            break;
        case '{':
            {
            alt7=21;
            }
            break;
        case '|':
            {
            alt7=22;
            }
            break;
        case '}':
            {
            alt7=23;
            }
            break;
        case '\"':
            {
            alt7=24;
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
            alt7=25;
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
        case 'c':
        case 'd':
        case 'g':
        case 'h':
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
            alt7=26;
            }
            break;
        case '\t':
        case '\n':
        case '\f':
        case '\r':
        case ' ':
            {
            alt7=27;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 7, 0, input);

            throw nvae;

        }

        switch (alt7) {
            case 1 :
                // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:1:10: T__12
                {
                mT__12(); 


                }
                break;
            case 2 :
                // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:1:16: T__13
                {
                mT__13(); 


                }
                break;
            case 3 :
                // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:1:22: T__14
                {
                mT__14(); 


                }
                break;
            case 4 :
                // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:1:28: T__15
                {
                mT__15(); 


                }
                break;
            case 5 :
                // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:1:34: T__16
                {
                mT__16(); 


                }
                break;
            case 6 :
                // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:1:40: T__17
                {
                mT__17(); 


                }
                break;
            case 7 :
                // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:1:46: T__18
                {
                mT__18(); 


                }
                break;
            case 8 :
                // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:1:52: T__19
                {
                mT__19(); 


                }
                break;
            case 9 :
                // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:1:58: T__20
                {
                mT__20(); 


                }
                break;
            case 10 :
                // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:1:64: T__21
                {
                mT__21(); 


                }
                break;
            case 11 :
                // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:1:70: T__22
                {
                mT__22(); 


                }
                break;
            case 12 :
                // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:1:76: T__23
                {
                mT__23(); 


                }
                break;
            case 13 :
                // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:1:82: T__24
                {
                mT__24(); 


                }
                break;
            case 14 :
                // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:1:88: T__25
                {
                mT__25(); 


                }
                break;
            case 15 :
                // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:1:94: T__26
                {
                mT__26(); 


                }
                break;
            case 16 :
                // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:1:100: T__27
                {
                mT__27(); 


                }
                break;
            case 17 :
                // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:1:106: T__28
                {
                mT__28(); 


                }
                break;
            case 18 :
                // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:1:112: T__29
                {
                mT__29(); 


                }
                break;
            case 19 :
                // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:1:118: T__30
                {
                mT__30(); 


                }
                break;
            case 20 :
                // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:1:124: T__31
                {
                mT__31(); 


                }
                break;
            case 21 :
                // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:1:130: T__32
                {
                mT__32(); 


                }
                break;
            case 22 :
                // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:1:136: T__33
                {
                mT__33(); 


                }
                break;
            case 23 :
                // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:1:142: T__34
                {
                mT__34(); 


                }
                break;
            case 24 :
                // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:1:148: STRING_LITERAL
                {
                mSTRING_LITERAL(); 


                }
                break;
            case 25 :
                // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:1:163: INTEGER
                {
                mINTEGER(); 


                }
                break;
            case 26 :
                // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:1:171: IDENTIFIER
                {
                mIDENTIFIER(); 


                }
                break;
            case 27 :
                // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:1:182: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;
            case 28 :
                // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:1:193: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 29 :
                // /Users/ammarhamidbasymeleh/sea-of-ql/ammarhamid/QLJava2/src/main/org/uva/sea/ql/parser/QL.g:1:201: MULTILINE_COMMENT
                {
                mMULTILINE_COMMENT(); 


                }
                break;

        }

    }


 

}