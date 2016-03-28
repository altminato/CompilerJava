/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scanner;

import tokens.*;

/**
 *
 * @author Antonio
 */
public abstract class Scanner {
    protected WordToken wordToken;
    protected NumberToken numberToken;
    protected StringToken stringToken;
    protected SpecialToken specialToken;
    protected EOFToken eofToken;
    protected ErrorToken errorToken;
    
    public Scanner(){
        wordToken=new WordToken();
        numberToken= new NumberToken();
        stringToken= new StringToken();
        specialToken=new SpecialToken();
        eofToken=new EOFToken();
        errorToken=new ErrorToken();
    }
    
    public abstract Token getToken();
}
