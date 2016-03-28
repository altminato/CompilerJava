/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scanner;

import buffer.TextInBuffer;
import tokens.Token;

/**
 *
 * @author Antonio
 */
public class TextScanner extends Scanner{
    
    protected TextInBuffer buffer;
    
    public TextScanner(TextInBuffer buffer){
        super();
        this.buffer=buffer;
    }
    
    @Override
    public Token getToken(){
        return null;
    }
    
    public void skipWhiteSpace(){
        
    }
    
    
}
