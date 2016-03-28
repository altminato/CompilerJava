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
        DUMMY, WORD, NUMBER, PERIOD, END_OF_FILE, ERROR
    };
    
    public static enum DataType{
      DUMMY, INTEGER, REAL, CHARACTER, STRING  
    };
            
}
