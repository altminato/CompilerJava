/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokens;

import buffer.TextInBuffer;

/**
 *
 * @author Antonio
 */
public class ErrorToken extends Token {
    public ErrorToken(){
        super();
    }
    
    @Override
    public void getToken(TextInBuffer buffer){
        string="";
        string+=buffer.getCurrentChar();
        buffer.getChar();
    }
    
    @Override
    public void Print(){
        
    }
}
