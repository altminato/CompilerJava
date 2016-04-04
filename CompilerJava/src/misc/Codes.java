/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misc;

/**
 *
 * @author Antonio
 */
public final class Codes {
    
    public static enum CharCode{
      LETTER, DIGIT, SPECIAL, QUOTE, WHITESPACE, END_OF_FILE, ERROR
    };
    
    public static enum TokenCode{
        DUMMY, IDENTIFIER, NUMBER, STRING, END_OF_FILE, ERROR,
        
        UP_ARROW, STAR, L_PAREN, R_PAREN, MINUS, PLUS,
        EQUAL, L_BRACKET, R_BRACKET, COLON, SEMICOLON, LT,
        GT, COMMA, PERIOD, SLASH, COLONEQUAL, LE, GE,
        NE, DOTDOT,
        
        AND, ARRAY, BEGIN, CASE, CONST, DIV,
        DO, DOWNTO, ELSE, END, FILE, FOR, FUNCTION,
        GOTO, IF, IN, LABEL, MOD, NIL, NOT, OF, OR,
        PACKED, PROCEDURE, PROGRAM, RECORD, REPEAT, SET,
        THEN, TO, TYPE, UNTIL, VAR, WHILE, WITH
    };
    
    public static enum DataType{
      DUMMY, INTEGER, REAL, CHARACTER, STRING  
      
    };
            
}
